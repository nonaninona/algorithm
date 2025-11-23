import os
import re
import subprocess
import requests
import sys
import unicodedata
import traceback
from datetime import datetime, timezone, timedelta

# ================= 로깅 헬퍼 =================
def log(msg):
    print(f"[DEBUG] {msg}", flush=True)

# ================= 환경 변수 확인 =================
NOTION_TOKEN = os.environ.get("NOTION_TOKEN")
DATABASE_ID = os.environ.get("DATABASE_ID")

log("=== 환경 변수 확인 ===")
if NOTION_TOKEN:
    log(f"NOTION_TOKEN: {NOTION_TOKEN[:4]}****... (로드됨)")
else:
    log("🚨 NOTION_TOKEN이 없습니다! Secrets 설정을 확인하세요.")

if DATABASE_ID:
    log(f"DATABASE_ID: {DATABASE_ID[:4]}****... (로드됨)")
else:
    log("🚨 DATABASE_ID가 없습니다! Secrets 설정을 확인하세요.")
log("=======================")

PROP_NAME = "이름"
PROP_TAGS = "분류"
PROP_DATE = "날짜"

headers = {
    "Authorization": f"Bearer {NOTION_TOKEN}",
    "Content-Type": "application/json",
    "Notion-Version": "2022-06-28"
}

KST = timezone(timedelta(hours=9))

def get_changed_files():
    """Git 명령어로 이번 커밋에서 변경된 파일 목록을 가져옵니다."""
    try:
        # -c core.quotePath=false : 한글 깨짐 방지 필수 옵션
        cmd = ["git", "-c", "core.quotePath=false", "diff", "--name-only", "HEAD~1", "HEAD"]
        log(f"Git 명령 실행: {' '.join(cmd)}")
        
        output = subprocess.check_output(cmd).decode('utf-8').strip()
        log(f"Git Raw Output:\n{output}")  # 실제 Git이 뱉은 날것의 데이터 확인
        
        if not output:
            return []
            
        files = output.split('\n')
        # 따옴표 제거 및 공백 제거
        cleaned_files = [f.strip().strip('"') for f in files]
        return cleaned_files
        
    except Exception as e:
        log(f"🚨 Git 변경사항 추출 실패: {e}")
        traceback.print_exc()
        return []

def get_git_first_commit_date(file_path):
    abs_path = os.path.abspath(file_path)
    abs_path = unicodedata.normalize('NFC', abs_path)
    try:
        cmd = ["git", "-c", "core.quotePath=false", "log", "--reverse", "--follow", "--format=%cI", "--", abs_path]
        output = subprocess.check_output(cmd, stderr=subprocess.STDOUT).decode('utf-8').strip()
        if output:
            date_str = output.split('\n')[0]
            log(f"  📅 Git 날짜 추출 성공: {date_str}")
            return date_str
    except: 
        pass
    log(f"  ⚠️ Git 날짜 추출 실패 -> 현재 시간 사용")
    return datetime.now(KST).isoformat()

def parse_category(readme_path):
    if not os.path.exists(readme_path): 
        log(f"  ⚠️ README 없음: {readme_path}")
        return []
    try:
        with open(readme_path, 'r', encoding='utf-8') as f: content = f.read()
        match = re.search(r'###\s+분류\s*\n+(.+?)\n', content)
        if match: 
            tags = [tag.strip() for tag in match.group(1).split(',')]
            log(f"  🏷️ 태그 파싱: {tags}")
            return tags
    except Exception as e:
        log(f"  ⚠️ 태그 파싱 에러: {e}")
    return []

def create_notion_page(title, tags, date_str, content_path):
    try:
        with open(content_path, 'r', encoding='utf-8') as f: body_text = f.read()
        log(f"  📄 본문 읽기 성공 ({len(body_text)}자)")
    except Exception as e:
        log(f"  ❌ 파일 읽기 실패: {e}")
        return False
    
    children_blocks = []
    for chunk in [body_text[i:i+2000] for i in range(0, len(body_text), 2000)]:
        children_blocks.append({
            "object": "block", "type": "paragraph",
            "paragraph": {"rich_text": [{"type": "text", "text": {"content": chunk}}]}
        })

    data = {
        "parent": {"database_id": DATABASE_ID},
        "properties": {
            PROP_NAME: {"title": [{"text": {"content": title}}]},
            PROP_TAGS: {"multi_select": [{"name": tag} for tag in tags]},
            PROP_DATE: {"date": {"start": date_str}}
        },
        "children": children_blocks[:100]
    }

    try:
        log(f"  📡 Notion API 요청 전송: {title}")
        res = requests.post("https://api.notion.com/v1/pages", headers=headers, json=data)
        
        if res.status_code == 200:
            log(f"  ✅ [업로드 완료] {title}")
            return True
        else:
            log(f"  ❌ [API 에러] Status: {res.status_code}")
            log(f"  ❌ [에러 메시지] {res.text}")
    except Exception as e:
        log(f"  ❌ [네트워크 에러] {e}")
    return False

def main():
    log("🚀 [동기화 스크립트 시작]")
    
    # 1. 파일 목록 가져오기
    changed_files = get_changed_files()
    log(f"📋 감지된 변경 파일 목록 ({len(changed_files)}개): {changed_files}")
    
    target_folders = set()
    
    # 2. 필터링 로직 상세 로깅
    for file_path in changed_files:
        log(f"🔍 검사 중: {file_path}")
        
        # 경로 정규화 (혹시 모를 슬래시/역슬래시 이슈 방지)
        norm_path = os.path.normpath(file_path)
        
        if file_path.endswith("think.md"):
            folder_path = os.path.dirname(file_path)
            log(f"  👉 'think.md' 발견! 타겟 폴더 추가: {folder_path}")
            target_folders.add(folder_path)
        else:
            log(f"  👉 Skip (think.md 아님)")

    if not target_folders:
        log("💤 처리할 타겟 폴더가 없습니다. 스크립트를 종료합니다.")
        return

    log(f"🎯 최종 처리 대상 폴더: {target_folders}")

    # 3. 실제 처리
    for root in target_folders:
        folder_name = os.path.basename(root)
        think_path = os.path.join(root, "think.md")
        readme_path = os.path.join(root, "README.md")
        
        log(f"\n📂 Processing Folder: {folder_name}")
        log(f"   - Root: {root}")
        log(f"   - Think Path: {think_path}")
        
        # 파일 존재 여부 더블 체크
        if not os.path.exists(think_path):
            log(f"   ⚠️ 실제 경로에 파일이 없음! (삭제된 파일일 수 있음) -> Skip")
            continue

        tags = []
        if os.path.exists(readme_path): 
            tags = parse_category(readme_path)
        else:
            log(f"   ℹ️ README.md 없음")

        if not tags:
            if "SWEA" in root: tags.append("SWEA")
            elif "프로그래머스" in root: tags.append("Programmers")
            else: tags.append("Uncategorized")
            log(f"   🏷️ 기본 태그 적용: {tags}")
            
        solved_date = get_git_first_commit_date(think_path)
        create_notion_page(folder_name, tags, solved_date, think_path)

if __name__ == "__main__":
    main()

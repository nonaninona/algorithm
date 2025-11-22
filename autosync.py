import os
import re
import subprocess
import requests
import sys
import unicodedata
from datetime import datetime, timezone, timedelta

# ================= 환경 변수에서 값 가져오기 =================
# GitHub Secrets에 등록할 예정이라 코드에는 빈 문자열이나 None 처리
NOTION_TOKEN = os.environ.get("NOTION_TOKEN")
DATABASE_ID = os.environ.get("DATABASE_ID")
# ========================================================

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
        # HEAD~1(직전 커밋)과 HEAD(현재 커밋) 사이의 변경된 파일 이름만 추출
        cmd = ["git", "diff", "--name-only", "HEAD~1", "HEAD"]
        output = subprocess.check_output(cmd).decode('utf-8').strip()
        return output.split('\n') if output else []
    except Exception as e:
        print(f"⚠️ Git 변경사항 추출 실패: {e}")
        return []

def get_git_first_commit_date(file_path):
    # ... (기존 migrate.py의 로직과 동일, 생략 없이 넣어주세요) ...
    # 편의를 위해 아래에 전체 코드를 제공할 때 포함하겠습니다.
    abs_path = os.path.abspath(file_path)
    abs_path = unicodedata.normalize('NFC', abs_path)
    try:
        cmd = ["git", "log", "--reverse", "--follow", "--format=%cI", "--", abs_path]
        output = subprocess.check_output(cmd, stderr=subprocess.STDOUT).decode('utf-8').strip()
        if output: return output.split('\n')[0]
    except: pass
    return datetime.now(KST).isoformat()

def parse_category(readme_path):
    # ... (기존 로직 동일) ...
    if not os.path.exists(readme_path): return []
    try:
        with open(readme_path, 'r', encoding='utf-8') as f: content = f.read()
        match = re.search(r'###\s+분류\s*\n+(.+?)\n', content)
        if match: return [tag.strip() for tag in match.group(1).split(',')]
    except: pass
    return []

def create_notion_page(title, tags, date_str, content_path):
    # ... (기존 로직 동일) ...
    try:
        with open(content_path, 'r', encoding='utf-8') as f: body_text = f.read()
    except: return False
    
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
        res = requests.post("https://api.notion.com/v1/pages", headers=headers, json=data)
        if res.status_code == 200:
            print(f"✅ [업로드 완료] {title}")
            return True
        else:
            print(f"❌ [API 에러] {res.text}")
    except Exception as e:
        print(f"❌ [네트워크 에러] {e}")
    return False

def main():
    print(f"🚀 [동기화 시작]")
    
    # 1. 변경된 파일 목록 가져오기
    changed_files = get_changed_files()
    
    # 2. 처리할 폴더 집합 (중복 제거)
    target_folders = set()
    
    for file_path in changed_files:
        # think.md나 소스코드(.py, .java 등)가 바뀌었을 때만 반응
        if file_path.endswith("think.md") or file_path.endswith(".py") or file_path.endswith(".java"):
            # 해당 파일이 있는 폴더 경로 추출
            folder_path = os.path.dirname(file_path)
            if os.path.exists(os.path.join(folder_path, "think.md")):
                target_folders.add(folder_path)

    if not target_folders:
        print("💤 변경된 문제 풀이(think.md 등)가 없습니다.")
        return

    print(f"🔍 감지된 변경 폴더: {len(target_folders)}개")

    # 3. 변경된 폴더에 대해서만 로직 수행
    for root in target_folders:
        folder_name = os.path.basename(root)
        think_path = os.path.join(root, "think.md")
        readme_path = os.path.join(root, "README.md")
        
        print(f"   Processing: {folder_name}")
        
        tags = []
        if os.path.exists(readme_path): tags = parse_category(readme_path)
        if not tags:
            if "SWEA" in root: tags.append("SWEA")
            elif "프로그래머스" in root: tags.append("Programmers")
            else: tags.append("Uncategorized")
            
        solved_date = get_git_first_commit_date(think_path)
        create_notion_page(folder_name, tags, solved_date, think_path)

if __name__ == "__main__":
    main()

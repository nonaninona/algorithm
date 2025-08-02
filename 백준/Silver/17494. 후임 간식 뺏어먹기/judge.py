import os
import subprocess
import time

# --- 설정 ---
JAVA_SOURCE_FILE = "Main.java"
# 컴파일된 클래스 파일 이름 (소스 파일 이름에서 .java를 뺀 것)
JAVA_CLASS_NAME = JAVA_SOURCE_FILE.split('.')[0]
# 테스트 케이스 파일들이 있는 디렉토리 (현재 디렉토리를 의미)
TESTCASE_DIRECTORY = "." 
# 각 테스트 케이스의 시간 제한 (초)
TIME_LIMIT = 2

# --- ANSI 색상 코드 (결과를 더 잘 보이게 하기 위함) ---
class Color:
    GREEN = '\033[92m'
    RED = '\033[91m'
    YELLOW = '\033[93m'
    BLUE = '\033[94m'
    END = '\033[0m'

# --- 메인 로직 ---
def main():
    # 1. 자바 소스 파일 컴파일
    print(f"{Color.BLUE}Compiling {JAVA_SOURCE_FILE}...{Color.END}")
    compile_process = subprocess.run(
        ['javac', JAVA_SOURCE_FILE], 
        capture_output=True, text=True
    )

    if compile_process.returncode != 0:
        print(f"{Color.RED}--- Compilation Failed! ---{Color.END}")
        print(compile_process.stderr)
        return
    print(f"{Color.GREEN}Compilation Successful!{Color.END}\n")

    # 2. 현재 디렉토리에서 .in 파일 목록 찾기
    try:
        files = os.listdir(TESTCASE_DIRECTORY)
        test_files = sorted([f for f in files if f.endswith('.in')])
        if not test_files:
            print(f"{Color.YELLOW}No .in files found in the current directory.{Color.END}")
            return
    except FileNotFoundError:
        print(f"{Color.RED}Error: Directory '{TESTCASE_DIRECTORY}' not found.{Color.END}")
        return

    # 3. 각 테스트 케이스에 대해 실행 및 채점
    total_cases = len(test_files)
    correct_cases = 0

    for i, input_file in enumerate(test_files):
        output_file = input_file.replace('.in', '.out')
        
        print(f"{Color.BLUE}[Test Case {i+1}/{total_cases}: {input_file}]{Color.END}")
        print(output_file)
        if not os.path.exists(output_file):
            print(f"{Color.YELLOW}  -> Warning: Corresponding output file '{output_file}' not found. Skipping.{Color.END}\n")
            continue

        with open(input_file, 'r', encoding='utf-8') as f_in:
            input_data = f_in.read()
        
        with open(output_file, 'r', encoding='utf-8') as f_out:
            expected_output = f_out.read().strip()

        try:
            start_time = time.time()
            # 4. 자바 프로그램 실행 및 입출력 처리
            run_process = subprocess.run(
                ['java', JAVA_CLASS_NAME],
                input=input_data,
                capture_output=True, text=True,
                timeout=TIME_LIMIT
            )
            end_time = time.time()
            
            user_output = run_process.stdout.strip()

            if run_process.stderr:
                 print(f"{Color.RED}  -> Runtime Error!{Color.END}")
                 print(run_process.stderr)
                 continue

            # 5. 결과 비교
            if user_output == expected_output:
                print(f"{Color.GREEN}  -> Correct! ({(end_time - start_time):.3f}s){Color.END}\n")
                correct_cases += 1
            else:
                print(f"{Color.RED}  -> Wrong Answer!{Color.END}")
                print(f"{Color.YELLOW}  Your Output:{Color.END}\n{user_output}")
                print(f"{Color.YELLOW}  Expected Output:{Color.END}\n{expected_output}\n")

        except subprocess.TimeoutExpired:
            print(f"{Color.RED}  -> Time Limit Exceeded! (>{TIME_LIMIT}s){Color.END}\n")
        except Exception as e:
            print(f"{Color.RED}  -> An unexpected error occurred: {e}{Color.END}\n")

    print(f"--- Result: {correct_cases} / {total_cases} Correct ---")


if __name__ == "__main__":
    main()

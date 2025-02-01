# 생각의 흐름
와.. 프로그래머스에서 똑같은 문제 풀었었는데, 그때도 못 풀고 이번에도 못 품 레쟌드
1. 앞 자리수가 제일 커야 함. 그래서 예전에 재귀로 풀었었는데 시간 복잡도 터졌던 기억이 남. 예를 들어 9999999... 인 수가 있으면 자리수 하나마다 K개의 값 중 최대를 보니까 시간복잡도가 터질만 함
2. dp인가 싶었는데 dp로는 O(NK) => N^2임
3. 결국 그리디 뿐인데 예제에 대해서 K를 바꿔가며 봐도 잘 모르겠음
4. 그러다가 이전 값과의 비교 어쩌구 생각을 해보다가 포기하고 다시 답 봄
5. 근데 이전 값과의 비교랑 유사한 스택이었음... 시밤바 스택을 머리 속에 넣어두는 게 진짜 어렵네 스택 유형을 좀 풀어야 하려나

![image](https://github.com/user-attachments/assets/2ff2bf55-7a54-4689-9aa8-54627e417b58)
![image](https://github.com/user-attachments/assets/1b350e14-4624-4bbf-a6c2-6605b23a95c6)
![image](https://github.com/user-attachments/assets/cd03235c-aa2a-4904-bc54-52654bf2233d)

# 다른 사람 답 참고
[프로그래머스 같은 문제](https://github.com/nonaninona/algorithm/blob/main/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4/2/42883.%E2%80%85%ED%81%B0%E2%80%85%EC%88%98%E2%80%85%EB%A7%8C%EB%93%A4%EA%B8%B0/think.md)

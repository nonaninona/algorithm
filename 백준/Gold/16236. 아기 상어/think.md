# 생각의 흐름
1. 단순히 그래프 탐색이라기 보다는 구현 느낌이 더 크다고 생각되는 문제 사실 크게 어려운 부분이 없었지만 독특한 유형이라 정리함.
2. 우선, 딱 봐도 원하는 물고기 중 최단을 찾아야 하고 예시를 보니 bfs임은 짐작이 감.
3. 다만 문제는 여러번 반복해야할텐데 시간복잡도 괜찮을지 모르겠었음.
4. 그래도 그냥 naive 하게 구현먼저 하기로 함(지문과 조건이 많아서 일단 구현을 해보고 생각하기로 함)
5. bfs 함수로 빼서 반복하는 형식으로 구현함
6. 어라 근데 N=20임. 시간복잡도 최대 400(bfs반복횟수) x (400+1600)(bfs) = 800,000임

![image](https://github.com/user-attachments/assets/b8712b02-9388-4eaa-8905-d028c6570f5c)
![image](https://github.com/user-attachments/assets/3a44269a-5a2f-42fc-b8c1-7fedc062528b)

# 다른 사람 답 참고

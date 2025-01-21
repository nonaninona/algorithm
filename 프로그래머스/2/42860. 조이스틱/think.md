# 생각의 흐름
1. 우선 위아래 조작은 정해져있다. 아스키 코드 이용하면 코드 더 줄일 수 있을 듯
2. 문제는 좌우 이동인데, 뭐가 최적인가??
3. 그리디 문제라는 점을 생각해보면... 그리디한 풀이가 있을 것 같은데, 생각할 수록 왜 그리디인지 잘 모르겠음.
4. 가장 가까운 A가 아닌 곳으로 이동하기?? => 바로 반례 찾음
5. 제일 간격이 넓은 부분에 대해서 그 좌우 거리 값을 구해보기? => 수식으로 틀렸다는 걸 찾음
6. 아니 어떤 특정한 법칙이 있기 힘들고 그냥 다 구해봐야겠다는 생각이 듦.
7. 다른 사람 답을 참고해보니.. 사실상 완전탐색이라는 듯 함.
8. 난 왼쪽으로만 가는 방식, 오른쪽으로만 가는 방식, 왼쪽으로 가다가 오른쪽으로 꺾는 방식, 오른쪽으로 가다가 왼쪽으로 꺾는 방식을 모두 구했음.
9. 그 중 가장 최단인 경우를 찾도록 함.

![image](https://github.com/user-attachments/assets/c0fa1e5f-8ca8-4017-9d36-b6490c0c7297)
![image](https://github.com/user-attachments/assets/a41e4156-ed7d-4e1b-95a7-3bd1c9408590)
![image](https://github.com/user-attachments/assets/0c900bad-0ea4-412a-ad69-5f5bdd16e7bb)
![image](https://github.com/user-attachments/assets/715fd814-ba13-460f-9f93-eff3cb2ec496)


# 다른 사람 답 참고
[블로그 풀이 참고](https://school.programmers.co.kr/questions/76244)
설명에 오류가 있는 듯함. 항상 N-1이라고 할 수 없을 듯. 모두 A인 경우가 반례임

# 생각의 흐름
1. 그냥 시뮬 문제 같은데 복잡도 판단하니까 3,200 밖에 안됨
2. 회전은 대충 deque로 해주면 될 듯 함
3. 뭔가 흐름이 잘 안떠올라서 대충 주석 치고 코드부터 짜봄
4. 짜다보니 흐름이 보임
5. 좌, 우 판단 => 회전 => 좌, 우 회전 적용
6. 좌 회전 적용 : 좌 판단 => 회전 => 좌 회전 적용
7. 우 회전 적용 : 우 판단 => 회전 => 우 회전 적용
8. 위의 흐름임
9. 아니 근데 gear 입력에 \n이 자꾸 들어가서 input = sys.stdin.readline().strip 이라고 붙였더니 입력을 제대로 못 받음
10. 뭔가 했더니 sys.stdin.readline()으로 첫 줄을 받아놓고 계속 거기다가 대고 strip을 호출하고 있던 것 => 계속 첫줄의 strip 결과를 리턴
11. 그래서 input = sys.stdin.readline으로 그대로 두고, 매 input 호출 시마다 strip을 같이 호출하도록 수정함

<img width="361" alt="image" src="https://github.com/user-attachments/assets/bb1419fe-16d8-4285-a15c-256b8bc49bc4" />

# 배운점
- 흐름이 잘 안보일 때는, 그냥 코드를 무작정 쳐보는 것도 나쁘지 않음
- input = sys.stdin.readline().strip은 쓸 수 없음

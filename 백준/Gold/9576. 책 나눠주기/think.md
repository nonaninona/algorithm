# 생각의 흐름
1. 음... 아무래도 범위가 좁은 애부터 골라야 하지 않을까?
2. 음... 반례가 있다 책이 3개일 때, (1, 1), (2, 3), (1, 2) 이렇게 되어있으면 순서에 따라 2가 나올 수도 있음
3. 그러면 a를 오름차순으로 하면 되잖아
4. 틀림...
5. 반례는 못 찾곘고, 코딩 문제도 아닌 것 같아서 그냥 질문 게시판 봄
6. 나처럼 범위로 했던 사람들이 있음
7. 반례는 책이 4개일 때 (1, 1), (2, 2), (3, 4), (1, 3)인 경우 3, 4가 4를 놔두고 3을 먹어버려서 1, 3이 고를 게 없음
8. 범위를 좁은 애를 고르다가 범위가 더 넓은 애가 손해를 보는 케이스가 있는 것
9. 답은 b, a를 오름차순으로 정렬하는 건데 사실 직관적임
10. 앞에서부터 고르니 b가 이른 순부터 골라줘야할 것이고, b가 같은 경우에는 a가 이른 애부터 해줘야함

![Ongoing-408](https://github.com/user-attachments/assets/20074501-8451-4c0a-9cc0-7efeae9e1485)
![Ongoing-409](https://github.com/user-attachments/assets/7d3da027-3c0f-4079-b956-e619a7d57213)
![Ongoing-410](https://github.com/user-attachments/assets/104614f3-f3e6-4afe-ab0a-faea31f754ea)

# 배운점
- 반례를 잘~ 찾는 게 정말 중요하다
- "범위가 좁은 애를 먼저 고르다가 범위가 더 넓은 애가 손해를 보는 케이스"라고 생각하고 찾았으면 찾을만 했을 듯. "같은 범위일 때 꼬이는 케이스"만 찾아본 게 실수
- 반례를 찾기 위해서는 문장으로 표현해보면 더 좋을 듯 함
- python의 global 키워드의 용도 중 하나는 [전역 변수를 로컬 함수 안에서 수정하고 싶을 때 활용](https://www.w3schools.com/python/python_variables_global.asp#:~:text=Also%2C%20use%20the%20global%20keyword%20if%20you%20want%20to%20change%20a%20global%20variable%20inside%20a%20function.)

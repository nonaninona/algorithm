# 생각의 흐름
아... 어렵다 ㅋㅋ...<br>
일단 아이디어는 잘 생각했는데<br>
이걸 구현으로 옮기는 부분이랑, 예외 상황 처리가 아쉽네..
1. 오우 유명한 문제~ 일단 완탐은 삽불가능
2. dp 같긴 해. N도 작고
3. 어디서부터, 남은 어떤 것들을 방문해야하는지 => 이거 재활용할 수 있겠다
4. 음.. 근데 그래도 2의 N승인데?? 다른 걸 재활용해야하나...
5. 한참을 다른 재활용방법을 찾으면서(노드를 하나씩 추가한다거나, dp 배열을 순회하면서 업데이트 한다거나..) 죽 쑤다가, 2의 N승이어도 N이 작아서 문제 없다는 걸 발견
6. 엥... 근데 구현을 어떻게 하지?
7. 모르겠어서 다른 사람 풀이 참고함
- 현재 위치와 남은 애들(=방문상태)를 가지고 2차원 dp 배열을 만들면 됨.
- 쉬프트 연산(<<, &, |)을 잘 활용해야 한다는 걸 배움.
- 시작 위치 중요하지 않다는 것을 알게 됨
8. 작성해놓고도 계속 틀림.
9. 이것도 혼자서 해결 못하고 반례 찾아보고, 질문게시판 뒤지면서 해결함
- 엣지가 없을 수 있다는 점, 0이라는 값으로 표현된다는 점을 반영해야 함.
- dp의 최초 값과, INF 값의 구분을 둬야 한다는 것.(그렇지 않으면, 다 확인한 결과가 INF여도 재 탐색 -> 시간초과)

![Ongoing-356](https://github.com/user-attachments/assets/9aa66c77-4f21-4d3c-9d77-b05e3d7c2f2a)
![Ongoing-357](https://github.com/user-attachments/assets/6a3596c3-37ee-474c-9db2-05ad1beb1f2d)
![Ongoing-358](https://github.com/user-attachments/assets/f3a54a4a-8bed-42c7-b151-a06aabeb8981)
![Ongoing-359](https://github.com/user-attachments/assets/2fb7ed20-447f-4b97-8c60-1e1e7e46124f)

# 다른 사람 답 참고
풀이 [참고1](https://velog.io/@dltmdrl1244/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%99%B8%ED%8C%90%EC%9B%90-%EC%88%9C%ED%9A%8CTSP-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98), [참고2](https://velog.io/@vantaa89/%EC%99%B8%ED%8C%90%EC%9B%90-%EC%88%9C%ED%9A%8C-%EB%AC%B8%EC%A0%9CTraveling-Salesman-Problem-TSP)<br>
반례 [참고](https://www.acmicpc.net/board/view/125448), [dp 초기화 관련](https://www.acmicpc.net/board/view/119776)

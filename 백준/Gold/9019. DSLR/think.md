# 생각의 흐름
1. 이거 그래프 탐색 없었으면 떠올리기 힘들었을 것 같음
2. 그래서 최악의 경우 탐색을 몇 번 정도 하게 되는 걸까? 뭐 2배씩 뛰니까 한 14?
3. 아무튼 완탐을 하기 좋은 형태인 것
4. 그런데 메모리초과, 시간초과로 많이 틀림
5. 메모리초과 => visited 배열 설정을 안함;;
6. 시간초과 => fastio, 연산 최적화, pypy3로 개선
7. L과 R에 대한 연산 최적화는 내가 떠올리지 못했음. 아예 문자열로 접근해서 list 만들고 join 했었는데, 단순히 계산으로만 구현이 가능했음

# 배운점
- 결국 모든 것은 경우의 수와 그것에 대한 탐색이다. 완탐이 가능한지 확인해보는 게 필수
- 수를 이용해서 빠르게 연산 가능한지를 먼저 체크해보자
- visited 배열은 그래프 탐색에서 빼먹으면 안된다..

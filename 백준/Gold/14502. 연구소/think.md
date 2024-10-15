# 생각의 흐름
1. 엥 이게 왜 구현임?
2. 아니 알고리즘이 떠오르는 게 없어 그래프 관련 같은데..
3. 걍 완탐이라도 생각해봐..
4. 앗... M과 N의 범위가?? ㅋㅋ 걍 완탐이네
5. 다만 벽으로 만들 빈칸을 선택하고(조합) + 너비 계산(dfs) 해야함
6. 
(조합)
```
from itertools import combinations
combinations = list(combinations(zeroList, 3))
```
이렇게 쓴다.
만약 실제로 구현해야 한다면 어떻게 할까??
아마 개수만큼 for 중첩을 쌓아서??
   
# 다른 사람 답 참고
뭐 bfs를 쓰거나... 아니면 일부 최적화 정도

그런데 누가 6배는 빠른 실행시간이길래 봤더니
pypy3 vs python
dfs vs bfs 차이 정도 인 것 같더라

[pypy3가 뭐가 다른지를 설명하는 좋은 글 찾음](https://ralp0217.tistory.com/entry/Python3-%EC%99%80-PyPy3-%EC%B0%A8%EC%9D%B4)

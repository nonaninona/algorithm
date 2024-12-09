# 생각의 흐름
1. 오 최소 경로 bfs인가? 근데 bfs 시간 복잡도가 어떻게 되는 거지? 최소 거리는 다익스트라 써야 하나?
2. 다익스트라는 어떻게 하는 지 모르겠고 일단 bfs 시간 복잡도 판단이나 해보자
3. 인접행렬인 경우(DFS, BFS 모두 N^2), 인접 리스트인 경우(DFS, BFS 모두 N+E) [출처](https://currygamedev.tistory.com/10)
4. 엥 그럼 그냥 bfs 돌려도 되네
5. 어 근데 deque 어떻게 쓰는 지 다 까먹음;;<br>
```
from collections import deque
queue = deque()
queue.append(something)
something = queue.pop()
```
6. 끗

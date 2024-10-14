# 생각의 흐름
1. 어 처음엔 나비 개수가 어떻게 5개라는 건지 몰랐는데
상하좌우라는게 무한정 움직일 수 있는 거였음
2. 그러니까 그냥 dfs임
3. 어 근데 왜 틀리지 런타임에러?
4. 아 파이썬이라 당했음;; 재귀 스택 늘려줘야 함
```
import sys
sys.setrecursionlimit(10000)
```

# 다른 사람 답 참고
앗 bfs로도 풀 수 있네;; 어차피 도달 가능한 곳은 다 가보는구나...

[bfs 풀이]
```
import sys
from collections import deque
sys.setrecursionlimit(10000)

T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    graph = [[0 for i in range(M)] for j in range(N)]
    visited = [[False for i in range(M)] for j in range(N)]
    for __ in range(K):
        X, Y = map(int, input().split())
        graph[Y][X] = 1

    queue = deque()
    count = 0
    for i in range(N):
        for j in range(M):
            if not visited[i][j] and graph[i][j] == 1:
                count += 1
            queue.append((i, j))
            while queue:
                (y, x) = queue.popleft()
                if y < 0 or x < 0 or y >= N or x >= M:
                    continue
                if visited[y][x]:
                    continue
                if graph[y][x] == 0:
                    visited[y][x] = True
                    continue
                visited[y][x] = True
                queue.append((y-1, x))
                queue.append((y+1, x))
                queue.append((y, x-1))
                queue.append((y, x+1))

    print(count)
```

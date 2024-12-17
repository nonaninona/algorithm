from collections import deque

N = int(input())
start, end = map(int, input().split())
M = int(input())
graph = [[] for _ in range(N)]
for _ in range(M):
    s, e = map(int, input().split())
    graph[s-1].append(e-1)
    graph[e-1].append(s-1)

visited = [False for _ in range(N)]
ret = -1
queue = deque()
queue.append((start-1, 0))
while queue:
    (node, dist) = queue.popleft()
    if visited[node]:
        continue
    if node == end-1:
        ret = dist
        break

    visited[node] = True
    for n in graph[node]:
        queue.append((n, dist+1))
print(ret)
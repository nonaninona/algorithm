from collections import deque
import sys

M, N = map(int, sys.stdin.readline().rstrip().split())
graph = [list(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]
visited = [[False for i in range(M)] for j in range(N)]
distance = [[210000000 for i in range(M)] for j in range(N)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

queue = deque()

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            queue.append((i, j, 0))

while queue:
    (y, x, d) = queue.popleft()
    if y < 0 or x < 0 or y >= N or x >= M:
        continue
    if visited[y][x]:
        continue
    if graph[y][x] == -1:
        visited[y][x] = True
        continue

    visited[y][x] = True
    if d < distance[y][x]:
        distance[y][x] = d
    for k in range(4):
        queue.append((y+dy[k], x+dx[k], d+1))

maxDistance = 0
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0 and distance[i][j] == 210000000:
            maxDistance = -1
            break
        if graph[i][j] == 0 and maxDistance < distance[i][j]:
            maxDistance = distance[i][j]
    if maxDistance == -1:
        break
print(maxDistance)
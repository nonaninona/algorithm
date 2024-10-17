from collections import deque
import sys

M, N, H = map(int, sys.stdin.readline().rstrip().split())
visited = [[[False for j in range(M)] for i in range(N)] for k in range(H)]
distance = [[[0 for j in range(M)] for i in range(N)] for k in range(H)]

boxes = []
tomatoes = []

for k in range(H):
    box = []
    for i in range(N):
        b = list(map(int, sys.stdin.readline().rstrip().split()))
        for j in range(M):
            if b[j] == 1:
                tomatoes.append((k, i, j, 0))
        box.append(b)
    boxes.append(box)

queue = deque()
dx = [-1, 0, 1,  0, 0,  0]
dy = [ 0, 1, 0, -1, 0,  0]
dz = [ 0, 0, 0,  0, 1, -1]

for tomato in tomatoes:
    queue.append(tomato)

while queue:
    (z, y, x, d) = queue.popleft()
    if z < 0 or z >= H or y < 0 or y >= N or x < 0 or x >= M:
        continue
    if visited[z][y][x]:
        continue
    if boxes[z][y][x] == -1:
        visited[z][y][x] = True
        continue

    visited[z][y][x] = True
    distance[z][y][x] = d
    for i in range(6):
        queue.append((z+dz[i], y+dy[i], x+dx[i], d+1))

maximum = -1
for k in range(H):
    for i in range(N):
        for j in range(M):
            t = boxes[k][i][j]
            d = distance[k][i][j]
            if t == 0 and d == 0:
                print(-1)
                exit(0)
            if t != -1 and d > maximum:
                maximum = d
print(maximum)
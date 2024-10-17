from collections import deque
import sys

M, N, H = map(int, sys.stdin.readline().rstrip().split())

boxes = [[list(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)] for j in range(H)]
queue = deque()

dx = [-1, 0, 1, 0, 0, 0]
dy = [0, 1, 0, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

for k in range(H):
    for i in range(N):
        for j in range(M):
            if boxes[k][i][j] == 1:
                queue.append((k, i, j, 1))
                boxes[k][i][j] = 0

while queue:
    (z, y, x, d) = queue.popleft()
    if z < 0 or z >= H or y < 0 or y >= N or x < 0 or x >= M:
        continue
    if boxes[z][y][x] != 0:
        continue

    boxes[z][y][x] = d
    for i in range(6):
        queue.append((z+dz[i], y+dy[i], x+dx[i], d+1))

maximum = -1
for k in range(H):
    for i in range(N):
        for j in range(M):
            t = boxes[k][i][j]
            if t == 0:
                print(-1)
                exit(0)
            if t != -1 and t > maximum:
                maximum = t
print(maximum-1)
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
                queue.append((k, i, j))

while queue:
    (z, y, x) = queue.popleft()
    for i in range(6):
        nz = z+dz[i]
        ny = y+dy[i]
        nx = x+dx[i]
        if nz < 0 or nz >= H or ny < 0 or ny >= N or nx < 0 or nx >= M:
            continue
        if boxes[nz][ny][nx] != 0:
            continue
        boxes[nz][ny][nx] = boxes[z][y][x] + 1
        queue.append((nz, ny, nx))

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
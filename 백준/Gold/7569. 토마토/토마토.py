from collections import deque
import sys

M, N, H = map(int, sys.stdin.readline().rstrip().split())
boxes = [[list(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)] for j in range(H)]
queue = deque()
dX = [-1, 0, 1, 0, 0, 0]
dY = [0, 1, 0, -1, 0, 0]
dZ = [0, 0, 0, 0, 1, -1]

for k in range(H):
    for i in range(N):
        for j in range(M):
            if boxes[k][i][j] == 1:
                queue.append((k, i, j))
def bfs():
    while queue:
        (z, y, x) = queue.popleft()
        for dx, dy, dz in zip(dX, dY, dZ):
            nz, ny, nx = z+dz, y+dy, x+dx
            if 0 <= nz < H and 0 <= ny < N and 0 <= nx < M:
                if boxes[nz][ny][nx] == 0:
                    boxes[nz][ny][nx] = boxes[z][y][x] + 1
                    queue.append((nz, ny, nx))
bfs()

maximum = -1
for k in range(H):
    for i in range(N):
        row = boxes[k][i]
        if 0 in row:
            print(-1)
            exit(0)
        maximum = max(max(row), maximum)
print(maximum-1)
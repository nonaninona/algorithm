from collections import deque

N, M = map(int, input().split())
board = [list(list(input())) for i in range(N)]

visited = [[[-2 for i in range(M)] for j in range(N)] for k in range(2)]

Dx = [-1, 0, 1, 0]
Dy = [0, -1, 0, 1]

queue = deque()
queue.append((0, 0, 1, 1))
while queue:
    (y, x, d, c) = queue.popleft()
    if y < 0 or x < 0 or y >= N or x >= M:
        continue
    if visited[c][y][x] != -2:
        continue
    if board[y][x] == '1' and c == 0:
        visited[c][y][x] = -1
        continue

    if board[y][x] == '1' and c == 1:
        c = 0
    visited[c][y][x] = d

    for dy, dx in zip(Dy, Dx):
        queue.append((y+dy, x+dx, d+1, c))

ret1 = visited[0][N-1][M-1]
ret2 = visited[1][N-1][M-1]
if ret1 < 0 and ret2 < 0:
    ret = -1
elif ret1 > 0 and ret2 > 0:
    ret = min(ret1, ret2)
else:
    ret = max(ret1, ret2)
print(ret)
import sys
sys.setrecursionlimit(10**6)

M, N, K = map(int, input().split())
board = [[0] * N for _ in range(M)]
for _ in range(K):
    (x1, y1, x2, y2) = map(int, input().split())
    for y in range(y1, y2):
        for x in range(x1, x2):
            board[y][x] = 1

visited = [[False for i in range(N)] for j in range(M)]
Dx = [-1, 0, 1, 0]
Dy = [0, -1, 0, 1]
def dfs(y, x):
    if y < 0 or x < 0 or y >= M or x >= N:
        return 0
    if visited[y][x]:
        return 0
    if board[y][x] == 1:
        return 0

    visited[y][x] = True
    result = 1
    for dy, dx in zip(Dy, Dx):
        result += dfs(y+dy, x+dx)
    return result

ret = []
for i in range(M):
    for j in range(N):
        r = dfs(i, j)
        if r != 0:
            ret.append(r)
ret.sort()

print(len(ret))
for r in ret:
    print(r, end=' ')
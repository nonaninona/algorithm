from collections import deque

N, M = map(int, input().split())
board = [list(input()) for i in range(N)]

Dy = [-1, 0, 1, 0]
Dx = [0, 1, 0, -1]

def bfs(i, j):
    queue = deque()
    queue.append((i, j, 0))

    visited = [[-1] * M for i in range(N)]
    visited[i][j] = 0

    while queue:
        y, x, dist = queue.popleft()

        for dy, dx in zip(Dy, Dx):
            ny, nx = y+dy, x+dx
            if ny < 0 or nx < 0 or ny >= N or nx >= M:
                continue
            if visited[ny][nx] != -1:
                continue
            if board[ny][nx] != "L":
                continue

            visited[ny][nx] = dist+1
            queue.append((ny, nx, dist+1))

    ret = 0
    for i in range(N):
        for j in range(M):
            ret = max(ret, visited[i][j])
    return ret

def solve():
    ret = 0

    for i in range(N):
        for j in range(M):
            if board[i][j] == "L":
                ret = max(ret, bfs(i, j))
    return ret

ans = solve()
print(ans)
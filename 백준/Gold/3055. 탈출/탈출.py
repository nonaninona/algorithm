from collections import deque

R, C = map(int, input().split())
board = [list(input()) for i in range(R)]
visited = [[False] * C for i in range(R)]

Dy = [-1, 0, 1, 0]
Dx = [0, 1, 0, -1]

def solve():
    queue = deque()

    water_time = [[2100000000] * C for i in range(R)]

    for i in range(R):
        for j in range(C):
            if board[i][j] == "*":
                queue.append((i, j, 0))
                water_time[i][j] = 0

    while queue:
        y, x, step = queue.popleft()

        for dy, dx in zip(Dy, Dx):
            ny, nx = y+dy, x+dx
            if ny < 0 or nx < 0 or ny >= R or nx >= C:
                continue
            if board[ny][nx] == "." and water_time[ny][nx] == 2100000000:
                water_time[ny][nx] = step+1
                queue.append((ny, nx, step+1))

    for i in range(R):
        for j in range(C):
            if board[i][j] == "S":
                queue.append((i, j, 0))
                visited[i][j] = True
                break

    while queue:
        y, x, step = queue.popleft()

        for dy, dx in zip(Dy, Dx):
            ny, nx = y+dy, x+dx
            if ny < 0 or nx < 0 or ny >= R or nx >= C:
                continue
            if board[ny][nx] == "D":
                return step+1
            if board[ny][nx] == "." and not visited[ny][nx] and water_time[ny][nx] > step+1:
                visited[ny][nx] = True
                queue.append((ny, nx, step+1))

    return "KAKTUS"

ans = solve()
print(ans)
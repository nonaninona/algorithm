from collections import deque

M, N = map(int, input().split())
board = [list(map(int, list(input()))) for i in range(N)]
visited = [[2100000000] * M for i in range(N)]

Dy = [0, 1, 0, -1]
Dx = [1, 0, -1, 0]

def solve():
    queue = deque()

    queue.append((0, 0, 0))
    visited[0][0] = 0

    while queue:
        y, x, count = queue.popleft()

        if visited[y][x] < count:
            continue

        for dy, dx in zip(Dy, Dx):
            ny, nx = y+dy, x+dx
            if ny < 0 or nx < 0 or ny >= N or nx >= M:
                continue

            new_count = count
            if board[ny][nx] == 1:
                new_count += 1

            if visited[ny][nx] <= new_count:
                continue

            queue.append((ny, nx, new_count))
            visited[ny][nx] = new_count

    return visited[N-1][M-1]

ans = solve()
print(ans)
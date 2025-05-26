from collections import deque

N, M = map(int, input().split())
g = [list(map(int, input().split())) for i in range(N)]
visited = [[-1] * M for i in range(N)]

def find_start(queue):
    for i in range(N):
        for j in range(M):
            if g[i][j] == 2:
                queue.append((i, j, 0))
                visited[i][j] = 0
                return

Dy = [-1, 0, 1, 0]
Dx = [0, 1, 0, -1]

def solve():
    queue = deque()

    find_start(queue)

    for i in range(N):
        for j in range(M):
            if g[i][j] == 0:
                visited[i][j] = 0

    while queue:
        y, x, dist = queue.popleft()

        for dy, dx in zip(Dy, Dx):
            ny, nx = y+dy, x+dx
            if ny < 0 or nx < 0 or ny >= N or nx >= M:
                continue
            if visited[ny][nx] != -1:
                continue
            if g[ny][nx] == 0:
                visited[ny][nx] = 0
                continue

            visited[ny][nx] = dist+1
            queue.append((ny, nx, dist+1))

solve()
for row in visited:
    for r in row:
        print(r, end=" ")
    print()
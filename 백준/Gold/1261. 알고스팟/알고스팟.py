import heapq

M, N = map(int, input().split())
board = [list(map(int, list(input()))) for i in range(N)]


Dy = [0, 1, 0, -1]
Dx = [1, 0, -1, 0]

def solve():
    q = []
    heapq.heapify(q)
    dist = [[2100000000] * M for i in range(N)]

    heapq.heappush(q, (0, 0, 0))
    dist[0][0] = 0

    while q:
        d, y, x = heapq.heappop(q)
        if y == N-1 and x == M-1:
            return d

        if dist[y][x] < d:
            continue

        for dy, dx in zip(Dy, Dx):
            ny, nx = y+dy, x+dx
            if ny < 0 or nx < 0 or ny >= N or nx >= M:
                continue

            new_dist = d
            if board[ny][nx] == 1:
                new_dist += 1

            if dist[ny][nx] <= new_dist:
                continue

            heapq.heappush(q, (new_dist, ny, nx))
            dist[ny][nx] = new_dist

ans = solve()
print(ans)
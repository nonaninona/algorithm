N, M = map(int, input().split())
m = []
for _ in range(N):
    m.append(list(map(int, input().split())))
mapTuple = []
for i in range(N):
    for j in range(M):
        mapTuple.append((m[i][j], i, j))
mapTuple.sort(reverse=True)

dp = [[0] * M for _ in range(N)]
dp[0][0] = 1

dX = [-1, 0, 1, 0]
dY = [0, 1, 0, -1]
for (value, y, x) in mapTuple:
    for dy, dx in zip(dY, dX):
        ny, nx = y+dy, x+dx
        if 0<=ny<N and 0<=nx<M and m[y][x] < m[ny][nx]:
            dp[y][x] += dp[ny][nx]
print(dp[N-1][M-1])
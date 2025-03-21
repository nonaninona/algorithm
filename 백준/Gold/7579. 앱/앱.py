N, M = map(int, input().split())
m = list(map(int, input().split()))
c = list(map(int, input().split()))

dp = [[0] * (sum(c)+1) for i in range(N)]

dp[0][c[0]] = m[0]

for i in range(1, N):
    for j in range(sum(c)+1):
        if j >= c[i]:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-c[i]] + m[i])
        else:
            dp[i][j] = dp[i-1][j]

# for d in dp:
#     print(d)

for j in range(sum(c)+1):
    for i in range(N):
        if dp[i][j] >= M:
            print(j)
            exit(0)
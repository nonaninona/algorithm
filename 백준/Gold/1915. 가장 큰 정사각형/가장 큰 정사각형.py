n, m = map(int, input().split())
board = [list(map(int, list(input()))) for _ in range(n)]
dp = [[0] * m for _ in range(n)]

global_max = 0
for j in range(m):
    dp[n-1][j] = board[n-1][j]
    global_max = max(global_max, dp[n-1][j])
for i in range(n):
    dp[i][m-1] = board[i][m-1]
    global_max = max(global_max, dp[i][m-1])

for i in range(n-2, -1, -1):
    for j in range(m-2, -1, -1):
        if board[i][j] == 0:
            dp[i][j] = board[i][j]
        else:
            dp[i][j] = min(dp[i+1][j], dp[i][j+1], dp[i+1][j+1]) + 1
        global_max = max(global_max, dp[i][j])

print(global_max**2)
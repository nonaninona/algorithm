import sys

N = int(sys.stdin.readline().rstrip())
M = [list(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]
dp = [[0 for i in range(N)] for j in range(N)]

for r in range(1, N):
    for start in range(N-r):
        dp[start][start+r] = 2_100_000_000
        for t in range(start, start+r):
            dp[start][start+r] = min(dp[start][t] + dp[t+1][start+r] + M[start][0] * M[t][1] * M[start+r][1],
                                     dp[start][start+r])

sys.stdout.write(str(dp[0][N-1]) + '\n')
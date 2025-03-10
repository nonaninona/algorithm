import sys
input = sys.stdin.readline

T = int(input())
dp = [[0] * 500 for i in range(500)]
for _ in range(T):
    K = int(input())
    files = list(map(int, input().split()))
    for i in range(K):
        dp[i][i] = 0

    s = [0 for i in range(K+1)]
    s[0] = files[0]
    for i in range(K):
        s[i+1] = s[i] + files[i]

    for length in range(2, K+1):
        for start in range(K-length+1):
            end = start + length - 1
            dp[start][end] = 2_100_000_000
            for mid in range(start, end):
                dp[start][end] = min(dp[start][end], dp[start][mid] + dp[mid+1][end])
            dp[start][end] += s[end+1] - s[start]

    print(dp[0][K-1])
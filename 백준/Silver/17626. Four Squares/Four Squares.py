import sys
input = sys.stdin.readline
print = sys.stdout.write

dp = [0] * 50_001
dp[0] = 0
dp[1] = 1

for i in range(2, 50_001):
    dp[i] = 4
    for j in range(i):
        if j*j > i:
            break
        dp[i] = min(dp[i], 1 + dp[i-j*j])
    # print("i, dp[i] =", i, dp[i])

N = int(input())
print(str(dp[N]))
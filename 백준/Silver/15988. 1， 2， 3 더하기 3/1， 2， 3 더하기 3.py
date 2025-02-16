import sys
input = sys.stdin.readline
print = sys.stdout.write

T = int(input())

dp = [0] * 1_000_001
dp[1] = 1
dp[2] = 2
dp[3] = 4
dp[4] = 7
divider = 1_000_000_009

for i in range(5, len(dp)):
    dp[i] = ((dp[i-1] + dp[i-2]) % divider + dp[i-3]) % divider

for _ in range(T):
    N = int(input())
    print(str(dp[N]) + "\n")
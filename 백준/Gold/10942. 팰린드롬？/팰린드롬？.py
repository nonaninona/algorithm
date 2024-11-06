import sys

N = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().rstrip().split()))
M = int(sys.stdin.readline().rstrip())

dp = [[True] * 2001 for i in range(2001)]

for end in range(1, len(nums)+1):
    for start in range(1, end):
        dp[start][end] = ((nums[start-1] == nums[end-1]) and dp[start+1][end-1])

for i in range(M):
    S, E = map(int, sys.stdin.readline().rstrip().split())
    if dp[S][E]:
        sys.stdout.write('1\n')
    else:
        sys.stdout.write('0\n')
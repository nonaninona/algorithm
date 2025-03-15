N = int(input())
boxes = list(map(int, input().split()))
dp = [1] * N

for i in range(N-1, -1, -1):
    for j in range(N-1, i, -1):
        if boxes[i] < boxes[j]:
            dp[i] = max(dp[i], dp[j] + 1)

ret = 0
for i in range(N):
    ret = max(ret, dp[i])
print(ret)
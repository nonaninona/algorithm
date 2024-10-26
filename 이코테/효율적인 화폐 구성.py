N, M = map(int, input().split())
units = [int(input()) for i in range(N)]
dp = [0] * (M+1)
for i in range(1, M+1):
    minimum = 2_100_000_000
    for u in units:
        if i - u >= 0 and dp[i-u] != -1:
            minimum = min(dp[i-u]+1, minimum)
    if minimum == 2_100_000_000:
        dp[i] = -1
    else:
        dp[i] = minimum
print(dp[M])

# 책 풀이
# d = [10001] * (M+1)
# d[0] = 0
# for i in range(N):
#     for j in range(units[i], M+1):
#         d[j] = min(d[j], d[j-units[i]]+1)
#
# if d[M] == 10001:
#     print(-1)
# else:
#     print(d[M])

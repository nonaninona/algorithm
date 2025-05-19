T = int(input())
dp = [-1] * 10000

dp[0] = 0
dp[1] = 1

def fibo(n):
    global dp

    if dp[n] != -1:
        return dp[n]
    dp[n] = dp[n-1] + dp[n-2]
    return dp[n]

n = 2
while True:
    f = fibo(n)
    n += 1

    if f >= 1000000000:
        break
max_n = n

for i in range(T):
    f = int(input())
    nums = []
    for i in range(max_n-1, 0, -1):
        if dp[i] <= f:
            nums.append(dp[i])
            f -= dp[i]
    for i in range(len(nums)-1, -1, -1):
        print(nums[i], end=" ")
    print()
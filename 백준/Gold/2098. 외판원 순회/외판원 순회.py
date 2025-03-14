import sys
sys.setrecursionlimit(10**6)
INF = 2100000000

N = int(input())
W = [list(map(int, input().split())) for i in range(N)]

dp = [[-1 for j in range(2**N)] for i in range(N)]

# for d in dp:
#     print(d)

def dfs(current, visited):
    # print(current, bin(visited))
    if dp[current][visited] != -1:
        return dp[current][visited]

    if visited == 2**N-1: # 전부 방문
        if W[current][0] == 0:
            dp[current][visited] = INF
        else:
            dp[current][visited] = W[current][0]
        return dp[current][visited]

    dp[current][visited] = INF
    for i in range(N):
        # print(bin(visited))
        # print(bin(1 << i))
        # print(visited & 1 << i)
        if visited & 1 << i != 0: # 현재 이미 방문되어 있는 경우
            continue
        if W[current][i] == 0: # 길이 없는 경우
            continue
        dp[current][visited] = min(dp[current][visited], W[current][i] + dfs(i, visited | 1 << i))

    # print(current, bin(visited))
    # print(dp[current][visited])
    return dp[current][visited]

result = dfs(0, 1)
print(result)

# for d in dp:
#     print(d)
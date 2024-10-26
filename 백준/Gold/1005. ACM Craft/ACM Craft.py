import sys
sys.setrecursionlimit(10**6)

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N, K = map(int, sys.stdin.readline().rstrip().split())
    times = list(map(int, sys.stdin.readline().rstrip().split()))
    g = [[] for i in range(N)]
    for __ in range(K):
        (s, e) = map(int, sys.stdin.readline().rstrip().split())
        g[e-1].append(s-1)
    W = int(sys.stdin.readline().rstrip())

    dp = [-1] * N
    def dfs(n):
        if dp[n] != -1:
            return dp[n]

        if len(g[n]) == 0:
            dp[n] = times[n]
            return dp[n]

        maximum = times[n]
        for e in g[n]:
            maximum = max(dfs(e)+times[n], maximum)
        dp[n] = maximum
        return dp[n]
    dfs(W-1)
    sys.stdout.write(str(dp[W-1]) + "\n")
import sys
sys.setrecursionlimit(10000)

T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    graph = [[0 for i in range(M)] for j in range(N)]
    visited = [[False for i in range(M)] for j in range(N)]
    for __ in range(K):
        X, Y = map(int, input().split())
        graph[Y][X] = 1

    def dfs(y, x):
        if y < 0 or x < 0 or y >= N or x >= M:
            return False
        if visited[y][x]:
            return False
        if graph[y][x] == 0:
            visited[y][x] = True
            return False

        visited[y][x] = True
        dfs(y-1, x)
        dfs(y+1, x)
        dfs(y, x-1)
        dfs(y, x+1)
        return True

    count = 0
    for i in range(N):
        for j in range(M):
            if dfs(i, j):
                count += 1

    print(count)
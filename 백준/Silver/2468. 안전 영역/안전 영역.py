import sys
sys.setrecursionlimit(10**6)

N = int(sys.stdin.readline().rstrip())
graph = [list(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]
visited = [[False for i in range(N)] for j in range(N)]

dX = [-1, 0, 1, 0]
dY = [0, 1, 0, -1]

def dfs(y, x, h):
    if y<0 or x<0 or y>=N or x>=N:
        return False
    if visited[y][x]:
        return False
    if graph[y][x] <= h:
        visited[y][x] = True
        return False

    visited[y][x] = True
    for dx, dy in zip(dX, dY):
        dfs(y+dy, x+dx, h)
    return True

maximumGroups = 0
for h in range(0, 101):
    visited = [[False for i in range(N)] for j in range(N)]
    groups = 0
    for i in range(N):
        for j in range(N):
            if dfs(i, j, h):
                groups += 1
    maximumGroups = max(groups, maximumGroups)
print(maximumGroups)
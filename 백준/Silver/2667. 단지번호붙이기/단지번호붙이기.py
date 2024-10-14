N = int(input())
graph = []
for i in range(N):
    graph.append(list(map(int, input())))
visited = [[False for _ in range(N)] for __ in range(N)]

groups = []
def dfs(y, x):
    if y < 0 or x < 0 or y >= N or x >= N:
        return 0
    if graph[y][x] == 0:
        visited[y][x] = True
    if visited[y][x]:
        return 0

    visited[y][x] = True
    return 1 + dfs(y-1, x) + dfs(y+1, x) + dfs(y, x-1) + dfs(y, x+1)

for i in range(N):
    for j in range(N):
        width = dfs(i, j)
        if width != 0:
            groups.append(width)
groups.sort()
print(len(groups))
for width in groups:
    print(width)
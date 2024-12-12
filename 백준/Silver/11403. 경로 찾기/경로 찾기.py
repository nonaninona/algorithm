import sys

N = int(sys.stdin.readline().rstrip())
graph = [list(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]
ret = [[0 for i in range(N)] for j in range(N)]

def dfs(i, j, v):
    if i < 0 or i >= N:
        return
    if v[i] == 1:
        return
    if i == j:
        v[i] = 1
        return

    v[i] = 1
    for (index, edge) in enumerate(graph[i]):
        if edge == 1:
            dfs(index, j, v)

for i in range(N):
    for j in range(N):
        visited = [0 for m in range(N)]
        for (index, edge) in enumerate(graph[i]):
            if edge == 1:
                dfs(index, j, visited)
        ret[i][j] = visited[j]

for i in range(N):
    for j in range(N):
        sys.stdout.write(str(ret[i][j]) + " ")
    sys.stdout.write("\n")
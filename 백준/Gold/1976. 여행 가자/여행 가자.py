N = int(input())
M = int(input())
g = [[] for i in range(N)]
for i in range(N):
    row = list(map(int, input().split()))
    for j in range(N):
        if row[j] == 1:
            g[j].append(i)
            g[i].append(j)

visited = [-1] * N

def dfs(n, group):
    if visited[n] != -1:
        return False

    visited[n] = group
    for e in g[n]:
        dfs(e, group)
    return True

group = 0
for i in range(N):
    if dfs(i, group):
        group += 1

path = list(map(int, input().split()))
prev_group = visited[path[0]-1]
for p in path:
    if prev_group != visited[p-1]:
        print("NO")
        exit()
print("YES")
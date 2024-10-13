V = int(input())
graph = [[] for i in range(V+1)]
E = int(input())
for _ in range(E):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

visited = [False] * (V+1)

def dfs(n):
    if visited[n]:
        return

    visited[n] = True
    nodes = graph[n]
    for node in nodes:
        dfs(node)

dfs(1)

count = 0
for v in visited:
    if v:
        count += 1
print(count-1)
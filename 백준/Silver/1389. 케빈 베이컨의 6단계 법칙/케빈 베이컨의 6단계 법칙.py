N, M = map(int, input().split())
dist = [[2100000000 for i in range(N)] for j in range(N)]
for _ in range(M):
    (s, e) = map(int, input().split())
    dist[s-1][e-1] = 1
    dist[e-1][s-1] = 1
for v in range(N):
    dist[v][v] = 0

for k in range(N):
    for i in range(N):
        for j in range(i):
            dist[j][i] = dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

ans = []
for i in range(N):
    a = 0
    for j in range(N):
        a += dist[i][j]
    ans.append((a, i))
ans.sort(key=lambda x:(x[0], x[1]))

print(ans[0][1]+1)
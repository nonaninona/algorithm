N = int(input())
M = int(input())
path = [[1550000000 for i in range(N)] for j in range(N)]
for _ in range(M):
    (a, b, c) = map(int, input().split())
    path[a-1][b-1] = min(path[a-1][b-1], c)
for i in range(N):
    path[i][i] = 0

for k in range(N):
    for i in range(N):
        for j in range(N):
            path[i][j] = min(path[i][j], path[i][k] + path[k][j])

for ps in path:
    for p in ps:
        if p == 1550000000:
            print(0, end=' ')
        else:
            print(p, end=' ')
    print()
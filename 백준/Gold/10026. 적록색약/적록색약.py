import sys
sys.setrecursionlimit(10**6)

N = int(input())
painting = [input() for i in range(N)]
weakPainting = []
for p in painting:
    weakPainting.append(p.replace("G", "R"))
visited = [[False for i in range(N)] for j in range(N)]
weakVisited = [[False for i in range(N)] for j in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(y, x, c):
    if y<0 or x<0 or y>=N or x>=N:
        return False
    if visited[y][x]:
        return False
    if painting[y][x] != c:
        return False

    visited[y][x] = True
    for i in range(4):
        dfs(y+dy[i], x+dx[i], c)
    return True

def dfs2(y, x, c):
    if y<0 or x<0 or y>=N or x>=N:
        return False
    if weakVisited[y][x]:
        return False
    if weakPainting[y][x] != c:
        return False

    weakVisited[y][x] = True
    for i in range(4):
        dfs2(y+dy[i], x+dx[i], c)
    return True

colors = ['R', 'G', 'B']
weakColors = ['R', 'B']
count = 0
weakCount = 0
for i in range(N):
    for j in range(N):
        for c in colors:
            if dfs(i, j, c):
                count += 1

for i in range(N):
    for j in range(N):
        for c in weakColors:
            if dfs2(i, j, c):
                weakCount += 1
print(count, weakCount)
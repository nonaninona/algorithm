from itertools import combinations
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().rstrip().split())))
zeroList = []
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            zeroList.append((i, j))
visited = [[False for _ in range(M)] for __ in range(N)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def dfs(y, x):
    if y < 0 or x < 0 or y >= N or x >= M:
        return (False, 0)
    if visited[y][x]:
        return (False, 0)
    if graph[y][x] == 1:
        return (False, 0)
    if graph[y][x] == 2:
        return (True, 0)

    visited[y][x] = True

    isTwoExist = False
    childWidth = 0
    for i in range(4):
        (iTE, width) = dfs(y+dy[i], x+dx[i])
        isTwoExist = isTwoExist or iTE
        childWidth += width
    return (isTwoExist, childWidth+1)

maxWidth = -1
combinations = list(combinations(zeroList, 3))
for comb in combinations:
    for (y, x) in comb:
        graph[y][x] = 1
    for i in range(N):
        for j in range(M):
            visited[i][j] = False
    safeWidth = 0
    for i in range(N):
        for j in range(M):
            (isTwoExist, width) = dfs(i, j)
            if not isTwoExist:
                safeWidth += width
    if safeWidth > maxWidth:
        maxWidth = safeWidth
    for (y, x) in comb:
        graph[y][x] = 0
print(maxWidth)

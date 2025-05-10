import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N, M = map(int,input().split())
graph = [list(map(int, input().split())) for i in range(N)]
visited = [[False] * M for i in range(N)]

Dx = [-1, 0, 1, 0]
Dy = [0, -1, 0, 1]

def dfs(i, j):
    if visited[i][j]:
        return False, 0
    if graph[i][j] == 0:
        return False, 0

    ret = 1
    visited[i][j] = True
    for dy, dx in zip(Dy, Dx):
        ny, nx = i+dy, j+dx
        if ny < 0 or nx < 0 or ny >= N or nx >= M:
            continue
        is_first, area = dfs(i + dy, j + dx)
        ret += area

    return True, ret

def solve():

    ret = 0
    max_area = 0
    for i in range(N):
        for j in range(M):
            is_first, area = dfs(i, j)
            if is_first:
                ret += 1
            max_area = max(max_area, area)

    return ret, max_area

answer = solve()
print(answer[0])
print(answer[1])
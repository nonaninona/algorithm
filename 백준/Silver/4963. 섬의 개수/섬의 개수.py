import sys
sys.setrecursionlimit(10**6)
while True:
    W, H = map(int, input().split())
    if W == 0 and H == 0:
        break
    M = [list(map(int, input().split())) for _ in range(H)]
    visited = [[False for i in range(W)] for _ in range(H)]

    Dx = [-1, 0, 1]
    Dy = [-1, 0, 1]
    def dfs(y, x, isFirst):
        if x < 0 or y < 0 or x >= W or y >= H:
            return False
        if M[y][x] == 0:
            visited[y][x] = True
        if visited[y][x]:
            return False
        visited[y][x] = True
        for dy in Dy:
            for dx in Dx:
                dfs(y + dy, x + dx, False)

        if isFirst:
            return True
        else:
            return False
    count = 0
    for i in range(H):
        for j in range(W):
            if dfs(i, j, True):
                count += 1

    print(count)
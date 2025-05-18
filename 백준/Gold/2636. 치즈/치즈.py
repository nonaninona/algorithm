import sys
sys.setrecursionlimit(10**6)

N, M = map(int, input().split())
board = [list(map(int, input().split())) for i in range(N)]
visited = []

Dy = [-1, 0, 1, 0]
Dx = [0, 1, 0, -1]
def dfs(y, x):
    global board

    if y < 0 or x < 0 or y >= N or x >= M:
        return 0
    if visited[y][x]:
        return 0
    if board[y][x] == 1:
        visited[y][x] = True
        board[y][x] = 0
        return 1

    ret = 0
    visited[y][x] = True
    for dy, dx in zip(Dy, Dx):
        ret += dfs(y+dy, x+dx)
    return ret

def check_end():
    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                return False
    return True

def solve():
    global visited

    count = 0
    time = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] == 1:
                count += 1
    while not check_end():
        visited = [[False] * M for i in range(N)]
        count = dfs(0,0)
        time += 1

    return time, count

answer = solve()
print(answer[0])
print(answer[1])
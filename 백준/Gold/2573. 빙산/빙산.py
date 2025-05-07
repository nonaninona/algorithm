import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().split())) for i in range(N)]

Dx = [1, 0, -1, 0]
Dy = [0, -1, 0, 1]


def check_all_melt():
    for row in board:
        for c in row:
            if c != 0:
                return False
    return True


def bfs(y, x, visited):
    queue = deque()
    queue.append((y, x))
    visited[y][x] = True
    while queue:
        y, x = queue.popleft()

        for dy, dx in zip(Dy, Dx):
            ny, nx = y + dy, x + dx
            if board[ny][nx] != 0 and not visited[ny][nx]:
                visited[ny][nx] = True
                queue.append((ny, nx))

    return True


def check_split():
    visited = [[False] * M for i in range(N)]

    group = 0
    for i in range(1, N - 1):
        for j in range(1, M - 1):
            if board[i][j] != 0 and not visited[i][j]:
                bfs(i, j, visited)
                group += 1

    return group >= 2


def solve():
    global board

    buffer = [[0] * M for i in range(N)]

    year = 0
    while not check_all_melt():
        for i in range(1, N - 1):
            for j in range(1, M - 1):
                if board[i][j] == 0:
                    buffer[i][j] = 0
                    continue

                count = 0
                for dy, dx in zip(Dy, Dx):
                    if board[i + dy][j + dx] == 0:
                        count += 1
                buffer[i][j] = max(0, board[i][j] - count)

        year += 1

        temp = board
        board = buffer
        buffer = temp

        if check_split():
            return year

    return 0


answer = solve()
print(answer)
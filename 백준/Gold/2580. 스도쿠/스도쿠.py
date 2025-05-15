import sys
input = sys.stdin.readline

board = [list(map(int, input().split())) for i in range(9)]
blanks = []

def check_row(num, y):
    for j in range(9):
        if board[y][j] == num:
            return False
    return True

def check_column(num, x):
    for i in range(9):
        if board[i][x] == num:
            return False
    return True

def check_grid(num, y, x):
    y //= 3
    y *= 3
    x //= 3
    x *= 3
    for i in range(3):
        for j in range(3):
            if board[y+i][x+j] == num:
                return False
    return True

def dfs(n):
    if n == len(blanks):
        for row in board:
            print(*row)
        exit()

    for i in range(9):
        y, x = blanks[n]
        if check_row(i+1, y) and check_column(i+1, x) and check_grid(i+1, y, x):
            board[y][x] = i+1
            dfs(n+1)
            board[y][x] = 0


def solve():
    global blanks

    for i in range(9):
        for j in range(9):
            if board[i][j] == 0:
                blanks.append((i, j))

    dfs(0)


answer = solve()
print(answer)
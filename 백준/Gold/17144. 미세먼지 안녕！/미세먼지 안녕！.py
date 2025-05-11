import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

R, C, T = map(int,input().split())
board = []
for i in range(R):
    board.append(list(map(int, input().split())))
def find_purifier():
    global board
    for i in range(R):
        if board[i][0] == -1:
            return [i, i+1]
purifier = find_purifier()

Dx = [0, 1, 0, -1]
Dy = [1, 0, -1, 0]

def spread_dust():
    global board

    new_board = [[0] * C for i in range(R)]
    for y in purifier:
        new_board[y][0] = -1

    for i in range(R):
        for j in range(C):
            if board[i][j] == -1:
                continue
            unit = board[i][j] // 5
            count = 0
            for dy, dx in zip(Dy, Dx):
                ny, nx = i + dy, j + dx
                if ny < 0 or nx < 0 or ny >= R or nx >= C or board[ny][nx] == -1:
                    continue
                new_board[ny][nx] += unit
                count += 1
            new_board[i][j] += board[i][j] - unit * count

    return new_board

def circle_dust():
    global board

    purifier_up = purifier[0]
    purifier_down = purifier[1]

    py, px = purifier_up, 0
    dir = 2
    while True:
        ny, nx = py+Dy[dir], px+Dx[dir]
        if ny < 0 or nx < 0 or ny >= purifier_up+1 or nx >= C:
            dir -= 1
            if dir < 0:
                dir += 4
            continue
        if board[ny][nx] == -1:
            board[py][px] = 0
            break
        if board[py][px] == -1:
            py, px = ny, nx
            continue
        board[py][px] = board[ny][nx]
        py, px = ny, nx

    py, px = purifier_down, 0
    dir = 0
    while True:
        ny, nx = py+Dy[dir], px+Dx[dir]
        if ny < purifier_down or nx < 0 or ny >= R or nx >= C:
            dir += 1
            if dir >= 4:
                dir %= 4
            continue
        if board[ny][nx] == -1:
            board[py][px] = 0
            break
        if board[py][px] == -1:
            py, px = ny, nx
            continue
        board[py][px] = board[ny][nx]
        py, px = ny, nx

def solve():
    global board

    for i in range(T):
        board = spread_dust()
        circle_dust()

    ret = 0
    for i in range(R):
        for j in range(C):
            if board[i][j] != -1:
                ret += board[i][j]

    return ret

answer = solve()
print(answer)
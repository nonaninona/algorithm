import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for i in range(N)]

def move_list(list):
    new_list = []
    prev = -1
    for i in range(len(list)):
        if list[i] == 0:
            continue
        if prev == -1:
            new_list.append(list[i])
            prev = len(new_list)-1
            continue
        if list[i] == new_list[prev]:
            new_list[prev] *= 2
            prev = -1
            continue
        new_list.append(list[i])
        prev = len(new_list) - 1

    new_list += [0] * (len(list) - len(new_list))
    return new_list


def move_left(board):
    new_board = []
    for row in board:
        new_board.append(move_list(row))
    return new_board

def move_right(board):
    new_board = []
    for row in board:
        new_board.append(move_list(row[::-1])[::-1])
    return new_board

def move_up(board):
    new_board = [[0] * N for i in range(N)]
    for i in range(N):
        col = []
        for j in range(N):
            col.append(board[j][i])

        new_col = move_list(col)
        for j in range(N):
            new_board[j][i] = new_col[j]
    return new_board

def move_down(board):
    new_board = [[0] * N for i in range(N)]
    for i in range(N):
        col = []
        for j in range(N):
            col.append(board[j][i])

        new_col = move_list(col[::-1])[::-1]
        for j in range(N):
            new_board[j][i] = new_col[j]
    return new_board

def get_maximum(board):
    ret = 0
    for row in board:
        for n in row:
            ret = max(ret, n)
    return ret


def dfs(board, step):
    if step == 0:
        return 0

    ret = 0

    new_board = move_left(board)
    ret = max(ret, get_maximum(new_board))
    ret = max(ret, dfs(new_board, step-1))

    new_board = move_right(board)
    ret = max(ret, get_maximum(new_board))
    ret = max(ret, dfs(new_board, step-1))

    new_board = move_up(board)
    ret = max(ret, get_maximum(new_board))
    ret = max(ret, dfs(new_board, step-1))

    new_board = move_down(board)
    ret = max(ret, get_maximum(new_board))
    ret = max(ret, dfs(new_board, step-1))

    return ret

answer = dfs(board, 5)
print(answer)
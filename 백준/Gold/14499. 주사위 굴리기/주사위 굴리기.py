def move_right(dice):
    temp = dice[3][1]
    dice[3][1] = dice[1][2]
    dice[1][2] = dice[1][1]
    dice[1][1] = dice[1][0]
    dice[1][0] = temp

def move_left(dice):
    temp = dice[3][1]
    dice[3][1] = dice[1][0]
    dice[1][0] = dice[1][1]
    dice[1][1] = dice[1][2]
    dice[1][2] = temp

def move_up(dice):
    temp = dice[0][1]
    dice[0][1] = dice[1][1]
    dice[1][1] = dice[2][1]
    dice[2][1] = dice[3][1]
    dice[3][1] = temp

def move_down(dice):
    temp = dice[3][1]
    dice[3][1] = dice[2][1]
    dice[2][1] = dice[1][1]
    dice[1][1] = dice[0][1]
    dice[0][1] = temp

def solve(N, M, x, y, K, board, commands):
    dice = [
        [0, 2, 0],
        [4, 1, 3],
        [0, 5, 0],
        [0, 6, 0]
    ]
    dice_num = [0, 0, 0, 0, 0, 0]

    for c in commands:
        if c == 1:
            nx, ny = x, y+1
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            x, y = nx, ny
            move_right(dice)
        elif c == 2:
            nx, ny = x, y-1
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            x, y = nx, ny
            move_left(dice)
        elif c == 3:
            nx, ny = x-1, y
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            x, y = nx, ny
            move_up(dice)
        elif c == 4:
            nx, ny = x+1, y
            if nx < 0 or ny < 0 or nx >= N or ny >= M:
                continue
            x, y = nx, ny
            move_down(dice)

        if board[x][y] == 0:
            board[x][y] = dice_num[dice[3][1]-1]
        else:
            dice_num[dice[3][1]-1] = board[x][y]
            board[x][y] = 0

        print(dice_num[dice[1][1]-1])

N, M, x, y, K = map(int, input().split())
board = [list(map(int, input().split())) for i in range(N)]
commands = list(map(int, input().split()))
solve(N, M, x, y, K, board, commands)
from collections import deque

def move_marble(board, dy, dx, marble_ny, marble_nx):
    while True:
        marble_ny, marble_nx = marble_ny + dy, marble_nx + dx
        if board[marble_ny][marble_nx] == "#" or board[marble_ny][marble_nx] == "O":
            break
    if board[marble_ny][marble_nx] == "#":
        marble_ny, marble_nx = marble_ny - dy, marble_nx - dx
    return marble_ny, marble_nx

def solve(N, M, board):
    queue = deque()
    red_y, red_x = 0, 0
    blue_y, blue_x = 0, 0
    visited = [[[[False] * M for i in range(N)] for j in range(M)] for k in range(N)]

    for i in range(N):
        for j in range(M):
            if board[i][j] == "R":
                red_y, red_x = i, j
            elif board[i][j] == "B":
                blue_y, blue_x = i, j

    queue.append((red_y, red_x, blue_y, blue_x, 0))

    Dy = [0, 0, 1, -1]
    Dx = [-1, 1, 0, 0]


    while queue:
        red_y, red_x, blue_y, blue_x, count = queue.popleft()

        if visited[red_y][red_x][blue_y][blue_x]:
            continue
        if count > 10:
            break
        if board[red_y][red_x] == "O" and board[blue_y][blue_x] != "O":
            return count
        if board[blue_y][blue_x] == "O":
            continue

        for d in range(4):
            red_ny, red_nx = red_y, red_x
            blue_ny, blue_nx = blue_y, blue_x
            dx, dy = Dx[d], Dy[d]

            red_ny, red_nx = move_marble(board, dy, dx, red_ny, red_nx)
            blue_ny, blue_nx = move_marble(board, dy, dx, blue_ny, blue_nx)

            # 같은 위치일 때 겹치지 않도록 하기(구멍은 아닌 경우)
            if red_ny == blue_ny and red_nx == blue_nx and board[red_ny][red_nx] != "O":
                red_dist = abs(red_ny - red_y) + abs(red_nx - red_x)
                blue_dist = abs(blue_ny - blue_y) + abs(blue_nx - blue_x)
                if red_dist < blue_dist:
                    blue_ny, blue_nx = blue_ny - dy, blue_nx - dx
                elif red_dist > blue_dist:
                    red_ny, red_nx = red_ny - dy, red_nx - dx

            queue.append((red_ny, red_nx, blue_ny, blue_nx, count+1))

        visited[red_y][red_x][blue_y][blue_x] = True

    return -1


N, M = map(int, input().split())
board = [list(input()) for i in range(N)]
answer = solve(N, M, board)
print(answer)
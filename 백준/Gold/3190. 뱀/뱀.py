def get_rotate(direction, seconds, L, rotates, cur_rotate):
    if cur_rotate < L:
        x, c = rotates[cur_rotate]
        if x+1 == seconds:
            if c == "L":
                direction -= 1
                if direction < 0:
                    direction += 4
            if c == "D":
                direction += 1
                direction %= 4
            cur_rotate += 1

    return direction, cur_rotate

def check_collide(N, board, head_y, head_x):
    if head_y < 0 or head_x < 0 or head_y >= N or head_x >= N:
        return True
    if board[head_y][head_x] == 1:
        return True


def solve(N, K, apples, L, rotates):
    board = [[0] * N for i in range(N)]
    board[0][0] = 1

    for y, x in apples:
        board[y-1][x-1] = 2

    head_y, head_x = 0, 0
    tail_y, tail_x = 0, 0
    direction = 0 # 0 : 오른쪽, 1 : 아래쪽, 2 : 왼쪽, 3 : 위쪽
    tail_direction = 0
    dy = [0, 1, 0, -1]
    dx = [1, 0, -1, 0]

    cur_rotate = 0
    cur_tail_rotate = 0

    seconds = 1
    tail_seconds = 1
    while True:
        # rotate check
        direction, cur_rotate = get_rotate(direction, seconds, L, rotates, cur_rotate)

        # move head tset
        head_y += dy[direction]
        head_x += dx[direction]

        # collide check
        if check_collide(N, board, head_y, head_x):
            return seconds

        # apple check
        is_apple = False
        if board[head_y][head_x] == 2:
            is_apple = True

        # move head
        board[head_y][head_x] = 1

        # tail move
        if not is_apple:
            tail_direction, cur_tail_rotate = get_rotate(tail_direction, tail_seconds, L, rotates, cur_tail_rotate)
            board[tail_y][tail_x] = 0
            tail_y += dy[tail_direction]
            tail_x += dx[tail_direction]
            tail_seconds += 1

        seconds += 1

N = int(input())
K = int(input())
apples = [tuple(map(int, input().split())) for i in range(K)]
L = int(input())
rotates = [input().split() for i in range(L)]
for i in range(L):
    rotates[i][0] = int(rotates[i][0])
answer = solve(N, K, apples, L, rotates)
print(answer)
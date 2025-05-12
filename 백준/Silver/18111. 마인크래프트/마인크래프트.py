import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())
board = [list(map(int, input().split())) for i in range(N)]

def get_time(h):
    global board

    time = 0
    block = B
    for i in range(N):
        for j in range(M):
            block += board[i][j] - h
            if board[i][j] > h:
                time += 2 * (board[i][j] - h)
            else:
                time += (h - board[i][j])

    if block < 0:
        return 2100000000
    return time

def solve():

    min_time, max_height = 2100000000, 0
    for h in range(0, 256+1):
        time = get_time(h)

        if min_time >= time:
            min_time = time
            max_height = h

    return min_time, max_height

answer = solve()
print(answer[0], answer[1])
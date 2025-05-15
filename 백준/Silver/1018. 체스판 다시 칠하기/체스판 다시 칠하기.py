import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input()) for i in range(N)]

def count(top, bottom, left, right):
    ret1 = 0
    for i in range(top, bottom):
        for j in range(left, right):
            if (i+j) % 2 == 0 and board[i][j] == "B":
                ret1 += 1
            if (i+j) % 2 == 1 and board[i][j] == "W":
                ret1 += 1

    ret2 = 0
    for i in range(top, bottom):
        for j in range(left, right):
            if (i+j) % 2 == 0 and board[i][j] == "W":
                ret2 += 1
            if (i+j) % 2 == 1 and board[i][j] == "B":
                ret2 += 1

    return min(ret1, ret2)


def solve():
    ret = 2100000000
    for i in range(N-7):
        for j in range(M-7):
            c = count(i, i+8, j, j+8)
            ret = min(ret, c)
    return ret

answer = solve()
print(answer)
def solve(board, N, M):
    ret = [[0] * (M+1) for i in range(N)]
    for i in range(N):
        for j in range(M+1):
            if j == 0:
                ret[i][j] = 0
                continue
            ret[i][j] = ret[i][j-1] + board[i][j-1]
    return ret

N, M = map(int, input().split())
board = [list(map(int, input().split())) for i in range(N)]
answer = solve(board, N, M)
K = int(input())
for _ in range(K):
    i, j, x, y = map(int, input().split())
    ret = 0
    for m in range(i-1, x):
        ret += answer[m][y] - answer[m][j-1]
    print(ret)
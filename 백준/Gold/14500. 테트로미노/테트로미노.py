def get_shape_score(N, M, shape, board):
    ret = 0
    n = len(shape)
    m = len(shape[0])
    for i in range(N-n+1):
        for j in range(M-m+1):
            score = 0
            for y in range(n):
                for x in range(m):
                    if shape[y][x] == 1:
                        score += board[i+y][j+x]
            ret = max(ret, score)
    return ret


def solve(N, M, board):
    ret = 0

    shape = [
        [1],
        [1],
        [1],
        [1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 1, 1, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 1],
        [1, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 0],
        [1, 0],
        [1, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 1],
        [1, 0],
        [1, 0]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [0, 1],
        [0, 1],
        [1, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 1],
        [0, 1],
        [0, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 0, 0],
        [1, 1, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 1, 1],
        [1, 0, 0]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))


    shape = [
        [0, 0, 1],
        [1, 1, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 1, 1],
        [0, 0, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [0, 1, 1],
        [1, 1, 0]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 1, 0],
        [0, 1, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 0],
        [1, 1],
        [0, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [0, 1],
        [1, 1],
        [1, 0]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 1, 1],
        [0, 1, 0]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [0, 1, 0],
        [1, 1, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [1, 0],
        [1, 1],
        [1, 0]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    shape = [
        [0, 1],
        [1, 1],
        [0, 1]
    ]
    ret = max(ret, get_shape_score(N, M, shape, board))

    return ret


N, M = map(int, input().split())
board = [list(map(int, input().split())) for i in range(N)]
answer = solve(N, M, board)
print(answer)
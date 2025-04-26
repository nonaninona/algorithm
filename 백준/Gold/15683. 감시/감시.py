def get_cctvs(N, M, office):
    cctvs = []

    for i in range(N):
        for j in range(M):
            if office[i][j] != 0 and office[i][j] != 6:
                cctvs.append((office[i][j], 0, i, j))
    return cctvs

def get_move(cctv_num, direction):
    directions = []
    if cctv_num == 1:
        directions = [[(0, 1)], [(1, 0)], [(0, -1)], [(-1, 0)]]
    elif cctv_num == 2:
        directions = [[(0, 1), (0, -1)],
                      [(1, 0), (-1, 0)]]
    elif cctv_num == 3:
        directions = [[(0, 1), (-1, 0)],
                      [(0, 1), (1, 0)],
                      [(0, -1), (1, 0)],
                      [(0, -1), (-1, 0)]]
    elif cctv_num == 4:
        directions = [[(0, -1), (1, 0), (-1, 0)],
                      [(0, 1), (1, 0), (-1, 0)],
                      [(0, 1), (0, -1), (-1, 0)],
                      [(0, 1), (0, -1), (1, 0)]]
    elif cctv_num == 5:
        directions = [[(0, 1), (0, -1), (1, 0), (-1, 0)]]
    return directions[direction]

def fill(cctv, N, M, office):
    cctv_num, direction, y, x = cctv
    move = get_move(cctv_num, direction)

    for dy, dx in move:
        ny = y
        nx = x
        while True:
            ny += dy
            nx += dx

            if ny >= N or ny < 0 or nx >= M or nx < 0:
                break
            if office[ny][nx] == 6:
                break

            office[ny][nx] = "#"

def fill_and_count(cctvs, N, M, office):
    new_office = [row[:] for row in office]

    for cctv in cctvs:
        fill(cctv, N, M, new_office)

    ret = 0
    for i in range(N):
        for j in range(M):
           if new_office[i][j] == 0:
               ret += 1

    return ret

def rotate_cctv(rotations, cur_cctv_idx, cctvs, N, M, office):
    if cur_cctv_idx == len(cctvs):
        return fill_and_count(cctvs, N, M, office)

    cctv_num, direction, y, x = cctvs[cur_cctv_idx]
    rotate_count = rotations[cctv_num-1]
    ret = 65
    for i in range(rotate_count):
        new_cctvs = cctvs + []
        new_cctvs[cur_cctv_idx] = (cctv_num, direction, y, x)
        ret = min(ret, rotate_cctv(rotations, cur_cctv_idx+1, new_cctvs, N, M, office))
        direction += 1
    return ret

def solve(N, M, office):
    rotations = [4, 2, 4, 4, 1]
    cctvs = get_cctvs(N, M, office)

    ret = rotate_cctv(rotations, 0, cctvs, N, M, office)

    return ret

N, M = map(int, input().split())
office = [list(map(int, input().split())) for i in range(N)]
answer = solve(N, M, office)
print(answer)
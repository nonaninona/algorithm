# 2N 개 중
# 모두 같거나
# 경사로를 놓을 수 있거나
# 음 대충 지나가면서 보면 될 듯?

N, L = map(int, input().split())
board = [list(map(int, input().split())) for i in range(N)]
placed = [[0] * N for i in range(N)]
placed_col = [[0] * N for i in range(N)]

def check_streak(i, start):
    j = start
    while True:
        if j - start + 1 > L:
            return True

        if j >= N:
            return False
        if board[i][j] != board[i][start]:
            return False
        if placed[i][j] != 0:
            return False
        j += 1

def check_streak_reverse(i, start):
    j = start
    while True:
        if start - j + 1 > L:
            return True

        if j < 0:
            return False
        if board[i][j] != board[i][start]:
            return False
        if placed[i][j] != 0:
            return False

        j -= 1

def count(i):
    j = 0
    while True:
        if j == N - 1:
            return True

        if board[i][j] == board[i][j + 1]:
            j += 1
            continue

        if board[i][j] > board[i][j + 1]:
            # 경사로 놓을 수 있는 지 확인

            # 단차
            if board[i][j] - board[i][j + 1] != 1:
                return False

            # 낮은 쪽이 연속해서 L 만큼 존재하는가
            if not check_streak(i, j + 1):
                return False

            # 놓고 j를 거기까지 이동
            for m in range(j + 1, j + 1 + L):
                placed[i][m] = -1

            j += L
            continue

        elif board[i][j] < board[i][j + 1]:
            # 단차
            if board[i][j + 1] - board[i][j] != 1:
                return False

            # 낮은 쪽이 연속해서 L 만큼 존재하는가
            if not check_streak_reverse(i, j):
                return False

            # 놓고 j를 거기까지 이동
            for m in range(j, j - L, -1):
                placed[i][m] = 1

            j += 1
            continue

def check_streak_col(j, start):
    i = start
    while True:
        if i - start + 1 > L:
            return True

        if i >= N:
            return False
        if board[i][j] != board[start][j]:
            return False
        if placed_col[i][j] != 0:
            return False
        i += 1

def check_streak_reverse_col(j, start):
    i = start
    while True:
        if start - i + 1 > L:
            return True

        if i < 0:
            return False
        if board[i][j] != board[start][j]:
            return False
        if placed_col[i][j] != 0:
            return False

        i -= 1

def count_col(j):
    i = 0
    while True:
        if i == N - 1:
            return True

        if board[i][j] == board[i+1][j]:
            i += 1
            continue

        if board[i][j] > board[i+1][j]:
            # 경사로 놓을 수 있는 지 확인

            # 단차
            if board[i][j] - board[i+1][j] != 1:
                return False

            # 낮은 쪽이 연속해서 L 만큼 존재하는가
            if not check_streak_col(j, i+1):
                return False

            # 놓고 j를 거기까지 이동
            for m in range(i + 1, i + 1 + L):
                placed_col[m][j] = -1

            i += L
            continue

        elif board[i][j] < board[i+1][j]:
            # 단차
            if board[i+1][j] - board[i][j] != 1:
                return False

            # 낮은 쪽이 연속해서 L 만큼 존재하는가
            if not check_streak_reverse_col(j, i):
                return False

            # 놓고 j를 거기까지 이동
            for m in range(i, i - L, -1):
                placed[m][j] = 1

            i += 1
            continue

def solve():
    ret = 0
    for i in range(N):
        if count(i):
            ret += 1
    for i in range(N):
        if count_col(i):
            ret += 1
    return ret

ans = solve()
print(ans)
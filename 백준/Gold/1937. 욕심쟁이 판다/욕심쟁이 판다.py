import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
board = []
for _ in range(N):
    b = list(map(int, input().split()))
    board.append(b)

dp = [[0] * N for _ in range(N)]

Dx = [-1, 0, 1, 0]
Dy = [0, -1, 0, 1]

def OOB(y, x):
    global N
    return y < 0 or x < 0 or y >= N or x >= N

def isFinish(y, x):
    global Dy, Dx

    for dy, dx in zip(Dy, Dx):
        if OOB(y+dy, x+dx):
            continue
        if board[y][x] < board[y+dy][x+dx]:
            return False
    return True

def dfs(y, x):
    global Dy, Dx

    # print(y, x)

    if dp[y][x] != 0:
        return dp[y][x]

    if isFinish(y, x):
        dp[y][x] = 1
        return dp[y][x]

    ret = 0
    for dy, dx in zip(Dy, Dx):
        if OOB(y+dy, x+dx) or board[y][x] >= board[y+dy][x+dx]:
            continue
        ret = max(ret, dfs(y+dy, x+dx)+1)
        # print("ret : ", ret)
    dp[y][x] = ret
    return dp[y][x]

for i in range(N):
    for j in range(N):
        dfs(i, j)
        # print("dp : ", dp[i][j])
# print(dp)

ans = 0
for i in range(N):
    for j in range(N):
        if dp[i][j] > ans:
            ans = dp[i][j]
print(ans)
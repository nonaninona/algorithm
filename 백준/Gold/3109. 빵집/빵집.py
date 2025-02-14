R, C = map(int, input().split())
board = []
for _ in range(R):
    b = list(input())
    board.append(b)

def dfs(i, j):
    global board
    if i >= len(board) or i < 0:
        return False
    if j >= len(board[0]) or j < 0:
        return False
    if board[i][j] == "x":
        return False
    if j == len(board[0])-1:
        return True

    Di = [-1, 0, 1]
    for di in Di:
        board[i][j] = "x"
        if dfs(i+di, j+1):
            return True
    return False

count = 0
for i in range(R):
    if dfs(i, 0):
        count += 1

print(count)
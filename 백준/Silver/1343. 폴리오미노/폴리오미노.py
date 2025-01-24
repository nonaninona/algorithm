s = input()
board = []
prev = ""
idx = -1
for c in s:
    if prev != c:
        idx += 1
        board.append(c)
        prev = c
        continue
    board[idx] = board[idx] + c

# print(board)

def solve():
    global board
    ret = ""
    for b in board:
        if "." in b:
            ret += b
            continue

        if len(b) % 2 == 1:
            return -1

        ret += len(b)//4 * "AAAA"
        ret += len(b)%4//2 * "BB"
    return ret

print(solve())
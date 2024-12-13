import sys
input = sys.stdin.readline

R, C = map(int, input().split())
m = [list(input()) for i in range(R)]

alphas = [False for i in range(26)]

Dx = [-1, 0, 1, 0]
Dy = [0, -1, 0, 1]
def dfs(y, x, d):
    if y < 0 or x < 0 or y >= R or x >= C:
        return d-1
    if alphas[ord(m[y][x])-ord('A')]:
        return d-1

    ret = d
    for dy, dx in zip(Dy, Dx):
        alphas[ord(m[y][x])-ord('A')] = True
        ret = max(dfs(y+dy, x+dx, d+1), ret)
        alphas[ord(m[y][x])-ord('A')] = False

    return ret

answer = dfs(0, 0, 1)
print(answer)
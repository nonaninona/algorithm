from operator import truediv

N, M = map(int, input().split())
r, c, d = map(int, input().split())
b = [list(map(int, input().split())) for i in range(N)]

dX = [0, 1, 0, -1]
dY = [-1, 0, 1, 0]
count = 0
while True:
    if b[r][c] == 0:
        b[r][c] = -1
        count += 1
        continue

    isCleaned = True
    for dy, dx in zip(dY, dX):
        ny, nx = r+dy, c+dx
        if 0<=ny<N and 0<=nx<M and b[ny][nx] == 0:
            isCleaned = False
            break

    if isCleaned:
        ny, nx = r+dY[(d+2)%4], c+dX[(d+2)%4]
        if b[ny][nx] == 1:
            break
        r, c = ny, nx
        continue

    while True:
        d = (d-1)%4
        ny, nx = r+dY[d], c+dX[d]
        if b[ny][nx] == 0:
            r, c = ny, nx
            break

print(count)
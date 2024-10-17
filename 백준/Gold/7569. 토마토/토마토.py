from collections import deque
que = deque()

M,N,H = map(int, input().split())
tomatos = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]
dZ = [1,-1,0,0,0,0]
dX = [0,0,0,1,0,-1]
dY = [0,0,1,0,-1,0]

def bfs():
    while que:
        z,x,y = que.popleft()
        for dz, dx, dy in zip(dZ, dX, dY):
            nz, nx, ny = z+dz, x+dx, y+dy
            if 0<=nz<H and 0<=nx<N and 0<=ny<M:
                if tomatos[nz][nx][ny]==0:
                    tomatos[nz][nx][ny] = tomatos[z][x][y] + 1
                    que.append((nz,nx,ny))

for i in range(H):
    for j in range(N):
        for k in range(M):
            if tomatos[i][j][k] == 1:
                que.append((i,j,k))

bfs()

res, trigger = 0, 0
for i in range(H):
    for j in range(N):
        row = tomatos[i][j]
        if 0 in row:
            trigger = 1
        else:
            res = max(res, max(row))
if trigger:
    res = -1
else:
    res -= 1
print(res)
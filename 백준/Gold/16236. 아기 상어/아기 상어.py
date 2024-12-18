from collections import deque

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]
startX, startY = 0, 0
sharkSize = 2
eatCount = 0
for i in range(N):
    for j in range(N):
        if graph[i][j] == 9:
            startX = j
            startY = i

queue = deque()
Dy = [0, -1, 0, 1]
Dx = [-1, 0, 1, 0]
answer = 0


def bfs():
    visited = [[False for _ in range(N)] for __ in range(N)]
    ret = []
    visited[startY][startX] = True
    for dy, dx in zip(Dy, Dx):
        queue.append((startY + dy, startX + dx, 1))
    while queue:
        (y, x, d) = queue.popleft()
        if y < 0 or x < 0 or y >= N or x >= N:
            continue
        if visited[y][x]:
            continue
        if graph[y][x] > sharkSize:
            continue
        visited[y][x] = True
        if graph[y][x] != 0 and graph[y][x] < sharkSize:
            ret.append((d, graph[y][x], y, x))

        for dy, dx in zip(Dy, Dx):
            queue.append((y + dy, x + dx, d + 1))

    ret.sort(key=lambda x: (x[0], x[2], x[3]))
    if len(ret) == 0:
        return -1
    return ret[0]

while True:
    ans = bfs()
    if ans == -1:
        break
    (ansD, ansV, ansY, ansX) = ans
    answer += ansD

    eatCount += 1
    if eatCount == sharkSize:
        sharkSize += 1
        eatCount = 0

    graph[ansY][ansX] = 9
    graph[startY][startX] = 0
    startY = ansY
    startX = ansX

print(answer)
from collections import deque

Dx = [-2, -1, 1, 2, 2, 1, -1, -2]
Dy = [-1, -2, -2, -1, 1, 2, 2, 1]

T = int(input())
for _ in range(T):
    I = int(input())
    start = tuple(map(int, input().split()))
    end = tuple(map(int, input().split()))

    queue = deque()
    visited = [[-1 for i in range(I)] for j in range(I)]
    queue.append((start[0], start[1], 0))
    while queue:
        (y, x, d) = queue.popleft()
        if x < 0 or y < 0 or x >= I or y >= I:
            continue
        if visited[y][x] != -1:
            continue
        if y == end[0] and x == end[1]:
            print(d)
            break

        visited[y][x] = d
        for (dy, dx) in zip(Dy, Dx):
            queue.append((y+dy, x+dx, d+1))
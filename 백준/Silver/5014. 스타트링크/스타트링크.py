from collections import deque

F, S, G, U, D = map(int, input().split())
visited = [-1] * F

def solve():
    queue = deque()
    queue.append(S-1)
    visited[S-1] = 0

    while queue:
        floor = queue.popleft()
        step = visited[floor]

        up, down = floor+U, floor-D
        if up < F and visited[up] == -1:
            queue.append(up)
            visited[up] = step + 1
        if down >= 0 and visited[down] == -1:
            queue.append(down)
            visited[down] = step + 1

    if visited[G-1] == -1:
        return "use the stairs"
    else:
        return visited[G-1]

answer = solve()
print(answer)
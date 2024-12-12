from collections import deque

def solution(maps):
    N = len(maps)
    M = len(maps[0])
    Dx = [-1, 0, 1, 0]
    Dy = [0, -1, 0, 1]
    visited = [[-1 for i in range(M)] for j in range(N)]
    queue = deque()
    queue.append((0, 0, 1))
    while queue:
        (y, x, d) = queue.popleft()
        if y < 0 or x < 0 or y >= N or x >= M:
            continue
        if visited[y][x] != -1:
            continue
        if maps[y][x] == 0:
            continue
        
        visited[y][x] = d
        
        for dy, dx in zip(Dy, Dx):
            queue.append((y+dy, x+dx, d+1))
            
    answer = visited[N-1][M-1]
    return answer
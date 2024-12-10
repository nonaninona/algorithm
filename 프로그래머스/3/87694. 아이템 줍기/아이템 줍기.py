from collections import deque
import sys
sys.setrecursionlimit(10**6)

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    size = 55
    
    M = [[0 for i in range(size)] for j in range(size)]
    for (x1, y1, x2, y2) in rectangle:
        for y in range(y1, y2):
            for x in range(x1, x2):
                # print(y, x)
                M[y][x] = 1
    for i in range(len(M)-1, -1, -1):
        for j in range(len(M[i])):
            print(M[i][j], end=' ')
        print()
    print()
        
    visited = [[-1 for i in range(size)] for j in range(size)]
    def dfs(y, x, n, isFirst):
        if y < 0 or x < 0 or y >= size or x >= size:
            return False
        if M[y][x] == 1:
            visited[y][x] = 0
        if visited[y][x] != -1:
            return False

        visited[y][x] = n
        dfs(y+1, x, n, False)
        dfs(y-1, x, n, False)
        dfs(y, x+1, n, False)
        dfs(y, x-1, n, False)
        
        return isFirst
    
    count = 1
    for i in range(size):
        for j in range(size):
            if dfs(i, j, count, True):
                count += 1
    # for v in visited:
    #     print(v)
    # print()
    count -= 1
        
    if count == 2:
        for i in range(size):
            for j in range(size):
                if visited[i][j] == 2:
                    M[i][j] = 1
    for i in range(len(M)-1, -1, -1):
        for j in range(len(M[i])):
            print(M[i][j], end=' ')
        print()
    print()
        
        
    queue = deque()
    queue.append((characterY, characterX, 0))
    visited = [[-2 for i in range(size)] for j in range(size)]
    while queue:
        (y, x, d) = queue.popleft()
        if y == itemY and x == itemX:
            answer = d
            break
        if y < 0 or y >= size or x < 0 or x >= size:
            continue
        C = [0, 0]
        C[M[y][x]] += 1
        C[M[y-1][x]] += 1
        C[M[y][x-1]] += 1
        C[M[y-1][x-1]] += 1
        if C[0] == 0 or C[1] == 0:
            visited[y][x] = -1
        if visited[y][x] != -2:
            continue
        
        visited[y][x] = d
        if (M[y][x] == 1 and M[y][x-1] == 0) or (M[y][x] == 0 and M[y][x-1] == 1):
            queue.append((y+1, x, d+1))
        if (M[y-1][x] == 1 and M[y-1][x-1] == 0) or (M[y-1][x] == 0 and M[y-1][x-1] == 1):
            queue.append((y-1, x, d+1))
        if (M[y][x] == 1 and M[y-1][x] == 0) or (M[y][x] == 0 and M[y-1][x] == 1):
            queue.append((y, x+1, d+1))
        if (M[y][x-1] == 1 and M[y-1][x-1] == 0) or (M[y][x-1] == 0 and M[y-1][x-1] == 1):
            queue.append((y, x-1, d+1))
        
    for i in range(len(visited)-1, -1, -1):
        for j in range(len(visited[i])):
            print("%2d" % visited[i][j], end=" ")
        print()
    print()
    
    return answer


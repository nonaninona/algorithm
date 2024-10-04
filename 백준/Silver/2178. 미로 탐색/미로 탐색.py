from collections import deque

n, m = map(int, input().split())
map = [list(map(int, input())) for i in range(n)]

dy = [-1, 0, 0, 1]
dx = [0, -1, 1, 0]

def bfs(y, x, d):
  result = 999999999
  
  queue = deque()
  queue.append((y, x, d))

  while queue:
    (ty, tx, td) = queue.popleft()
    
    if ty == n-1 and tx == m-1 and result > td:
      result = td
    
    for i in range(4):
      nx = tx + dx[i]
      ny = ty + dy[i]

      if ny < 0 or ny >= n or nx < 0 or nx >= m:
        continue
      if map[ny][nx] == 0:
        continue

      map[ny][nx] = 0
      queue.append((ny, nx, td + 1))
    
  return result

print(bfs(0, 0, 1))
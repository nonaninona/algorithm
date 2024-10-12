N = int(input())

board = [[0] * 100 for i in range(100)]
for _ in range(N):
  x, y = map(int, input().split())
  
  for i in range(10):
    for j in range(10):
      board[y+i][x+j] = 1

count = 0
for i in range(100):
  for j in range(100):
    if board[i][j] == 1:
      count += 1
print(count)
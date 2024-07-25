n, m = map(int, input().split())
# board = []
# for i in range(0, n):
  # board.append(list(map(int, input().split())))

# minList = []
# for row in board:
  # minList.append(min(row))

minList = []
for i in range(0, n):
  row = list(map(int, input().split()))
  minList.append(min(row))

print(max(minList))



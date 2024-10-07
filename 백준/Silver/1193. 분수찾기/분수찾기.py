x = int(input())

diagonalOrder = 1
while x > diagonalOrder:
  x -= diagonalOrder
  diagonalOrder += 1

if diagonalOrder % 2 == 0:
  top = x
  bottom = diagonalOrder + 1 - x
  print(f"{top}/{bottom}")
else:
  top = diagonalOrder + 1 - x
  bottom = x
  print(f"{top}/{bottom}")
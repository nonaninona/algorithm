x = int(input())

diagonalOrder = 1
while x > diagonalOrder:
  x -= diagonalOrder
  diagonalOrder += 1

top, bottom = 0, 0
if diagonalOrder % 2 == 0:
  top = x
  bottom = diagonalOrder + 1 - x
else:
  top = diagonalOrder + 1 - x
  bottom = x

print(f"{top}/{bottom}")
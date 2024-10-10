n = int(input())
inputs = []
for i in range(n):
  inputs.append(input().split())
stack = []
for i in inputs:
  method = i[0]
  if method=="push":
    number = i[1]
    stack.append(number)
  elif method=="pop":
    if len(stack) == 0:
      print(-1)
    else:
      print(stack.pop())
  elif method=="size":
    print(len(stack))
  elif method=="empty":
    if len(stack) == 0:
      print(1)
    else:
      print(0)
  elif method=="top":
    if len(stack) == 0:
      print(-1)
    else:
      print(stack[-1])
  
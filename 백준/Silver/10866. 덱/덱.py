from collections import deque

N = int(input())

operations = []
for i in range(N):
  operations.append(input().split())

deq = deque()
for operation in operations:
  method = operation[0]
  if method == "push_front":
    num = operation[1]
    deq.appendleft(num)
  elif method == "push_back":      
    num = operation[1]
    deq.append(num)
  elif method == "pop_front":
    if len(deq) == 0:
      print(-1)
    else:
      print(deq.popleft())
  elif method == "pop_back":
    if len(deq) == 0:
      print(-1)
    else:
      print(deq.pop())
  elif method == "size":
    print(len(deq))
  elif method == "empty":
    if len(deq) == 0:
      print(1)
    else:
      print(0)
  elif method == "front":
    if len(deq) == 0:
      print(-1)
    else:
      print(deq[0])
  elif method == "back":
    if len(deq) == 0:
      print(-1)
    else:
      print(deq[-1])
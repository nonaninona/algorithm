N = int(input())

ropes = []
for _ in range(N):
  ropes.append(int(input()))

ropes.sort(reverse=True)

maxVal = -1
for (i, rope) in enumerate(ropes):
  val = rope * (1+i)
  if val > maxVal:
    maxVal = val
print(maxVal)
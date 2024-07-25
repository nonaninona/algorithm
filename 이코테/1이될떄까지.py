n, k = map(int, input().split())
ret = 0

while True:
  if n == 1:
    break

  if n % k == 0:
    n = n // k
    ret += 1
  else:
    n -= 1
    ret += 1

print(ret)

x = int(input())
n = 1
while True:
  if n * (n+1) / 2 >= x:
    break
  n+=1

if (n+1)%2 == 0:
  order = x - ((n-1)*n // 2)
  denominator = order
  numerator = n + 1 - denominator
  print(str(numerator) + "/" + str(denominator))

else:
  order = x - ((n-1)*n // 2)
  numerator = order
  denominator = n + 1 - numerator
  print(str(numerator) + "/" + str(denominator))

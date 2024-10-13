S = int(input())

n = 1
while True:
    if S < n * (n+1) / 2:
        break
    n += 1
print(n-1)
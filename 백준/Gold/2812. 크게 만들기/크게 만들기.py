N, K = map(int, input().split())
num = list(map(int, list(input())))

s = []
count = 0
for n in num:
    if len(s) == 0:
        s.append(n)
        continue

    while True:
        if len(s) == 0:
            break
        if count == K:
            break

        top = s[-1]
        if top >= n:
            break
        s.pop()
        count += 1
    s.append(n)

if K > count:
    s = s[:len(s) - (K-count)]

ans = list(map(str, s))
print("".join(ans))
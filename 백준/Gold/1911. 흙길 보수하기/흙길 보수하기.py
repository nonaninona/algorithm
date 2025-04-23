def solve(L, paddles):
    paddles.sort()

    ret = 0
    last = 0
    for s, e in paddles:
        if last <= s:
            last = s + L
            ret += 1

        if last < e:
            count = (e - last) // L
            if (e-last) % L > 0:
                count += 1
            last += L * count
            ret += count
    return ret

N, L = map(int, input().split())
paddles = []
for i in range(N):
    paddles.append(tuple(map(int, input().split())))
answer = solve(L, paddles)
print(answer)
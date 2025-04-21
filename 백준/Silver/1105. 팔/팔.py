def solve(L, R):
    ret = 0

    if len(L) < len(R):
        return ret

    for l, r in zip(L, R):
        if l != r:
            break
        if int(l) == 8 and int(r) == 8:
            ret += 1
    return ret

L, R = input().split()
answer = solve(list(L), list(R))
print(answer)
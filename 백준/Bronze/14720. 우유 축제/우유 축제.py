def solve(milks):
    target = 0
    ret = 0
    for m in milks:
        if target == m:
            ret += 1
            target += 1
            target %= 3
    return ret

N = int(input())
milks = list(map(int, input().split()))
answer = solve(milks)
print(answer)
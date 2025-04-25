def solve(A, B, C, M):
    fatigue = 0
    ret = 0
    for i in range(24):
        if fatigue + A > M:
            fatigue = max(0, fatigue - C)
            continue

        ret += B
        fatigue += A
    return ret

A, B, C, M = map(int, input().split())
answer = solve(A, B, C, M)
print(answer)
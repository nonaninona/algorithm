def solve(N, cows):
    cows.sort()
    ret = 0
    for enter, wait in cows:
        ret = max(ret, enter)
        ret += wait
    return ret

N = int(input())
cows = [tuple(map(int, input().split())) for i in range(N)]
answer = solve(N, cows)
print(answer)
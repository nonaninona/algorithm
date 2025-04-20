def solve(L, P, V):
    ret = 0

    count = V // P
    ret = count * L

    mod = V % P
    ret += min(mod, L)

    return ret

case = 1
while True:
    L, P, V = map(int, input().split())
    if L==0 and P==0 and V==0:
        break

    answer = solve(L, P, V)
    print("Case " + str(case) + ": " + str(answer))
    case+=1
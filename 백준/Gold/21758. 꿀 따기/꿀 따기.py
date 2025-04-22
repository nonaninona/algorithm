def solve(N, honeys):
    # 꿀통 좌우에 벌을 둘 때
    ret1 = sum(honeys[1:-1]) + max(honeys[1:-1])
    # 꿀통 오른쪽에만 벌을 둘 떄
    first = sum(honeys[:-1])
    second = 0
    ret2 = 0
    for i in range(1, N-1):
        second += honeys[i-1]
        t = first + second - honeys[i]
        if t > ret2:
            ret2 = t
    # 꿀통 왼쪽에만 벌을 둘 때
    first = sum(honeys[1:])
    second = 0
    ret3 = 0
    for i in range(N-2, 0, -1):
        second += honeys[i+1]
        t = first + second - honeys[i]
        if t > ret3:
            ret3 = t

    return max(ret1, ret2, ret3)


N = int(input())
honeys = list(map(int, input().split()))
answer = solve(N, honeys)
print(answer)
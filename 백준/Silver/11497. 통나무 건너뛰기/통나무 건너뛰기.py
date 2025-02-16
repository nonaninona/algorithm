T = int(input())
for _ in range(T):
    N = int(input())
    L = list(map(int, input().split()))
    L.sort(reverse=True)

    minMax = []
    maxMin = []
    flag = 1
    for i, l in enumerate(L):
        if i == 0 or i == len(L)-1:
            continue
        if flag == 1:
            minMax.append(l)
            flag = 0
        else:
            maxMin.append(l)
            flag = 1

    minMax.reverse()
    ans = [L[-1]] + minMax + [L[0]] + maxMin

    # print(ans)
    ret = abs(ans[0] - ans[-1])
    for i in range(len(ans)):
        if i == 0:
            continue
        ret = max(ret, abs(ans[i]-ans[i-1]))
    print(ret)
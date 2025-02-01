def check(a, b, g, s, w, t, mid):
    totalGold, totalSilver, total = 0, 0, 0

    for i in range(len(g)):
        gold = g[i]
        silver = s[i]
        weight = w[i]
        time = t[i]
        
        count = mid // (time*2)
        if mid % (time*2) >= time:
            count += 1

        totalGold += min(count * weight, gold)
        totalSilver += min(count * weight, silver)
        total += min(count * weight, gold + silver)
        
    # print("totalGold : ", totalGold, " totalSilver : ", totalSilver, "total : ", total, '\n')
    return a <= totalGold and b <= totalSilver and a+b <= total


def solution(a, b, g, s, w, t):
    l, r = 1, (10**9+10**9) * (10**5 * 2)
    # print("l : ", l)
    # print("r : ", r)
    mid = -1
    
    while l + 1 < r:
        mid = (l+r) // 2
        # print("l : ", l, " r : ", r, " mid : ", mid)
        
        if check(a, b, g, s, w, t, mid):
            r = mid
        else:
            l = mid  
                    
    answer = r
    return answer
def solution(n, cores):
    
    if n <= len(cores):
        return n
    
    def calc_task(mid):
        total = 0
        for c in cores:
            total += mid // c
            if mid % c > 0:
                total += 1
        return total
    
    s, e = 0, 250_000_000
    mid = (s + e) // 2
    while(s + 1 < e):
        mid = (s + e) // 2
        # print(s, e, mid, calc_task(mid), n)
        if calc_task(mid) >= n:
            e = mid
        else:
            s = mid
    print(s, mid, e)
    
        
    candidates = []
    for i, c in enumerate(cores):
        if s % c == 0:
            candidates.append(i+1)
    print(candidates)
    
    print(n, calc_task(s))
    ret = candidates[n-calc_task(s)-1]
    print(ret)

    
    answer = ret
    return answer
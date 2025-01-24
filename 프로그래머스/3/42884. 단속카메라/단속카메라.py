def solution(routes):
    routes.sort(key=lambda x: x[1])
    
    count = 0
    lastE = -30_001
    for s, e in routes:
        if s > lastE:
            lastE = e
            count += 1
            continue
        
    answer = count
    return answer
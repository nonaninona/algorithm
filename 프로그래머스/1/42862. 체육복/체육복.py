def solution(n, lost, reserve):
    count = [1 for _ in range(n)]
    for student in lost:
        count[student-1] -= 1
    for student in reserve:
        count[student-1] += 1
    
    for i, c in enumerate(count):
        if c == 2 and i-1 >= 0 and count[i-1] == 0:
            count[i] -= 1
            count[i-1] += 1
        elif c == 2 and i+1 < len(count) and count[i+1] == 0:
            count[i] -= 1
            count[i+1] += 1       
            
    answer = 0
    print(count)
    for c in count:
        if c != 0:
            answer += 1
            
    return answer
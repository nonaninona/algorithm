def solution(people, limit):
    people.sort()
    
    start, end = 0, len(people)-1
    count = 0
    while start <= end:
        if people[start] + people[end] <= limit:
            count += 1
            start += 1
            end -= 1
            continue
            
        count += 1
        end -= 1
            
    return count
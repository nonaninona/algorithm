def solution(ingredient):
    s = []
    count = 0
    for i in ingredient:
        s.append(i)
        if len(s) >= 4 and s[-1] == 1 and s[-2] == 3 and s[-3] == 2 and s[-4] == 1:
            for _ in range(4):
                s.pop()
            count += 1

    answer = count
    return answer
def solution(numbers):
    ret = []
    for n in numbers:
        ret.append(n)
        streak = 0
        while n != 0:
            # print("n : ", n)
            if n % 2 == 0:
                break    
            streak += 1
            n = n // 2

        # print("streak : ", streak)

        if streak >= 2:
            ret[-1] += 2 ** (streak - 1)
        else:
            ret[-1] += 1

    # print(ret)

    answer = ret
    return answer
def solution(k, tangerine):
    amount = {}
    for t in tangerine:
        if t in amount:
            amount[t] += 1
        else:
            amount[t] = 1
    # print(amount)


    counts = list(amount.values())
    counts.sort(reverse=True)
    # print(counts)


    types = 0
    for c in counts:
        k -= c
        types += 1
        if k <= 0:
            break
    # print(types)

    answer = types
    return answer
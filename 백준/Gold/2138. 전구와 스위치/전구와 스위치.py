def get_count(cur, tgt):
    ret = 100_001
    count = 0
    for i in range(len(cur)):
        if i == 0:
            continue
        if cur[i - 1] != tgt[i - 1]:
            count += 1
            cur[i - 1] = 1 - cur[i - 1]
            cur[i] = 1 - cur[i]
            if i != len(cur) - 1:
                cur[i + 1] = 1 - cur[i + 1]
    if cur[-1] == tgt[-1]:
        ret = min(count, ret)
    return ret


def solve(N, cur, tgt):
    cur1 = cur
    cur2 = cur + []

    ret1 = get_count(cur1, tgt)

    for i in range(2):
        cur2[i] = 1 - cur2[i]
    ret2 = get_count(cur2, tgt) + 1

    ret = min(ret1, ret2)

    if ret == 100_001:
        return -1
    return ret

N = int(input())
cur = list(map(int, list(input())))
tgt = list(map(int, list(input())))

answer = solve(N, cur, tgt)
print(answer)
def to_days(month, day):
    ret = 0
    days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    for i in range(month-1):
        ret += days[i]
    ret += day
    return ret

def solve(N, flowers):
    flowers.sort(key=lambda x:x[0])

    start = to_days(3, 1)
    end = to_days(11, 30)

    i = 0
    count = 0
    most_late = 0
    while i<N:
        s, e = flowers[i]
        # 부분문제의 대상이면
        if s <= start < e:
            # 마지막 부분문제이면
            if s <= end < e:
                count += 1
                return count
            most_late = max(e, most_late)
        # 부분문제가 끝났으면
        if start < s:
            count += 1
            start = most_late
            # 다음 부분 문제에서 풀 수 없음을 체크
            if start < s:
                return 0
            i-=1
        i+=1
    return 0

N = int(input())
flowers = []
for i in range(N):
    sm, sd, em, ed = map(int, input().split())
    flowers.append((to_days(sm, sd), to_days(em, ed)))
answer = solve(N, flowers)
print(answer)
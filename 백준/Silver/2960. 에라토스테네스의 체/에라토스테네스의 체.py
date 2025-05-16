N, K = map(int, input().split())
nums = [False] * (N+1)


def solve():
    count = 0
    for P in range(2, N+1):
        if nums[P]:
            continue

        num = P
        while num <= N:
            if not nums[num]:
                nums[num] = True
                count += 1
                if count == K:
                    return num
            num += P

answer = solve()
print(answer)
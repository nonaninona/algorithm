from collections import deque

T = int(input())

for _ in range(T):
    N, M = map(int, input().split())
    nums = list(map(int, input().split()))

    queue = deque()

    for (i, num) in enumerate(nums):
        if i == M:
            queue.append((num, True))
            continue

        queue.append((num, False))

    nums.sort(reverse=True)

    j = 0
    count = 1
    while queue:
        if nums[j] > queue[0][0]:
            queue.append(queue.popleft())
            continue

        (number, isTarget) = queue.popleft()
        j+=1
        if isTarget:
            print(count)
            break

        count += 1
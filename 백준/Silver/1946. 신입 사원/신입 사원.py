import sys
T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    N = int(sys.stdin.readline().rstrip())
    nums = [tuple(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]
    nums.sort(key=lambda x:x[0])

    count = 0
    minimum = 100_001
    for (a, b) in nums:
        if b < minimum:
            minimum = b
            count += 1
    print(count)
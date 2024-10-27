import sys
N = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().rstrip().split()))
numsTuple = []
for i in range(N):
    numsTuple.append((nums[i], i))
numsTuple.sort()

v = 0
maximum = numsTuple[0][0]
ans = [0] * N
for (num, i) in numsTuple:
    if maximum < num:
        maximum = num
        v +=1
    ans[i] = v
for i in ans:
    print(i, end=' ')
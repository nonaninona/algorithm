import sys
isExist = [False for i in range(2_000_000)]

N = int(input())
nums = list(map(int, sys.stdin.readline().rstrip().split()))
for num in nums:
    isExist[num] = True
target = int(input())

count = 0
for i in range(1, target // 2 + 1):
    if i == target - i:
        continue
    if isExist[i] and isExist[target-i]:
        count += 1
print(count)
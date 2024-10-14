import sys
input = sys.stdin.readline
print = sys.stdout.write

N = int(input().strip())
nums = []
for _ in range(N):
    nums.append(int(input().strip()))
nums.sort()

counts = [0 for _ in range(4000 + 1 + 4000)]
for num in nums:
    counts[num+4000] += 1

maxCount = -1
maxNums = []
for (i, count) in enumerate(counts):
    if maxCount < count:
        maxCount = count
        maxNums = [i-4000]
    elif maxCount == count:
        maxNums.append(i-4000)
maxNums.sort()
maxNum = -1
if len(maxNums) > 1:
    maxNum = maxNums[1]
else:
    maxNum = maxNums[0]

print(str(round(sum(nums)/N)) + "\n")
print(str(nums[N//2]) + "\n")
print(str(maxNum) + "\n")
print(str(max(nums)-min(nums)) + "\n")

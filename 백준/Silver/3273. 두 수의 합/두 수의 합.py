import sys
N = int(input())
nums = list(map(int, sys.stdin.readline().rstrip().split()))
nums.sort()
target = int(input())

count = 0
start = 0
end = N-1
while start < end:
    if nums[start] + nums[end] == target:
        count += 1
        end -= 1
    elif nums[start] + nums[end] < target:
        start += 1
    elif nums[start] + nums[end] > target:
        end -= 1
print(count)
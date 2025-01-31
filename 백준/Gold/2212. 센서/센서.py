N = int(input())
K = int(input())
nums = list(map(int, input().split()))
nums.sort()
total = nums[-1] - nums[0]
ranges = []

for i in range(len(nums)-1):
    if nums[i+1] - nums[i] != 0:
        ranges.append(nums[i+1]-nums[i])

# print(ranges)
ranges.sort()
ans = ranges[:len(ranges)-K+1]
print(sum(ans))
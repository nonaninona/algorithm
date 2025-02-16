N, K = map(int, input().split())
nums = list(map(int, input().split()))

diff = []
for i in range(len(nums)):
    if i == 0:
        continue
    diff.append(nums[i] - nums[i-1])

diff.sort(reverse=True)
ans = sum(diff[K-1:])
print(ans)
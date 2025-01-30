N = int(input())
nums = []
for i in range(N):
    nums.append(int(input()))
nums = nums[::-1]

prev = 20_001
ans = 0
for i, n in enumerate(nums):
    # print(n, prev)
    if n >= prev:
       ans += n-(prev-1)
       nums[i] = prev-1
    prev = nums[i]

print(ans)
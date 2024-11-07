nums = list(map(int, input().split()))

total = 0
for num in nums:
    total += num * num

print(total%10)
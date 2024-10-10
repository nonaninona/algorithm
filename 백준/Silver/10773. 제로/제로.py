k = int(input())
nums = []
for i in range(k):
  nums.append(int(input()))

stack = []
for num in nums:
  if num == 0:
    stack.pop()
  else:
    stack.append(num)

total = 0
for n in stack:
  total += n

print(total)
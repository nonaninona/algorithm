N, K = map(int, input().split())
nums = []
for i in range(1, N+1):
  nums.append(i)

i = 0
count = 0
result = []
while len(nums) != 0:
  if len(nums) == i:
    i = 0
  count+=1
  if count == K:
    result.append(str(nums.pop(i)))
    count = 0
    continue
  i+=1
  
print(f"<{', '.join(result)}>")
# print("<", end="")
# for i in range(len(result)):
#   if i == 0:
#     print(result[i], end="")
#   else:
#     print(", ", result[i], end="")
# print(">")
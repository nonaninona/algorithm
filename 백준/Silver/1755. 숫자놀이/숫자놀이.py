M, N = map(int, input().split())
numberName = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
nums = []
for num in range(M, N+1):
    numList = list(str(num))
    numStr = []
    for j in range(len(numList)):
        numStr.append(numberName[int(numList[j])])
    nums.append((' '.join(numStr), num))
nums.sort()

for i in range(len(nums)):
    if i!= 0 and i%10 == 0:
        print()
    print(nums[i][1], end=' ')
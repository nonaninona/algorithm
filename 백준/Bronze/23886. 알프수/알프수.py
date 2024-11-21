from gc import garbage

X = input()
nums = list(X)

if int(nums[0]) >= int(nums[1]) or int(nums[-2]) <= int(nums[-1]):
    print("NON ALPSOO")
    exit(0)

gradient = int(nums[1])-int(nums[0])
for i in range(2, len(nums)):
    newGradient = int(nums[i]) - int(nums[i-1])
    if gradient * newGradient == 0:
        print("NON ALPSOO")
        exit(0)
    if gradient * newGradient > 0 and gradient != newGradient:
        print("NON ALPSOO")
        exit(0)
    gradient = newGradient
print("ALPSOO")
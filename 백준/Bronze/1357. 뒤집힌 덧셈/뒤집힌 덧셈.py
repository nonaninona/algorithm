import math
X, Y = input().split()

def rev(num):
    ret = 0
    nums = list(num)
    for i in range(len(nums)):
        ret += int(nums[i]) * math.pow(10, i)
    return int(ret)

print(rev(str(rev(X)+rev(Y))))
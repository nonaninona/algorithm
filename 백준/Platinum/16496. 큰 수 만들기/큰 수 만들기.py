from functools import cmp_to_key

N = int(input())
nums = list(input().split())

def compare(x, y):
    a = x + y
    b = y + x
    if a > b:
        return -1
    else:
        return 1

nums.sort(key=cmp_to_key(compare))

ret = ""
for n in nums:
    ret += n

if ret[0] == "0":
    print(0)
    exit()

print(ret)
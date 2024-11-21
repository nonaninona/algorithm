numDict = {
    '-' : 0,
    '\\' : 1,
    '(' : 2,
    '@' : 3,
    '?' : 4,
    '>' : 5,
    '&' : 6,
    '%' : 7,
    '/' : -1
}

while True:
    num = input()
    if num == "#":
        break
    nums = list(num)

    total = 0
    square = 1
    for i in range(-1, -1 * len(nums)-1, -1):
        total += numDict.get(nums[i]) * square
        square *= 8
    print(total)
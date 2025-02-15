N = int(input())
nums = list(map(int, input().split()))
d = {"A" : nums[0], "B" : nums[1], "C" : nums[2], "D" : nums[3], "E" : nums[4], "F" : nums[5]}

one = min(nums)

twos = []
def check(c1, c2, t1, t2):
    if c1 == t1 and c2 == t2 or c1 == t2 and c2 == t1:
        return True
    return False
for c1 in d:
    for c2 in d:
        if c1 == c2:
            continue
        if check(c1, c2, "A", "F"):
            continue
        if check(c1, c2, "B", "E"):
            continue
        if check(c1, c2, "C", "D"):
            continue
        twos.append(d[c1]+d[c2])
two = min(twos)

three = min([d["A"] + d["B"] + d["D"],
             d["A"] + d["B"] + d["C"],
             d["A"] + d["E"] + d["D"],
             d["A"] + d["E"] + d["C"],
             d["F"] + d["B"] + d["D"],
             d["F"] + d["B"] + d["C"],
             d["F"] + d["E"] + d["D"],
             d["F"] + d["E"] + d["C"]])

if N == 1:
    print(sum(nums) - max(nums))
elif N == 2:
    print(three * 4 + two * 4)
else:
    print(three * 4 + two * (2*N-3) * 4 + one * ((N-1) * (N-2) * 4 + (N-2)*(N-2)))
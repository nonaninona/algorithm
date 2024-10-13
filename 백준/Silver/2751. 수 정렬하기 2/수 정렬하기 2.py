import sys
sinput = sys.stdin.readline
sprint = sys.stdout.write
N = int(sinput().rstrip())
nums = []
for _ in range(N):
    nums.append(int(sinput().rstrip()))
nums.sort()
for num in nums:
    sprint(str(num) + "\n")
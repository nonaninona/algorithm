import sys
input = sys.stdin.readline

N = int(input())
nums = []
for _ in range(N):
    nums.append(int(input()))
nums.sort()

total = 0
for i, n in enumerate(nums):
    total += abs(i+1 - n)
print(total)
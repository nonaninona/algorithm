from itertools import combinations
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
m = []
storeList = []
homeList = []

for i in range(N):
    nums = list(map(int, sys.stdin.readline().rstrip().split()))
    for j in range(N):
        num = nums[j]
        if num == 2:
            storeList.append((i, j))
            nums[j] = 0
        if num == 1:
            homeList.append((i, j))

storeComb = list(combinations(storeList, M))
minDistance = 210000000
for comb in storeComb: #1716
    distance = []
    for (hy, hx) in homeList:
        d = 210000000
        for (sy, sx) in comb:
            curD = abs(hy-sy) + abs(hx-sx)
            if curD < d:
                d = curD
        distance.append(d)
    sumD = sum(distance)
    if sumD < minDistance:
        minDistance = sumD
print(minDistance)
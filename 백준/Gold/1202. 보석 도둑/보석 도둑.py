import heapq
from heapq import heappush, heappop
import sys

def find():
    N, K = map(int, sys.stdin.readline().rstrip().split())
    jewels = [tuple(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]
    bags = [int(sys.stdin.readline().rstrip()) for i in range(K)]
    bags.sort()
    jewels.sort()

    h = []
    ans = 0
    j = 0

    for b in bags:
        while True:
            if j == len(jewels):
                break
            if b < jewels[j][0]:
                break
            heappush(h, (-jewels[j][1]))
            j+=1
        if len(h) == 0:
            continue
        ans -= heappop(h)
    return ans

answer = find()
print(answer)
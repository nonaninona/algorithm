import sys
import heapq
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    K = int(input())
    h = list(map(int, input().split()))

    heapq.heapify(h)

    total = 0
    for i in range(len(h)-1):
        first = heapq.heappop(h)
        second = heapq.heappop(h)

        sum = first + second
        total += sum

        heapq.heappush(h, sum)
    print(total)
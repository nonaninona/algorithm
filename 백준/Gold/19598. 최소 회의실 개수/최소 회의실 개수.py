import sys
input = sys.stdin.readline

import heapq

N = int(input())
times = [tuple(map(int, input().split())) for i in range(N)]

def solve():
    global times

    times.sort()
    q = [times[0][1]]
    heapq.heapify(q)

    ret = 1
    for s, e in times[1:]:
        top = heapq.heappop(q)
        if top <= s:
            heapq.heappush(q, e)
        else:
            heapq.heappush(q, top)
            heapq.heappush(q, e)
            ret += 1
    return ret

answer = solve()
print(answer)
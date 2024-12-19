from collections import deque
import heapq

N, K = map(int, input().split())

visited = [False for _ in range(100_001)]
ret = -1
queue = []
heapq.heappush(queue, (0, N))
while queue:
    (d, n) = heapq.heappop(queue)
    if n < 0 or n > 100_000:
        continue
    if visited[n]:
        continue
    if n == K:
        ret = d
        break

    visited[n] = True
    heapq.heappush(queue, (d, 2*n))
    heapq.heappush(queue, (d+1, n+1))
    heapq.heappush(queue, (d+1, n-1))

print(ret)
import heapq
import sys

N = int(sys.stdin.readline().rstrip())
classes = [list(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]

h = []
classes.sort(key=lambda x : x[0])

for c in classes:
    if len(h) == 0:
        heapq.heappush(h, c[1])
        continue

    if c[0] >= h[0]:
        heapq.heappop(h)
        heapq.heappush(h, c[1])
    else:
        heapq.heappush(h, c[1])

sys.stdout.write(str(len(h)) + '\n')
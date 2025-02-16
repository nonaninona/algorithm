import heapq

N = int(input())
works = [list() for i in range(10001)]

for _ in range(N):
    w, d = map(int, input().split())
    works[d].append(w)
# print(works)

h = []
heapq.heapify(h)
works.reverse()

ans = 0
for i, w in enumerate(works):
    if i == len(works)-1:
        break
    for num in w:
        heapq.heappush(h, -1 * num)
    if len(h) > 0:
        ans += -1 * heapq.heappop(h)
print(ans)
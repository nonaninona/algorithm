import heapq, sys
N, M = map(int, sys.stdin.readline().rstrip().split())
A = list(map(int, sys.stdin.readline().rstrip().split()))

heapq.heapify(A)

for i in range(M):
    a = heapq.heappop(A)
    b = heapq.heappop(A)
    heapq.heappush(A, a+b)
    heapq.heappush(A, a+b)

print(sum(A))
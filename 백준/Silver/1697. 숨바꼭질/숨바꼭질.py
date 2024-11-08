from collections import deque

N, K = map(int, input().split())
visited = [False] * 100_001
q = deque()
q.append((N, 0))
while q:
    n, sec = q.popleft()
    if n < 0 or n > 100_000:
        continue
    if visited[n]:
        continue
    if n == K:
        print(sec)
        break
    visited[n] = True
    q.append((n*2, sec+1))
    q.append((n-1, sec+1))
    q.append((n+1, sec+1))
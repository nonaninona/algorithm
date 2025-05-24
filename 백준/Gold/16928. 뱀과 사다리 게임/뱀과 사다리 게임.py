from collections import deque

N, M = map(int, input().split())
ladders = {}
for i in range(N):
    s, e = map(int, input().split())
    ladders[s] = e
snakes = {}
for i in range(M):
    s, e = map(int, input().split())
    snakes[s] = e

visited = [False] * 101

def solve():
    q = deque()
    q.append((1, 0))
    visited[1] = True

    while q:
        x, d = q.popleft()
        if x == 100:
            return d

        for i in range(1, 7):
            nx = x + i
            if 1 <= nx <= 100:
                if nx in ladders:
                    if not visited[ladders[nx]]:
                        visited[ladders[nx]] = True
                        q.append((ladders[nx], d+1))
                elif nx in snakes:
                    if not visited[snakes[nx]]:
                        visited[snakes[nx]] = True
                        q.append((snakes[nx], d+1))
                else:
                    if not visited[nx]:
                        visited[nx] = True
                        q.append((nx, d+1))

ans = solve()
print(ans)
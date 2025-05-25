from collections import deque

N, M = map(int, input().split())
truth = list(map(int, input().split()))[1:]
g = [[] for i in range(N+M)]
visited = [False] * (N+M)
for i in range(M):
    people = list(map(int, input().split()))[1:]
    for p in people:
        g[i+N].append(p-1)
        g[p-1].append(i+N)

def solve():
    queue = deque()

    for t in truth:
        queue.append(t-1)
        visited[t-1] = True


    while queue:
        n = queue.popleft()

        for e in g[n]:
            if visited[e]:
                continue
            visited[e] = True
            queue.append(e)

    ret = 0
    for i in range(N, N+M):
        if not visited[i]:
            ret +=1
    return ret


ans = solve()
print(ans)
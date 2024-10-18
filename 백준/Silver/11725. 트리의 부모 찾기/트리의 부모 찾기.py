from collections import deque
import sys

N = int(sys.stdin.readline().rstrip())
g = [[] for i in range(N+1)]
for _ in range(N-1):
    (s, e) = map(int, sys.stdin.readline().rstrip().split())
    g[s].append(e)
    g[e].append(s)

def bfs():
    queue = deque()
    queue.append(1)
    ans = [0 for i in range(N+1)]
    ans[1] = -1
    while queue:
        n = queue.popleft()
        for e in g[n]:
            if ans[e] == 0:
                ans[e] = n
                queue.append(e)
    return ans

answer = bfs()
for i in range(2, N+1):
    sys.stdout.write(str(answer[i]) + "\n")
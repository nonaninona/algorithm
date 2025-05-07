import sys
from collections import deque
input = sys.stdin.readline


def solve(V, E, g):
    queue = deque()
    visited = [False] * V
    groups = [0] * V

    for i in range(V):
        if not visited[i]:
            queue.append((i, 1))
            groups[i] = 1

            while queue:
                n, group = queue.popleft()

                if visited[n]:
                    continue
                for e in g[n]:
                    prev_group = groups[e]
                    cur_group = group*-1

                    if prev_group == 0:
                        groups[e] = cur_group
                        queue.append((e, cur_group))
                        continue

                    if prev_group != cur_group:
                        return "NO"

                    queue.append((e, cur_group))

                visited[n] = True

    return "YES"

K = int(input())
for i in range(K):
    V, E = map(int, input().split())
    g = [[] for i in range(V)]
    for i in range(E):
        s, e = map(int, input().split())
        g[s-1].append(e-1)
        g[e-1].append(s-1)
    answer = solve(V, E, g)
    print(answer)
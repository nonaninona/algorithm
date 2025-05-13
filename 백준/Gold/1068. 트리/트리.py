from collections import deque

N = int(input())
parents = list(map(int, input().split()))
del_n = int(input())

def solve():
    edges = [[] for i in range(N)]
    start = 0
    for i in range(N):
        p = parents[i]
        if p == -1:
            start = i
            continue
        if p == del_n or i == del_n:
            continue
        edges[p].append(i)


    ret = 0

    if start == del_n:
        return ret

    queue = deque()
    queue.append(start)

    while queue:
        cur = queue.popleft()
        if len(edges[cur]) == 0:
            ret += 1
            continue
        for v in edges[cur]:
            queue.append(v)
    return ret

answer = solve()
print(answer)
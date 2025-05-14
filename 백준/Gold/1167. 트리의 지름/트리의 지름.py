import sys
sys.setrecursionlimit(10**6)

V = int(input())
graph = [[] for i in range(V)]
for i in range(V):
    nums = list(map(int, input().split()))
    node = nums[0]
    j = 1
    while True:
        e = nums[j]
        if e == -1:
            break
        w = nums[j+1]

        graph[node-1].append((e-1, w))

        j += 2

visited = [False] * V

def dfs(cur):
    cur_max, max_len = 0, 0

    visited[cur] = True

    visit_count = 0
    length = []
    for e, w in graph[cur]:
        if visited[e]:
            continue
        m, l = dfs(e)
        cur_max = max(cur_max, m)
        length.append(l+w)
        visit_count += 1

    if visit_count == 0:
        return 0, 0

    length.sort()
    max_len = length[-1]

    if len(length) == 1:
        cur_max = max(cur_max, max_len)
    else:
        cur_max = max(cur_max, length[-1] + length[-2])

    return cur_max, max_len


answer = dfs(0)
print(answer[0])
import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline

N = int(input())
tree = [[] for i in range(N)]
for i in range(N-1):
    p, c, w = map(int, input().split())
    tree[p-1].append((c-1,w))

def dfs(n):
    # print(n, tree[n])
    if len(tree[n]) == 0:
        return 0, 0

    maximum, ret = 0, 0

    children = []
    for e, w in tree[n]:
        m, r = dfs(e)
        maximum = max(maximum, m)
        children.append(r + w)

    children.sort(reverse=True)
    maximum = max(maximum, sum(children[:min(2, len(children))]))

    # print(maximum, children[0])

    # max, return
    return maximum, children[0]

def solve():
    global tree

    maximum, ret = dfs(0)

    return maximum

answer = solve()
print(answer)
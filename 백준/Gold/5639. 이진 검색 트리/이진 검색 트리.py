import sys
sys.setrecursionlimit(10**6)

nodes = []
while True:
    try:
        n = int(input())
        if n == "":
            break
        nodes.append(n)
    except:
        break

def dfs(n, s, e):
    num = nodes[n]
    left, right = s, e
    for i in range(s, e):
        if nodes[i] < num:
            left = i
            break
    for i in range(s, e):
        if num < nodes[i]:
            right = i
            break

    if left+1 <= right:
        dfs(left, left+1, right)
    if right+1 <= e:
        dfs(right, right+1, e)
    print(num)

dfs(0, 1, len(nodes))
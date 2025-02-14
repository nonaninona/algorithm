import sys
input = sys.stdin.readline

G = int(input())
P = int(input())

links = [i for i in range(G+1)]

def find(g):
    if g != links[g]:
        links[g] = find(links[g])
    return links[g]

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        links[b] = a
    else:
        links[a] = b

count = 0
for _ in range(P):
    n = int(input())
    p = find(n)
    if p > 0:
        union(p, p-1)
        count += 1
    else:
        break

sys.stdout.write(str(count))

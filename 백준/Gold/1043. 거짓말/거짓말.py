N, M = map(int, input().split())
groups = [i for i in range(N)]
truth = list(map(lambda x : x-1, map(int, input().split())))[1:]
parties = [list(map(lambda x: x-1, map(int, input().split())))[1:] for i in range(M)]

def find(i):
    if groups[i] != i:
        groups[i] = find(groups[i])
    return groups[i]

def union(a, b):
    a = find(a)
    b = find(b)

    if a in truth and b not in truth:
        groups[b] = a
        return
    if b in truth and a not in truth:
        groups[a] = b
        return

    if a <= b:
        groups[b] = a
    else:
        groups[a] = b

for people in parties:
    for i in range(len(people)-1):
        union(people[i], people[i+1])

def solve():
    ret = M
    for people in parties:
        for p in people:
            if find(p) in truth:
                ret -= 1
                break
    return ret


ans = solve()
print(ans)
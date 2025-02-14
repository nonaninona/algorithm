N = int(input())
ps = []
for _ in range(N):
    ps.append(tuple(map(int, input().split())))
ps.sort(key=lambda x:(-1 * x[1], x[0]))

links = [i for i in range(N+1)]
def find(n):
    if n != links[n]:
        links[n] = find(links[n])
    return links[n]
def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        links[b] = a
    else:
        links[a] = b

schedule = [0] * (N+1)
for d, n in ps:
    possibleDay = find(d)
    if possibleDay == 0:
        continue

    schedule[possibleDay] = n
    union(possibleDay, possibleDay-1)


# print(ps)
# print(links)
# print(schedule)

print(sum(schedule))
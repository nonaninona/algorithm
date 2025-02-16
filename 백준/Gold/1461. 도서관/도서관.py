N, M = map(int, input().split())
books = list(map(int, input().split()))
books.sort()
nb = []
pb = []

for b in books:
    if b > 0:
        pb.append(b)
    elif b < 0:
        nb.append(-1 * b)
nb.reverse()

# print(nb)
# print(pb)

nbMax = 0
pbMax = 0
if len(nb) > 0:
    nbMax = max(nb)
if len(pb) > 0:
    pbMax = max(pb)

def first(books):
    global M

    ret = 0
    for i in range(len(books), -1, -1 * M):
        target = books[max(i-M, 0):i]
        if len(target) > 0:
            ret += max(target) * 2
    return ret

def second(books):
    global M

    ret = 0
    target = books[max(len(books)-M, 0):len(books)]
    if len(target) > 0:
        ret += max(target)
    ret += first(books[0:max(len(books)-M, 0)])
    return ret

ret = 0
if nbMax > pbMax:
    ret += first(pb)
    ret += second(nb)
else:
    ret += first(nb)
    ret += second(pb)

print(ret)
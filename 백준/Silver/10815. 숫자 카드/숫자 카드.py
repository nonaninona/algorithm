import sys
N = int(sys.stdin.readline().rstrip())
cards = list(map(int, sys.stdin.readline().rstrip().split()))
M = int(sys.stdin.readline().rstrip())
finds = list(map(int, sys.stdin.readline().rstrip().split()))
findsTuple = []
for i in range(len(finds)):
    findsTuple.append((finds[i], i))
cards.sort()
findsTuple.sort()
ans = [0] * M

i, j = 0, 0
while True:
    if i == M or j == N:
        break
    f, num = findsTuple[i]
    c = cards[j]
    if f == c:
        ans[num] = 1
        i+=1
    elif f < c:
        i+=1
        continue
    j+=1

for a in ans:
    print(a, end=" ")
import sys
N = int(sys.stdin.readline().rstrip())
cards = list(map(int, sys.stdin.readline().rstrip().split()))
M = int(sys.stdin.readline().rstrip())
originalFinds = list(map(int, sys.stdin.readline().rstrip().split()))
finds = originalFinds[:]
counts = {}
for f in finds:
    counts[f] = 0
cards.sort()
finds.sort()

j = 0
for i in range(len(finds)):
    find = finds[i]
    while True:
        if j == len(cards):
            break
        if find == cards[j]:
            counts[find] = counts[find] + 1
        if find < cards[j]:
            break
        j+=1
for o in originalFinds:
    sys.stdout.write(str(counts[o]) + " ")
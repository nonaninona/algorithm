N = int(input())
cards = list(map(int, input().split()))
M = int(input())
originalFinds = list(map(int, input().split()))
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
    print(counts[o], end=" ")
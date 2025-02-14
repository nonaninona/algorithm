N = int(input())
cranes = list(map(int, input().split()))
M = int(input())
boxes = list(map(int, input().split()))

if max(boxes) > max(cranes):
    print(-1)
    exit(0)

boxes.sort(reverse=True)
cranes.sort(reverse=True)
counts = [0] * N

# print("cranes : ", cranes)
# print("boxes : ", boxes)
for b in boxes:
    end = len(cranes)
    for i, c in enumerate(cranes):
        if b > c:
            end = i
            break
    # print("end : ", end)

    minCount = 10_001
    minIdx = -1
    for i, c in enumerate(counts[:end]):
        if minCount >= c:
            minCount = c
            minIdx = i

    counts[minIdx] += 1

print(max(counts))
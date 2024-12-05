import math
counts = [0] * 10
N = list(input())
for number in N:
    counts[int(number)] += 1

MAXIMUM = 0
for (i, number) in enumerate(counts):
    if i == 6 or i == 9:
        continue
    MAXIMUM = max(number, MAXIMUM)
MAXIMUM = max(math.ceil((counts[6] + counts[9]) / 2), MAXIMUM)
print(int(MAXIMUM))
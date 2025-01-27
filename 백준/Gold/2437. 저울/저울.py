N = int(input())
ws = list(map(int, input().split()))
ws.append(2_000_000_000)
ws.sort()

total = 0
for i, w in enumerate(ws):
    if total + 1 < w:
        break
    total += w
print(total + 1)
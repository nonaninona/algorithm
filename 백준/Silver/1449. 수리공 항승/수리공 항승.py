# 그냥 가장 왼쪽부터??
N, L = map(int, input().split())
leaks = list(map(int, input().split()))
leaks.sort()

count = 0
taped = 0
for point in leaks:
    if taped == 0:
        taped = point-0.5+L
        count += 1
        continue
    if point < taped:
        continue
    taped = point - 0.5 + L
    count += 1
print(count)
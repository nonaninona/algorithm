N = int(input())
C = []
for i in range(N):
    C.append(int(input()))
C.sort(reverse=True)

total = 0
for i in range(N):
    if i % 3 == 2:
        continue
    total += C[i]
print(total)
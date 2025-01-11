N = int(input())
A = list(map(int, input().split()))
R = [0] * N
L = [0] * N

total = sum(A)
r = total % 2
half = total // 2

s = 0
for i in range(N):
    if s + A[i] >= half:
        count = half - s
        R[i] = count
        A[i] -= count
        break
    s += A[i]
    R[i] = A[i]
    A[i] = 0

s = 0
for i in range(N-1, -1, -1):
    if s + A[i] >= half:
        count = half - s
        L[i] = count
        A[i] -= count
        break
    s += A[i]
    L[i] = A[i]
    A[i] = 0

if r == 0:
    for i in range(N):
        if L[i] > 0:
            L[i] -= 1
            A[i] += 1
            break

# print(A)
# print(R)
# print(L)
ret1 = 0
ret2 = 0
for i in range(N):
    ret1 += R[i] * i * 2
# print(ret1)
for i in range(N-1, -1, -1):
    ret2 += L[i] * (N - i) * 2
# print(ret2)
ret3 = 0
# print(r)
if r == 0:
    for i in range(N):
        ret3 += A[i] * (N - i)
else:
    for i in range(N):
        ret3 += A[i] * i
# print(ret3)
print(ret1+ret2+ret3)
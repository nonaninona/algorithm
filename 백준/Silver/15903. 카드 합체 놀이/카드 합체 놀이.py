N, M = map(int, input().split())
A = list(map(int, input().split()))

for i in range(M):
    A.sort()
    A.append(A[0] + A[1])
    A.append(A[0] + A[1])
    A = A[2:]

print(sum(A))
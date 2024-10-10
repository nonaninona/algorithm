N = int(input())

A = list(map(int, input().split()))
B = list(map(int, input().split()))

A.sort(reverse=True)
B.sort()

total = 0
for i in range(N):
  total += A[i] * B[i]

print(total)
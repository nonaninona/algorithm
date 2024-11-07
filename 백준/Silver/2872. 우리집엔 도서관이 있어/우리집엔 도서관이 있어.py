import sys
N = int(sys.stdin.readline().rstrip())
books = [0] * N
for i in range(N):
    books[int(sys.stdin.readline().rstrip())-1] = i

ans = 0
for i in range(N-2, -1, -1):
    if books[i] > books[i+1]:
        ans = i+1
        break
print(ans)
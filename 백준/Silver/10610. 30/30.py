N = list(map(int, input()))
N.sort(reverse=True)
if N[-1] != 0:
    print(-1)
    exit(0)
if sum(N) % 3 != 0:
    print(-1)
    exit(0)
NStrs = ""
for num in N:
    NStrs += str(num)
print(NStrs)
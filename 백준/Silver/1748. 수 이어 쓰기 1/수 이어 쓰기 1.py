N = int(input())

ret = 0
cut = 1
while cut <= N:
    ret += N-cut+1
    cut *= 10

print(ret)
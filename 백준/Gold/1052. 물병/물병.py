N, K = map(int, input().split())

count = 0
while bin(N).count("1") > K:
    pos = bin(N)[::-1].index("1")
    N += 2**pos
    count += 2**pos
print(count)
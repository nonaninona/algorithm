N, M = map(int, input().split())
S = []
for _ in range(N):
    S.append(input())

ret = ""
dist = 0
DNA = ["A", "C", "G", "T"]
for j in range(M):
    counts = [0, 0, 0, 0] # A, C, G, T

    for i in range(N):
        if S[i][j] == "A":
            counts[0] += 1
        elif S[i][j] == "C":
            counts[1] += 1
        elif S[i][j] == "G":
            counts[2] += 1
        else:
            counts[3] += 1

    maxIdx = -1
    maxC = -1
    for i, c in enumerate(counts):
        if c > maxC:
            maxIdx = i
            maxC = c

    ret += DNA[maxIdx]
    dist += sum(counts) - counts[maxIdx]
print(ret)
print(dist)
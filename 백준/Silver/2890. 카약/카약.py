R, C = map(int, input().split())
remains = []
for i in range(9):
    remains.append([i, 0])
for i in range(R):
    line = list(input())
    for j in range(len(line)-2,-1,-1):
        if line[j] == 'S':
            break
        if line[j] != '.':
            remains[int(line[j])-1][1] = len(line)-2 - j
            break
remains.sort(key=lambda x : x[1])

ranks = [0] * 9
rank = 0
before = -1
for (t, r) in remains:
    if r == before:
        ranks[t] = rank
    else:
        rank += 1
        ranks[t] = rank
    before = r

for r in ranks:
    print(r)
N = int(input())
votes = []
for _ in range(N):
    votes.append(int(input()))

def check():
    global votes
    maxIdx = -1
    maxV = -1
    for i, v in enumerate(votes):
        if v >= maxV:
            maxV = v
            maxIdx = i
    return maxIdx

count = 0
maxIdx = check()
while maxIdx != 0:
    votes[0] += 1
    votes[maxIdx] -= 1
    count += 1
    maxIdx = check()

print(count)
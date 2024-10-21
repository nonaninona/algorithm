import sys
N, M = map(int, sys.stdin.readline().rstrip().split())
namesUnSeen = [sys.stdin.readline().rstrip() for i in range(N)]
namesUnSeen.sort()
namesUnHeard = [sys.stdin.readline().rstrip() for i in range(M)]
namesUnHeard.sort()

i, j = 0, 0
ans = []
while True:
    if i == N or j==M:
        break
    name = namesUnSeen[i]
    if name == namesUnHeard[j]:
        ans.append(name)
        j+=1
    elif name > namesUnHeard[j]:
        j+=1
        continue
    i+=1
sys.stdout.write(str(len(ans)) + "\n")
for n in ans:
    sys.stdout.write(n+"\n")
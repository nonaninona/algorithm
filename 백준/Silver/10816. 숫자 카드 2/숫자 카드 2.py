import sys
N = int(sys.stdin.readline().rstrip())
cards = list(map(int, sys.stdin.readline().rstrip().split()))
counts = {}
for c in cards:
    if c in counts:
        counts[c] += 1
    else:
        counts[c] = 1

M = int(sys.stdin.readline().rstrip())
finds = list(map(int, sys.stdin.readline().rstrip().split()))
for f in finds:
    sys.stdout.write(str(counts.get(f, 0)) + " ")
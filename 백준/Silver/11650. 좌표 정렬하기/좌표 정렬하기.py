import sys
N = int(sys.stdin.readline().rstrip())
dots = [tuple(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]
dots.sort(key = lambda x: (x[0], x[1]))
for (x, y) in dots:
    sys.stdout.write(str(x) + " " + str(y) + "\n")
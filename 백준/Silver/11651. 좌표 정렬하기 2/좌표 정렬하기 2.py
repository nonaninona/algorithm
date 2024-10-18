import sys
N = int(input())
points = [tuple(map(int, sys.stdin.readline().rstrip().split())) for i in range(N)]
points.sort(key=lambda x:(x[1], x[0]))
for (x, y) in points:
    sys.stdout.write(str(x) + " " + str(y) + "\n")
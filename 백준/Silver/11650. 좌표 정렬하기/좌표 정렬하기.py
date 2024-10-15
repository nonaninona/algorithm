N = int(input())
dots = [tuple(map(int, input().split())) for i in range(N)]
dots.sort(key = lambda x: (x[0], x[1]))
for (x, y) in dots:
    print(x, y)
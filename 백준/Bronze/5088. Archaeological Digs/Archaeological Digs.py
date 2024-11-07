while True:
    gridX, gridY = map(int, input().split())
    if gridX == 0 and gridY == 0:
        break
    counts = [[0 for i in range(gridY)] for j in range(gridX)]
    M = int(input())
    for i in range(M):
        x, y = map(int, input().split())
        counts[y][x] += 1
    N = int(input())
    total = 0
    for i in range(N):
        x, y = map(int, input().split())
        total += counts[y][x]
    print(total)
import sys
sys.setrecursionlimit(10**6)
N, L, R = map(int, sys.stdin.readline().rstrip().split())
people = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
count = 0
while True:
    group_nums = [[-1 for i in range(N)] for j in range(N)]
    group_num = 0
    group_sum = [0] * 2500
    group_count = [0] * 2500

    Dx = [-1, 0, 1, 0]
    Dy = [0, -1, 0, 1]

    def dfs(y, x, prev, n):
        if x < 0 or y < 0 or x >= N or y >= N:
            return False
        if group_nums[y][x] != -1:
            return False
        diff = prev - people[y][x]
        if abs(diff) < L or abs(diff) > R:
            return False

        group_sum[n] += people[y][x]
        group_count[n] += 1
        group_nums[y][x] = n

        for dy, dx in zip(Dy, Dx):
            nx = dx+x
            ny = dy+y
            dfs(ny, nx, people[y][x], n)

        return True


    for i in range(N):
        for j in range(N):
            if dfs(i, j, people[i][j]+R, group_num):
                group_num += 1
    group_average = []
    for n, c in zip(group_sum, group_count):
        if c == 0:
            break
        group_average.append(n//c)

    for i in range(N):
        for j in range(N):
            people[i][j] = group_average[group_nums[i][j]]
    count+=1
    if len(group_average) == N*N:
        break
print(count-1)
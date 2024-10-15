from collections import deque

N, M = list(map(int, input().split()))
grid = [list(map(int, input().split())) for _ in range(N)]

# get coordinates that are not walls nor virus (for comb)
empty = []
viruses = []
for i in range(N):
    for j in range(M):
        if grid[i][j] == 0:
            empty.append((i, j))
        if grid[i][j] == 2:
            viruses.append((i, j))

# get empty Comb 3
k = 3
visited = [False for _ in range(len(empty))]
def combination(idx, arr, out):
    if len(arr) == k:
        out.append(arr)
        return

    for i in range(idx+1, len(empty)):
        if visited[i] == False:
            visited[i] = True
            combination(i, arr + [empty[i]], out)
            visited[i] = False

wall_comb = []
combination(-1, [], wall_comb)

# fill in the walls
def fill_walls(walls, original_grid):
    new_grid = [row[:] for row in original_grid]
    for wall in walls:
        wy, wx = wall
        new_grid[wy][wx] = 1
    return new_grid

# spread virus
def speard_virus(original_grid, viruses):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    new_grid = [row[:] for row in original_grid]
    visited = [[False for _ in range(M)] for _ in range(N)]
    def bfs(y, x):
        queue = deque()
        queue.append((y, x))
        visited[y][x] = True
        while queue:
            cy, cx = queue.popleft()
            for i in range(4):
                ny, nx = cy + dy[i], cx + dx[i]
                if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == False and new_grid[ny][nx] == 0:
                    queue.append((ny, nx))
                    visited[ny][nx] = True
                    new_grid[ny][nx] = 2

    for virus in viruses:
        vy, vx = virus
        bfs(vy, vx)
    return new_grid

# count the number of 0s
def count_zeros(grid):
    cnt = 0
    for i in range(N):
        for j in range(M):
            if grid[i][j] == 0:
                cnt += 1
    return cnt

max_area = 0
for each_wall in wall_comb:
    filled_grid = fill_walls(each_wall, grid)
    final_grid = speard_virus(filled_grid, viruses)
    area = count_zeros(final_grid)
    max_area = max(max_area, area)

print(max_area)
from collections import deque

N, K = map(int, input().split())
visited = [-1] * 100_001

def solve():
    if N == K:
        return 0, 1

    q = deque()

    q.append((N, 0))
    visited[N] = 0

    min_time, count = 2100000000, 0
    while q:
        pos, time = q.popleft()

        if min_time+1 == time:
            break

        if pos == K:
            min_time = time
            count += 1
            continue

        for n_pos in [pos-1, pos+1, pos*2]:
            if 0 <= n_pos <= 100_000:
                if visited[n_pos] == -1 or visited[n_pos] == time+1:
                    visited[n_pos] = time+1
                    q.append((n_pos, time + 1))

    return min_time, count


ans = solve()
print(ans[0])
print(ans[1])
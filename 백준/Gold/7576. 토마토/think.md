# 생각의 흐름
1. 어... 시뮬레이션 해야 하나??
근데 그러면 언제까지 시뮬레이션을 해야하지? 최악의 경우 한 2,000 정도 같고...
그러면 시간이... 2,000 x 1,000 x 1,000 = 2억;; 안될 듯
2. 아 거리로 생각하면 되네 bfs 써야겠다
3. 1인 칸에서 bfs 돌리는 거 반복하면 되겠네
4. 어 왜 시간초과지??
5. 순회 = N^2, bfs = N이라서
순회하면서 1인 칸마다 매번 bfs 때리면 N^3 = 1억임
6. 아 그냥 bfs는 한 번만 돌리면 되는구나...

파이썬에서 시간측정하기
```
import time
stime = time.time()
# some works
etime = time.time()
print(etime-stime)
```
근데 파이썬이라 시간이 1초는 우습게 넘음 ㅋㅋ;;
기준을 뭘로 잡아야 할 지 잘 모르겠네..

# 다른 사람 답 참고
나보다 3배 가량 빠른 사람이 있는데 이유를 잘 모르겠다;;
3배까지 날 게 있나??

```
from collections import deque

a, b = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(b)]

def bfs(arr, que):
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    while que:
        i, k = que.popleft()
        for t in range(4):
            x = i + dx[t]
            y = k + dy[t]

            if 0 <= x < b and 0 <= y < a:
                if arr[x][y] == 0:
                    arr[x][y] = arr[i][k] + 1  # 익은 날짜 계산
                    que.append((x, y))
    
    # 모든 칸 중에서 최대 값을 반환
    return max(max(row) for row in arr) - 1

q = deque()
for i in range(b):
    for j in range(a):
        if arr[i][j] == 1:
            q.append((i, j))

ans = bfs(arr, q)

# 익지 않은 토마토가 있는지 확인
for i in range(b):
    for j in range(a):
        if arr[i][j] == 0:
            print(-1)
            exit(0)

# 모든 토마토가 익었다면 최소 날짜 출력
print(ans)
```

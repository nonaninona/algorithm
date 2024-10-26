# 생각의 흐름
1. 음... 이게 단순히 그래프 탐색으로 하기에는... 경로라는 특수성(다 탐색하는 게 아님)을 어떻게 표현할 지 모르겠네
2. 시간 복잡도는 일단 크게 문제 없을 것 같긴 한데...(O(N+E) = 1,250,000) 아닌가? visited 활용하려면 좀 오래 걸릴 수도..
3. 악 그냥 완탐 + dp 식으로 생각해보자..
4. 아 그런데 이게 꼭 왼쪽 위에서 오른쪽 아래로 진행하는 게 아니네.. 계산하는 순서를 어떻게 잡지
5. 어?? 큰 수 부터 따지면 되겠네
6. 입력 받은 숫자들을 숫자 크기대로 정렬해서, 숫자가 큰 순서대로 dp 적용해주기

# 다른 사람 답 참고
어라 다른 사람들.. 나보다 7배는 빠르네;;
아하 dfs를 저렇게 이용하면 되는구나;;

```
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**4*25)

M, N = map(int, input().split())
li = [list(map(int, input().split())) for _ in range(M)]

cache = [[-1] * N for _ in range(M)]
cache[-1][-1] = 1
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def dfs(x,y):
    if cache[y][x] != -1:
        return cache[y][x]

    cnt = 0
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if not(0<= nx < N and 0<= ny < M):
            continue
        if li[y][x] > li[ny][nx]:
            cnt += dfs(nx,ny)
    cache[y][x] = cnt
    return cnt

dfs(0,0)
print(cache[0][0])
```

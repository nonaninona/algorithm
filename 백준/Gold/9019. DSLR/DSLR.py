from collections import deque
import sys

input = sys.stdin.readline

def D(n):
    return n*2%10000
def S(n):
    n -= 1
    if n < 0:
        return 9999
    return n
def L(n):
    n = (n % 1000) * 10 + n // 1000
    return n
def R(n):
    n = n % 10 * 1000 + n // 10
    return n


T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    visited = [False] * 10000

    q = deque()
    q.append((A, ""))
    visited[A] = True

    while q:
        num, step = q.popleft()
        if num == B:
            print(step)
            break

        d = D(num)
        if not visited[d]:
            visited[d] = True
            q.append((d, step + "D"))

        s = S(num)
        if not visited[s]:
            visited[s] = True
            q.append((s, step + "S"))

        l = L(num)
        if not visited[l]:
            visited[l] = True
            q.append((l, step + "L"))


        r = R(num)
        if not visited[r]:
            visited[r] = True
            q.append((r, step + "R"))
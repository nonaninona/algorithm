N = int(input())
taller = list(map(int, input().split()))
order = list(range(1, N+1))
ans = [0] * N

for i, t in enumerate(taller):
    ans[order[t]-1] = i+1
    order.remove(order[t])

for n in ans:
    print(n, end=" ")
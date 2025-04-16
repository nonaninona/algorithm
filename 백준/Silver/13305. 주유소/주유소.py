def solve(N, dist, cost):
    min_cost = 1_000_000_001
    answer = 0
    for d, c in zip(dist, cost):
        min_cost = min(c, min_cost)
        answer += d * min_cost
    print(answer)

N = int(input())
dist = list(map(int, input().split()))
cost = list(map(int, input().split()))

solve(N, dist, cost)
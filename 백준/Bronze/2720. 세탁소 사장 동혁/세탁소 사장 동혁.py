def solve(cent):
    types = [25, 10, 5, 1]
    for t in types:
        count = cent // t
        cent -= count * t
        print(count, end=" ")
    print()

T = int(input())
for _ in range(T):
    C = int(input())
    solve(C)
N, M = map(int, input().split())

def solve(sequence, step):
    if step == M:
        for n in sequence:
            print(n, end=' ')
        print()
        return

    last = 1
    if len(sequence) != 0:
        last = sequence[-1]
    for i in range(last, N+1):
        s = sequence[:]
        s.append(i)
        solve(s, step+1)

solve([], 0)
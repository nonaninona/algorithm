def solve(T):
    time_unit = [300, 60, 10]
    counts = []
    for t in time_unit:
        count = T // t
        T -= count * t
        counts += [count]

    if T != 0:
        return [-1]

    return counts

T = int(input())

counts = solve(T)
for c in counts:
    print(c, end=" ")
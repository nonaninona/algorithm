S = input()
T = input()

def solve():
    global S, T

    while T != S:
        if len(T) == 0:
            print(0)
            return

        if T[-1] == 'A':
            T = T[:len(T)-1]
        elif T[-1] == 'B':
            T = T[:len(T)-1]
            T = T[::-1]

    print(1)

solve()
while True:
    try:
        S, T = input().split()

        def solve():
            i = 0
            for t in T:
                if i == len(S):
                    break
                if S[i] == t:
                    i += 1
            if i == len(S):
                return "Yes"
            return "No"

        print(solve())
    except EOFError:
        break

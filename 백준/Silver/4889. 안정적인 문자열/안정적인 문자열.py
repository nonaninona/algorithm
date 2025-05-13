number = 1

while True:
    string = list(input())
    if "-" in string:
        break

    N = len(string)

    def solve():
        open = 0
        ret = 0
        for i in range(N):
            s = string[i]
            remain = N - i

            if open == remain:
                if s == "{":
                    ret += 1
                open -= 1
                continue

            if s == "{":
                open += 1
                continue

            if s == "}" and open == 0:
                ret += 1
                open += 1
                continue

            open -=1

        return ret

    answer = solve()
    print(str(number) + ". " + str(answer))

    number += 1
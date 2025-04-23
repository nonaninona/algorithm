def solve(N, seats):
    arr = ["*"]
    i = 0
    while i < N:
        if seats[i] == "L":
            arr += ["L", "L", "*"]
            i += 1
        elif seats[i] == "S":
            arr += ["S", "*"]
        i += 1

    ret = 0
    for i in range(1, len(arr)):
        check1 = arr[i] == "*" and (arr[i-1] == "S" or arr[i-1] == "L")
        check2 = arr[i-1] == "*" and (arr[i] == "S" or arr[i] == "L")
        if check1 or check2:
            ret += 1
            arr[i-1] = "checked"
            arr[i] = "checked"
    return ret

N = int(input())
seats = list(input())
answer = solve(N, seats)
print(answer)
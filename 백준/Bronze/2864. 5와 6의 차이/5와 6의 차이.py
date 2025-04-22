def solve(A, B):
    A1, A2, B1, B2 = "", "", "", ""
    for a in A:
        if a == "5":
            a = "6"
        A1 += a
    for b in B:
        if b == "5":
            b = "6"
        B1 += b
    for a in A:
        if a == "6":
            a = "5"
        A2 += a
    for b in B:
        if b == "6":
            b = "5"
        B2 += b

    return int(A2) + int(B2), int(A1) + int(B1)

A, B = input().split()
answer = solve(A, B)
print(answer[0], answer[1])
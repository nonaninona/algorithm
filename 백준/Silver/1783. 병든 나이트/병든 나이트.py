N, M = map(int, input().split())
if N == 1:
    print(1)
elif N == 2:
    if M <= 6:
        print(M//2 + M%2)
    else:
        print(4)
else:
    if M <= 3:
        print(M)
    elif M <= 6:
        print(4)
    else:
        print(M-2)
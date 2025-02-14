N, L = map(int, input().split())
H = list(map(int, input().split()))
H.sort()

for h in H:
    if L >= h:
        L+=1
    else:
        break
print(L)
S = input()

count = 0
lastC = S[0]
for c in S:
    if lastC != c:
        count +=1
        lastC = c

print((count+1)//2)
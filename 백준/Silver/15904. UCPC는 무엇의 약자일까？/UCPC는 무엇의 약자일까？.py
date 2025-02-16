S = input()
target = ["U", "C", "P", "C"]

cur = 0
for s in S:
    if s == target[cur]:
        cur += 1
    if cur == 4:
        break
if cur == 4:
    print("I love UCPC")
else:
    print("I hate UCPC")
X = int(input())
ans = [-1, 0, 1, 1, 2, 1]
for i in range(X-5):
    ans.append(0)
R = [2, 3, 5]
i = 6
while i <= X:
    minimum = ans[i-1] + 1
    for r in R:
        if i%r == 0:
            minimum = min(minimum, ans[i//r] + 1)
    ans[i] = minimum
    i += 1
print(ans[X])

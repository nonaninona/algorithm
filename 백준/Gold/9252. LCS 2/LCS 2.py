str1 = " " + input()
str2 = " " + input()
dp = [[0] * len(str1) for i in range(len(str2))]

for i in range(1, len(str2)):
    for j in range(1, len(str1)):
        if str1[j] == str2[i]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

ans2 = ""
i, j = len(str2)-1, len(str1)-1
while i!=0 and j!=0:
    if str1[j] == str2[i]:
        ans2 = str1[j] + ans2
        i -= 1
        j -= 1
        continue
    if dp[i][j-1] >= dp[i-1][j]:
        j -= 1
    elif dp[i][j-1] < dp[i-1][j]:
        i -= 1

ans = dp[len(str2)-1][len(str1)-1]
print(ans)
if ans != 0:
    print(ans2)
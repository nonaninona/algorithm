N, K = map(int, input().split())
S = list(input())
check = [False] * len(S)

count = 0
for i in range(len(S)):
    if S[i] == "P":
        for j in range(max(i-K, 0), min(i+K+1, len(S))):
            if S[j] == "H" and not check[j]:
                count += 1
                check[j] = True
                break

print(count)
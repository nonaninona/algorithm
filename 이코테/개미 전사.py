N = int(input())
K = list(map(int, input().split()))
ans = [0] * N
ans[0] = K[0]
ans[1] = K[1]
ans[2] = K[0] + K[2]
for i in range(3, N):
    ans[i] = max(K[i] + ans[i-2], K[i] + ans[i-3])
print(ans)
print(max(ans[N-1], ans[N-2]))

# 책의 답
# d = [0]*100
# d[0] = K[0]
# d[1] = max(K[0], K[1])
# for i in range(2, N):
#     d[i] = max(d[i-1], d[i-2]+K[i])
# print(d[N-1])

def solve(N, K):
    threshold = K * (K+1) // 2
    if N < threshold:
        return -1

    if (N - threshold) % K == 0:
        return K-1
    return K

N, K = map(int, input().split())
answer = solve(N, K)
print(answer)
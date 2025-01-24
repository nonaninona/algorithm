# 정당성 증명을 제대로 못 함
# 그냥 이게 답일 것 같다는 감이 있음 ㅋㅋ
N, M = map(int, input().split())
A = [list(map(int, input())) for i in range(N)]
B = [list(map(int, input())) for i in range(N)]

def change(i, j):
    global A, B
    for y in range(3):
        for x in range(3):
            A[i+y][j+x] = 1 - A[i+y][j+x]

count = 0
for i in range(N-2):
    for j in range(M-2):
        if A[i][j] != B[i][j]:
            change(i, j)
            count += 1

def check():
    global A, B
    for i in range(N):
        for j in range(M):
            if A[i][j] != B[i][j]:
                return False
    return True

if check():
    print(count)
else:
    print(-1)
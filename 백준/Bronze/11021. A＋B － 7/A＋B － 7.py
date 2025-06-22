T = int(input())

for num in range(T):
    A, B = map(int, input().split())
    print("Case #" + str(num+1) + ":", A+B)
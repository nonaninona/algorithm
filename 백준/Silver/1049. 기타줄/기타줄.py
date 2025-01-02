import sys
sixPrice, onePrice = 210000000, 210000000

N, M = map(int, input().split())
for _ in range(M):
    a, b = map(int, input().split())
    sixPrice = min(a, sixPrice)
    onePrice = min(b, onePrice)

sixPrice = min(onePrice*6, sixPrice)

ret = N//6 * sixPrice
ret += min(sixPrice, onePrice*(N%6))
print(ret)
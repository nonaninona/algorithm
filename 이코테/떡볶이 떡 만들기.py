N, M = map(int, input().split())
cakes = list(map(int, input().split()))
cakes.sort()

def sumCakes(n):
    total = 0
    for c in cakes:
        cut = c - n
        if cut > 0:
            total += cut
    return total

start, end = 0, 1_000_000_000
mid = (start+end)//2
result = 0
while start <= end:
    if start > end:
        break
    mid = (start+end)//2
    total = sumCakes(mid)
    if total < M:
        end = mid-1 # 더 자르기
    else:
        start = mid+1 # 덜 자르기
        result = mid
print(result)




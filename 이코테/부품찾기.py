N = int(input())
components = list(map(int, input().split()))
M = int(input())
finds = list(map(int, input().split()))
components.sort()

def binarySearch(n, start, end):
    if start > end:
        return False
    mid = (start+end)//2
    if components[mid] == n:
        return True
    elif components[mid] < n:
        return binarySearch(n, mid+1, end)
    else:
        return binarySearch(n, start, end-1)

for f in finds:
    if binarySearch(f, 0, len(components)-1):
        print("yes", end=" ")
    else:
        print("no", end=" ")


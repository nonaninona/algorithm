import sys
N = int(sys.stdin.readline().rstrip())
cards = list(map(int, sys.stdin.readline().rstrip().split()))
M = int(sys.stdin.readline().rstrip())
finds = list(map(int, sys.stdin.readline().rstrip().split()))
cards.sort()

def binarySearch(n, start, end):
    if start > end:
        return 0
    mid = (start+end)//2
    if cards[mid] == n:
        return 1
    elif cards[mid] > n:
        return binarySearch(n, start, mid-1)
    else:
        return binarySearch(n, mid+1, end)
for f in finds:
    print(binarySearch(f, 0, N-1), end=" ")
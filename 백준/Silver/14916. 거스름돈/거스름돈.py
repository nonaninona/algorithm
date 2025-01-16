count = 0
def solve():
    global count
    n = int(input())
    if n%2 == 1:
        n -= 5
        count += 1
    if n < 0:
        count = -1
        return
    A = n//10
    B = n%10
    count += A*2
    count += B//2
solve()
print(count)
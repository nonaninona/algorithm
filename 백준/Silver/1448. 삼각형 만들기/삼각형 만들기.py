import sys

def solve(N, sticks):
    sticks.sort(reverse = True)
    for i in range(N-2):
        if sticks[i] < sticks[i+1] + sticks[i+2]:
            return sum(sticks[i:i+3])
    return -1

N = int(input())
sticks = [int(sys.stdin.readline()) for i in range(N)]
answer = solve(N, sticks)
print(answer)
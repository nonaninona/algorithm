N = int(input())
nums = list(map(int, input().split()))
S = int(input())

def swap(i, j):
    global nums
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp

def solve():
    global S

    for i in range(N):
        max_j = i
        for j in range(i+1, min(i+1+S, N)):
            if nums[max_j] < nums[j]:
                max_j = j

        for j in range(max_j, i, -1):
            swap(j, j-1)
            S -= 1

    return nums


answer = solve()
for a in answer:
    print(a, end=" ")
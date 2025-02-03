import heapq

def solution(operations):
    minH = []
    maxH = []
    heapq.heapify(minH)
    heapq.heapify(maxH)

    nums = []

    for o in operations:
        ins, num = o.split()
        num = int(num)

        if ins == "I":
            pushIntoBothHeap(nums, num, minH, maxH)
        elif ins == "D":
            if num == 1:
                popFromHeap(maxH, nums)
            elif num == -1:
                popFromHeap(minH, nums)


    maximum, minimum = getMaximumAndMinimum(nums)

    # print(nums)
    # print(maxH)
    # print(minH)
    # print(maximum, minimum)

    answer = [maximum, minimum]
    return answer

def pushIntoBothHeap(nums, num, minH, maxH):
    nums.append([num, True])
    idx = len(nums)-1
    heapq.heappush(minH, (num, idx))
    heapq.heappush(maxH, (-1 * num, idx))

def popFromHeap(heap, nums):
    while True:
        if len(heap) == 0:
            break
        retNum, retIdx = heapq.heappop(heap)
        if nums[retIdx][1]:
            nums[retIdx][1] = False
            break

def getMaximumAndMinimum(nums):
    newNums = []
    for n, isRemain in nums:
        if isRemain:
            newNums.append(n)

    if len(newNums) == 0:
        return 0, 0
    return max(newNums), min(newNums)
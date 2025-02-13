from itertools import combinations

def solution(dice):
    comb = list(combinations(range(len(dice)), len(dice)//2))
    maxCount = 0
    maxComb = []
    total = 6**(len(dice))

    for c in comb:
        Asums, Bsums = calcABsums(c, dice)
        count = calcCount(Asums, Bsums)
        if count > maxCount:
            maxCount = count
            maxComb = c

    result = list(maxComb)
    ret = []
    for r in result:
        ret.append(r+1)

    answer = ret
    return answer

def calcCount(Asums, Bsums):
    Asums.sort()
    lenASums = len(Asums)
    
    count = 0
    for Bs in Bsums:
        idx = findGreaterIdx(Asums, Bs)
        count += lenASums - idx
        
    return count

def findGreaterIdx(Asums, Bs):
    lo = -1
    hi = len(Asums)
    
    while lo + 1 < hi:
        mid = (lo + hi) // 2
        if not Asums[mid] > Bs:
            lo = mid
        else:
            hi = mid
    return hi

def calcABsums(comb, dice):
    count = 0
    A = []
    B = []
    for i in range(len(dice)):
        if i in comb:
            A.append(dice[i])
        else:
            B.append(dice[i])
    Asums = calcSum(A, 0)
    Bsums = calcSum(B, 0)
    return Asums, Bsums


def calcSum(dices, step):
    if step == len(dices)-1:
        return dices[step]

    sums = calcSum(dices, step+1)
    ret = []
    for s in sums:
        for d in dices[step]:
            ret.append(d+s)
    return ret
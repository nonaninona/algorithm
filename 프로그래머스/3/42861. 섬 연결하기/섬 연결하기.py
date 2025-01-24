from collections import deque

def solution(n, costs):
    groups = list(range(n))      
    # print(groups)
    
    answer = 0
    costs.sort(key=lambda x:x[2])
    q = deque(costs)
    for s, e, c in costs:
        if checkEnd(groups):
            break
        if checkSameGroup(groups, s, e):
            q.popleft()
            continue
        answer += c
        merge(groups, s, e)
        
    # print(answer)
    return answer


def findParent(groups, num):
    ret = -1
    nn = groups[num]
    while True:
        if nn == groups[nn]:
            ret = nn
            break
        nn = groups[nn]
    return nn

def merge(groups, a, b):
    parentA = findParent(groups, a)
    parentB = findParent(groups, b)
    if parentA > parentB:
        groups[parentA] = parentB
    else:
        groups[parentB] = parentA

def checkSameGroup(groups, a, b):
    parentA = findParent(groups, a)
    parentB = findParent(groups, b)
    return parentA == parentB

def checkEnd(groups):
    for g in groups:
        if g != 0:
            return False
    return True
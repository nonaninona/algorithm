import sys
sys.setrecursionlimit(10**6)

def dfs(node, num, links, maximum):
    left, right = links[node]
    
    leftK, rightK, leftVal, rightVal, leftMax, rightMax = 0, 0, 0, 0, 0, 0
    if left != -1:
        leftK, leftVal, leftMax = dfs(left, num, links, maximum)
    if right != -1:
        rightK, rightVal, rightMax = dfs(right, num, links, maximum)
    
    meVal = num[node]
    # print(node, leftK, rightK, leftVal, rightVal, meVal, leftMax, rightMax)

    if leftVal + rightVal + meVal <= maximum:
        return [
            leftK + rightK, 
            leftVal + rightVal + meVal,
            max(leftMax, rightMax, leftVal + rightVal + meVal)
        ]
    
    isLeftCut = False
    isRightCut = False
    if rightVal + meVal <= maximum and leftVal <= maximum:
        isLeftCut = True
    if leftVal + meVal <= maximum and rightVal <= maximum:
        isRightCut = True
    
    if isLeftCut and isRightCut:
        if rightVal+meVal <= leftVal+meVal:
            isLeftCut = True
            isRightCut = False
        else:
            isLeftCut = False
            isRightCut = True
    
    if isLeftCut:
        return [
            leftK + rightK + 1, 
            rightVal + meVal,
            max(leftMax, rightMax, rightVal + meVal)
        ]
    if isRightCut:
        return [
            rightK + leftK + 1, 
            leftVal + meVal,
            max(leftMax, rightMax, leftVal + meVal)
        ]
    
    return [
        leftK + rightK + 2, 
        meVal,
        max(leftMax, rightMax, meVal)
    ]
        

def solution(k, num, links):
    root = getRoot(num, links)
    # print("root : ", root)
    # print("k : ", k)
    
    s = max(num)
    e = sum(num)
    
    mid = -1
    ret = -1
    while s < e:
        mid = (s + e) // 2
        # print("s : ", s)
        # print("e : ", e)
        # print("mid : ", mid)
        ret = dfs(root, num, links, mid)
        # print("ret : ", ret)
        if ret[0] > k-1:
            s = mid + 1
        else:
            e = mid
            
    mid = (s + e) // 2
    ret = dfs(root, num, links, mid)
    
    # print("answer : ", ret[2])
    
    answer = ret[2]
    return answer

def getRoot(num, links):
    parent = [-1] * len(num)
    for i, [l, r] in enumerate(links):
        if l != -1:
            parent[l] = i
        if r != -1:
            parent[r] = i
    root = -1
    for i, p in enumerate(parent):
        if p == -1:
            root = i
            break
    return root
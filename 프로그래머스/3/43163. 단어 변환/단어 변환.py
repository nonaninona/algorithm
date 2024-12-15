from collections import deque

def solution(begin, target, words):
    relMap = makeMap(begin, words, target)
    visited = makeVisited(begin, words, target)
    
    queue = deque()
    queue.append((begin, 0))
    while queue:
        (word, d) = queue.popleft()
        if visited[word] != -1:
            continue
        visited[word] = d
        n = relMap[word]
        for nw in n:
            queue.append((nw, d+1))
    
    answer = 0
    if visited[target] != -1:
        answer = visited[target]
    return answer

def isNeighbor(str1, str2):
    count = 0
    for s1, s2 in zip(str1, str2):
        if s1 != s2:
            count +=1
    return count == 1

def makeVisited(begin, words, target):
    visited = {}
    visited[begin] = -1
    visited[target] = -1
    for w in words:
        visited[w] = -1
    return visited

def makeMap(begin, words, target):
    relMap = {}
    l = []
    for w in words:
        if isNeighbor(begin, w):
            l.append(w)
    relMap[begin] = l
    
    for w1 in words:
        l = []
        for w2 in words:
            if isNeighbor(w1, w2):
                l.append(w2)
        relMap[w1] = l
    
    if not target in words:
        relMap[target] = []
        
    return relMap
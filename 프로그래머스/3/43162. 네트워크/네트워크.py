def solution(n, computers):
    visited = [False] * n
    
    def dfs(node, isFirst):
        if visited[node]:
            return False
        
        visited[node] = True
        for (i, nextNode) in enumerate(computers[node]):
            if nextNode == 0:
                continue
            dfs(i, False)
            
        return isFirst
        
    
    answer = 0  
    for i in range(n):
        if dfs(i, True):
            answer += 1
    return answer

    
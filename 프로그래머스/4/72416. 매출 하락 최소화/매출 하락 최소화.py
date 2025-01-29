def dfs(node, dp, g):
    if not g[node]:
        return
    
    for e in g[node]:
        dfs(e, dp, g)
        
    # 현재 팀장 노드 선택 시
    for e in g[node]:        
        dp[node][1] += min(dp[e][0], dp[e][1])

    # 현재 팀장 노드 미선택 시    
    notContains = True
    for e in g[node]:
        if dp[e][1] <= dp[e][0]:
            notContains = False
            dp[node][0] += dp[e][1]
        else:
            dp[node][0] += dp[e][0]
    if notContains:
        v = []
        for e in g[node]:
            v.append(dp[e][1] - dp[e][0])
        dp[node][0] += min(v)
        
        
    # print("leader node : ", node)
    # print("non selected : ", dp[node][0])
    # print("selected : ", dp[node][1])

def solution(sales, links):
    g = [[] for _ in range(len(sales))]
    for s, e in links:
        g[s-1].append(e-1)
        
    dp = [[0, sale] for sale in sales]
    # print(dp)
    
    dfs(0, dp, g)
    # print(dp)
        
    answer = min(dp[0][0], dp[0][1])
    return answer
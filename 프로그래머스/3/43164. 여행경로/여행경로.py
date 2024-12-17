def solution(tickets):
    graph = makeGraph(tickets)

    answers = []        
    def dfs(a, step):
        if step == len(tickets):
            answer = sortNodes(graph)
            answers.append(answer)
            return
        
        for i in range(len(graph[a])):
            d, s = graph[a][i]
            if s != -1:
                continue
            graph[a][i] = (d, step)
            dfs(d, step+1)
            graph[a][i] = (d, -1)   
    
    dfs("ICN", 0)
    answers.sort()
    return answers[0]

def makeGraph(tickets):
    airport = set()
    for a1, a2 in tickets:
        airport.add(a1)
        airport.add(a2)
    
    graph = {}
    for a in airport:
        graph[a] = []
        
    for s, e in tickets:
        graph[s].append((e, -1))
    return graph
        
def sortNodes(graph):
    nodes = [("ICN", -1)]
    for vs in graph.values():
        for v in vs:                    
            nodes.append(v)
    nodes.sort(key=lambda x:x[1])
    ret = []
    for n, s in nodes:
        ret.append(n)
    return ret
# 생각의 흐름
1. 어 그냥 bfs인데.. 아 갯수를 세야하네
2. N == K인 반례는 스스로 찾음
3. 처음부터 끝까지 visited[0] = True라는 이상한 코드를 넣어놨었음 visited[N] = True 여야 하는데 ㅋㅋㅋㅋ..
4. 그럼에도 틀렸을 것 같은데, 왜냐하면 visited가 이미 방문되어 있는 경우, 개수만 세고 queue에 넣지 않았기 때문
5. 예를 들어 2초에 8에 도달하는 경우가 2개가 있으면, 둘 다 큐에 넣어줘야 함(K=8이면 가지를 더 못 뻗고 바로 끝나지만, 그렇지 않으면 가지를 더 뻗게 됨 => 개수가 더 많아질 수 있는 것)
6. 그래서 visited의 방문 여부를 검사할 때, 이전과 같은 시간(최소시간)에 방문하는 경로라면, 마찬가지로 큐에 넣어줘야 함

# 배운점
- 가지를 쳐야하는지 아닌지를 잘 판별해야 한다
- 언제나 visited 관리를 잘해야한다
- n_pos를 Dx = [-1, 1, ??] 로 둘려고 해서 깔끔하게 못 짰었는데, for n_pos in [pos-1,pos+1,pos*2] 로 깔끔하게 짤 수 있다

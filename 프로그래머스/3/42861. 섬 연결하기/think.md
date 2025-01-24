# 생각의 흐름
1. 아니 뭐 걍 감이 안 옴..
2. n이 100 밖에 안 된다는 점이 눈에 띔
3. 다익스트라 식으로 어떤 그룹에서 나가는 엣지 중 최소 값을 고르는 방식?? 그렇다면 가장 최초 그룹은 뭘로 결정할 건지 이런 생각을 하다가
4. 가장 최초 그룹은 무조건 전체에서 가장 작은 코스트의 엣지를 고르면 된다는 것을 알게 됨<br>
가장 작은 코스트의 엣지가 연결하는 A, B는 결과적으로 무조건 그 엣지로 연결됨<br>
왜냐하면 A를 포함하는 그룹 A, B를 포함하는 그룹 B를 연결하려면 결국 그 엣지를 써야 하기 때문
5. 어 그러면 그 이후에도 계속 제일 작은 엣지를 가져가면 되나?? 싶음.<br>
노드 2개를 합친 걸 그냥 노드 1개로 보면 귀납적으로 맞는 말이 됨.
6. 근데 그러려면 노드 2개가 합쳐진다는 개념이 필요함. 합쳐진 그룹이 되면, 그 그룹에서 어떤 특정 노드로 나가는 엣지가 최솟값인 엣지만 존재하면 됨.
7. 근데 이거 합칠 때마다 엣지의 코스트를 업데이트 하는 개념으로 들어가니까 어려워짐.
8. 구현을 좀 쉽게 하는 방법이 없을까 생각해보다가.. 이 2개의 노드가 같은 그룹에 있냐?만 판단할 수 있으면 그냥 costs[2]를 기준으로 정렬해두고 그 엣지를 초록색으로 둘 지 말 지만 결정하면 된다는 걸 알게 됨. 그 결정에 있어서 2개가 같은 그룹이냐 물어봐야 하는 것.
9. python에서 union find 어떻게 구현해야 제일 빠른지는 모르겠지만 난 그냥 배열로 함(어차피 시간 복잡도 널널하다는 계산)
10. 가장 costs[2]가 작은 애부터 보면서 같은 집합에 대한 엣지면 쳐내고 아니면 초록색으로 카운트

아니 근데 생각해보니 queue를 쓸 필요가 없는데..
**[수정 답안]**
```
def solution(n, costs):
    groups = list(range(n))      
    # print(groups)
    
    answer = 0
    costs.sort(key=lambda x:x[2])
    for s, e, c in costs:
        if checkEnd(groups):
            break
        if checkSameGroup(groups, s, e):
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
```

![image](https://github.com/user-attachments/assets/487e9881-6014-4e6c-8928-cfe008bc7150)
![image](https://github.com/user-attachments/assets/e90daad9-a38e-41ba-8bb1-9e4880246b0f)

# 다른 사람 답 참고

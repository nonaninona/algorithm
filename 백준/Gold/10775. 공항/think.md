# 생각의 흐름
1. 진짜 개화나네 뭔가 풀 수 있었다는 생각이 들어서 화남;;
2. 일단 그리디한 부분은 빠르게 캐치함 그냥 제일 큰, 가능한 수를 쓰는 게 제일 좋음. 증명은 이제 생략 ^^(이래도 되나)
3. 그런데 문제는 가장 큰 수를 찾는 일이었음. 일단 선형탐색은 안됨. 이진탐색도 아이디어가 안떠오름
4. 내가 찾는 숫자에 포인터를 건다 정도까진 생각했는데 Union Find를 떠올리진 못함. 생각을 해보긴 했는데 연결을 못했다고 해야하나?
5. 아무튼 힌트를 보니 Union Find여서 바로 구현해서 풀었음
6. 근데 계속 틀림;; 왜 인지 살펴보니
7. 구현 코드에 경로 압축이라고 부르는 기법을 적용해야 했었음
8. a의 parent를 find를 한 결과 = parent가 있을 텐데, 이 parent에 a를 바로 달아주는 것을 경로 압축이라고 부름
9. 그러니까 원래는 여러 번 타고 올라가야 최종 parent를 만나는데, 최종 parent를 알게 된 그 순간에 a가 parent를 가르키도록 변경하는 것임
10. 이거 말고도 rank by union이라고 균등 트리를 구성할 수 있도록 하는 기법이 있는 듯 한데... 오늘은 여기까지만 하자

![image](https://github.com/user-attachments/assets/b0b139a8-3b89-4397-b6c2-5ea3c441f6e7)
![image](https://github.com/user-attachments/assets/aaf8dfdd-c016-4d83-a858-1e7109fc8936)
![image](https://github.com/user-attachments/assets/3d992a2e-b652-4374-b5f0-c764676fcf2c)


# 다른 사람 답 참고
[여기](https://cat-holic0713.tistory.com/16)를 통해 풀이 참고<br>
<details>
<summary>GPT가 설명해주는 경로 압축</summary>
기존에 작성한 find 코드와 최적화된 find 코드를 비교해 보면, 경로 압축 (path compression)의 유무가 가장 큰 차이점입니다.<br>
기존 코드에서는 경로 압축이 없어서 Union-Find의 트리가 깊어질 때 비효율적이 되는 문제가 있습니다.<br>

- 기존 find 코드
```
def find(g):
    if g == links[g]:
        return g
    else:
        return find(links[g])
```
동작 방식:
입력 g에 대해 재귀적으로 부모를 찾아 올라가며 최종 루트를 반환합니다.
하지만, 부모 노드로 이동하는 과정에서 방문했던 노드들은 그대로 두기 때문에 트리의 깊이가 유지됩니다.
트리가 비대칭적으로 길어지면, 특정 노드에서 루트를 찾는 비용이 커질 수 있습니다.

- 최적화된 find 코드
```
def find(g):
    if g != links[g]:
        links[g] = find(links[g])  # 경로 압축
    return links[g]
```
동작 방식:
입력 g에 대해 재귀적으로 부모를 찾아 올라가면서, 방문한 모든 노드의 부모를 루트로 직접 연결합니다.
한 번 find를 호출한 이후에는 트리의 높이가 크게 줄어들어, 이후 같은 루트를 찾을 때 빠르게 접근할 수 있습니다.
</details>



# 생각의 흐름
1. 일단 보드 크기가 매우 작다. 대신 매번 알파벳 리스트를 확인하는 오버헤드가 있을 것 같음.
2. 별 생각 없이 오늘은 bfs 써야지! 하고 사용함. 알파벳 리스트를 매번 복사해야 함.
3. 금방 짜서 제출하니 런타임에러(KeyError) => 알파벳을 딕셔너리로 저장하는데 26자인 걸 24자로 착각해서 Y, Z가 없었음
4. 이번엔 메모리 초과. 이때부터 뭔가 이상한 걸 깨달음
5. 어라?? 칸은 400개 밖에 안되고, 그 마저도 최대 26칸 이동할 수 있긴 한데, 가장 먼 거리를 찾는 거라 이전에 방문한 적이 있다고 해서 가지칠 수가 없음.
6. 어?? 그럼 완전 탐색이고 4^26?? 아니면 이전 노드 없앤다고 해도 3^26??
7. 아무튼 완탐이면 dfs가 적합하긴 함. 변경했음.
8. !!검색 힌트!! dfs로 진행하면 매번 딕셔너리, 집합, 배열을 복사할 필요가 없었음.. 체크하고 dfs 호출하고 체크 풀어주면 됨.
9. 엥 근데 이젠 시간초과 => pypy로 하니까 되긴 함;;
10. 근데 어째서 이게 시간초과가 안나는 지 모르겠음. 시간 복잡도 계산은 3^26인 것 같은데.. 검색해보니 백트래킹 알고리즘이라고 하는데 얘는 뭔가 다른가 싶음

![Ongoing-200](https://github.com/user-attachments/assets/3b5c9113-2665-480f-b683-3f5f32aa29bc)
![Ongoing-199](https://github.com/user-attachments/assets/7507c918-935d-4a2a-ab5d-5e8e33308cf4)

\+ 파이썬에서 깊은 복사를 하려면 자료구조 선언 함수를 이용하면 된다. 아래처럼
```
old_dictionary = dict()
new_dictionary = dict(old_dictionary)

old_set = set()
new_set = set(old_set)
```

# 다른 사람 답 참고

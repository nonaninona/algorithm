# 생각의 흐름
1. 아니 뭐... 어케 함??
2. 일단 최대 NlogN이고..
3. 그냥 패턴 파악을 위해 막 해보기
4. 아 어쨋든 크기 중요하고 NlogN이니까 첫번째 수 정렬 해놓고 패턴파악
5. 정렬 해놓고 하면 이런 가정 가능할 것 같은데?
오름차순 정렬 -> 첫번째, 두번째 수의 max 값을 관리. 숫자가 1개만 갱신되는 경우, count + 1
6. 아 근데 예외 찾음. 예제 입력 2번째에서 7 3 / 6 1 -> 7 1 / 6 3 로 바꾸면 예외임
7. 아니 근데 보다보니까 어차피 숫자가 1개만 갱신된다는 건 뒤의 값만 바뀌는 거임
왜냐하면 앞의 값은 정렬을 해서 무조건 max가 바뀌게 되어있음
8. 어 설마 최솟값인가?
9. 첫번째 수(A) 기준 오름차순 정렬을 한 뒤 하나씩 보기 -> 두번째 수(B)의 최솟값을 관리 -> 그 최솟값이 갱신될 때마다 count + 1
10. 
(가정)
if min > curB, then count + 1
(증명)
if min <= curB, then A도, B도 이전에 나왔던 수보다 큼 => 같은 그룹에 속함
if min > curB, then A는 지금까지 나왔던 수들 중 가장 큰데, B는 가장 작음 => 어떤 그룹에도 속할 수 없음 따라서 그룹 + 1
11. 앗 시간초과;; fastio
    
# 다른 사람 답 참고

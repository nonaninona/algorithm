# 생각의 흐름
1. 어 그냥 삽입 정렬에서 swap 하는 횟수 구하는 건가?
2. 아 아니네...(구현해보고 꺠달음)
3. 예시들을 만들어서 풀어보니 생각보다 복잡한 형태라는 걸 깨달음
4. 일단 시간 복잡도에 따르면 최대 NlogN임
5. 완전탐색 -> N~1까지 맨 위로 빼면 무조건 풀림 => 300억 정도
6. 부분문제 느낌 아님, 그래프도 아님
7. 스택 너낌인가?
8. 정렬 너낌인가?
9. 유형 잘 모르겠는게 그리디 같음
10. 그러면 정렬하고 규칙에 따라 한번만 순회하면 될 것 같은데 무슨 규칙일까
11. 규칙을 찾아봄(제일 큰 수에 대해서 최초에 어디에 위치한 건지, 아니면 맨 위로 올라가는 숫자 때문에 일종의 방향이 바뀌는 거니까 그것까지 고려해본다던지..)
12. 규칙을 찾긴 함. 각 숫자가 어느 인덱스에 위치했는지 리스트로 정리한 뒤에, 그 리스트를 맨 뒤에서부터 탐색하면서 어느 인덱스에 위치했는지를 나타내는 값이 증가하는 지점의 인덱스가 답임.
13. 왠지는 모르겠고 일단 구현을 해서 제출했더니 맞음
14. 왜 답일까 생각해봄<br>
일단 내 솔루션을 정리해서 표현하자면<br>
index 1 2 3 ... N<br>
order o1 o2 o3 ... oN<br>
이렇게 각 숫자와, 그 숫자의 현재 위치를 표현했다고 했을 때,<br>
oN에서 o1까지 탐색하면서 그 값이 증가하는 지점의 인덱스 값이 답이다<br>
그 지점은 om > om+1 < ... < oN-1 < oN 이런 식으로 표현하면, m이라고 말할 수 있음<br>
<br>
현재 상황과 목적을 설명하자면<br>
결국 우리는 o1 = 1, o2 = 2, ... oN= N 이 되도록 만들어야 하는데,<br>
우리가 쓸 수 있는 연산은, 특정 ok를 1로 만들고, 기존의 ok보다 작던 ot들에게 +1을 해주는 거임<br>
그러니까 oN은 최초에 값이 작았더라도 결국 계속 1이 더해져서 N이 될 것임.<br>
그러니까 중요한 것은 현재 ot의 값이 아니라, o들 간의 정렬이 어떻게 되어있냐임<br>
<br>
내 솔루션이 답을 구하는 정당성을 설명하자면<br>
증가하게 되는 om에 대해 연산을 적용하게 되면, 그 om은 1이 되고 그 om보다 작던 애들의 값은 1이 증가함.<br>
즉 어떻게 보면 om > om+1을 om < om+1로 바꿔주는 것임. 근데 이제 om이랑 om+1 사이에 여러 값들이 끼어있을 수 있는 거고<br>
결국 om과 om+1은 붙어있어야 하니까, om과 om+1 사이의 값들에 대해서도 연산을 모두 진행해줘야 하긴 함. 그 순서는, 당연히 가장 큰 수에서부터 작은 수가 될 것<br>
그러니까 내 솔루션이 답을 구하는 건 명백함<br>
<br>
그럼 이 솔루션이 왜 최소인가를 생각해봐야 함<br>
만약 저 om이 아니고 다른 애 한테 연산을 적용한다고 했을 때, 즉 최초가 아니고 증가하거나 아니면 아예 감소하는 경우 연산을 적용한다고 했을 때 뭐가 문제인지 살펴보자<br>
1. om < om+1 < .. < oN 상태에서 om에게 연산을 적용했다고 해보자(감소하는 경우 연산 적용)<br>
그러면 om과 om+1은 만나야 하니까 그 사이에 있는 모든 ot들에게 연산을 적용해야 한다.<br>
그러나 내 솔루션에 따르면, om에서 연산을 진행하지 않아도 된다. 그러면 연산 적용 횟수가 최소 1개는 더 적을 것이다.<br>
2. om > om+1 < .. < oj > oj+1 < .. < oN 상태에서 om에게 연산을 적용했다고 해보자(최초가 아닌, 증가하는 경우 적용)<br>
설명할 게 있을까 싶다. 이 경우에는 오답이 도출된다.

# 다른 사람 답 참고
제일 큰 수에 대해서 왼쪽으로의 내림차순 길이를 N에서 뺀 값이 답이라고도 할 수 있다.
https://www.acmicpc.net/source/86028123

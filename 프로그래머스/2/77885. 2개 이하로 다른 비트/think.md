# 생각의 흐름
프로그래머스 스킬체크 풀면서 나온 문제.<br>
프로그래머스 스킬체크가 한 번 통과해버리면 재시험을 못보는 것 같은데(만점만 그런 듯?)<br>
그렇지 못한 경우 랜덤으로 문제가 계속 바뀌는 걸 확인(레벨 5 계속 들어가자마자 종료하면서 확인함)<br>
다 풀고나서 레벨 1, 2를 풀었는데 깃헙에 푼 문제가 반영이 안되서 아쉬웠음<br>
근데 혹시 프로그래머스의 문제은행에서 가져오는 건가 싶어서 찾아봤는데 있네?? ㅋㅋ 바로 복붙 제출<br>
<br>
1. 음.... 일단 숫자 N개에 대해서 f(x)를 구해야 하는데 N^2은 안됨. 그러니까 NlogN만 가능. 하나하나에 대해서 상수배 x logN 정도로 생각하면 될 듯.
2. 근데... 규칙을 못 찾겠음 ㅋㅋ 뭔가 logN이기도 하고 문제도 비트 관련이니까 대충 2 제곱 수 값끼리 재귀 연관이라던가 있을 줄 알았는데 아닌 듯 함..
3. f(1)부터 f(16)까지 구해보고, 그냥 마음대로 예제 만들어서 보면서 한가지 규칙을 찾음. 결국 111이 연속되어 있을 때 한번에 바뀌는 경우가 문제인 것 같음.
4. 결국 한 10분 머리 싸매다가 규칙을 얼추 찾음. 결국 111이 연속되어있고 한 번에 바뀌려면 맨 뒷자리에 1이 모여있는, 연속된 경우만 가능함.<br>
왜냐하면 중간에 111이 뭉쳐있다가 한번에 바뀔 순 없음. 그 밑에 자리에 1이 쌓이기 시작하는 거지.<br>
그렇게 맨뒤 + 연속이라는 관점으로 보니까 규칙이 보임.
5. 맨 뒤에서부터 1이 연속으로 2자리 이상 존재하면, 그 다음 수는 1이 연속되어서 뒷 부분에 좀 채워져야 함. 구체적으로는 (원래 수에서 1이 연속된 횟수 - 1)만큼 뒤에 채워져야 2개가 다름<br>
식으로 표현하자면, 원래 수 + 2^(1이 연속된 횟수 - 1)이 답이 됨.<br>
1이 연속으로 2자리 이상 존재하지 않으면, 그냥 바로 다음 수가 답임.

![image](https://github.com/user-attachments/assets/cec78ebd-ef12-4dd4-b7b9-afe66663ac9c)
![image](https://github.com/user-attachments/assets/30b683cf-8d13-46ef-a35f-53a9baa08330)

# 다른 사람 답 참고

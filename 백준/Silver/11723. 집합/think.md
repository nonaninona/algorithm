# 생각의 흐름
1. 어 그냥... set 써도 되겠지?
2. 이거 input 개수가 다를 수도 있는 데 어떻게 받더라??
```
userInput = input().split()
if userInput[0] == "add":
  s.add(userInput[1])
```
이런 식으로 쓰면 됨
3. set에 특정 값이 있는 지 검사할 수 있나?
없음
4. set에서 remove할 때 discard 쓰면 없어도 에러가 터지지 않음
5. set의 clear라는 메소드가 있음
6. 시간 초과 -> fastio

# 다른 사람 답 참고
1. 오 그냥 20개 밖에 안되니까 계수정렬마냥 리스트 20개 할당해놓고 하면 되는구나
이렇게~
```
import sys
s = [False for i in range(21)]
M = int(sys.stdin.readline().rstrip())

for _ in range(M):
    userInput = sys.stdin.readline().rstrip().split()
    if userInput[0] == "add":
        s[int(userInput[1])] = True
    elif userInput[0] == "remove":
        s[int(userInput[1])] = False
    elif userInput[0] == "check":
        isExist = s[int(userInput[1])]
        if isExist:
            print(1)
        else:
            print(0)
    elif userInput[0] == "toggle":
        s[int(userInput[1])] = not s[int(userInput[1])]
    elif userInput[0] == "all":
        for i in range(len(s)):
            s[i] = True
    elif userInput[0] == "empty":
        for i in range(len(s)):
            s[i] = False
```

# 생각의 흐름
1. 그냥 동전 문제랑 같아보임
2. 최적 부분 구조는 만족함(=쪼개서 풀 수 있음)
3. 그런데 배수는 아니네?? 흠...
4. 탐욕 선택 속성을 증명하는 게 어려운 것이군..
5. 증명을 못하겠다..

![Ongoing-380 2](https://github.com/user-attachments/assets/21977b7f-a207-4085-8037-bb53bb93e9b3)


# 부족한 점 보충
## 최적 부분 구조에 대한 이해
그냥 쪼갤 수 있다고만 생각했고, 선택의 연속이라는 생각만 했었는데, gemini가 좀 더 구체적으로 어떻게 성립하는 지 설명해줌

```
거스름돈 C에 대한 최소 동전 개수 문제는 다음과 같은 부분 문제로 나눌 수 있습니다.

가장 큰 가치의 동전(예: 쿼터)을 한 개 선택한 후, 남은 거스름돈 (C−25)에 대한 최소 동전 개수를 찾는 문제.
다음으로 큰 가치의 동전(예: 다임)을 한 개 선택한 후, 남은 거스름돈 (C−10)에 대한 최소 동전 개수를 찾는 문제.
...
```

## 탐욕 선택 속성 증명
배수인 게 중요한 게 아닌가?

좀 찾아보니까.. canonical coin system이라서 탐욕 선택 속성을 가진다고 하는데..
더 알아보는 것은 패스!

핵심은 동전문제에서
1원짜리가 있고
간격이 좀 넓게 퍼져있으면 웬만하면 된다는 것 같음..

문제는 쉬운데.. 증명은 너무 어렵네..

# 배운 점
- 최적 부분 구조를 재귀적으로 생각해볼 수 있다 => 이전 선택 이후 남은 거스름돈에 대한 최소 동전 개수를 찾는 문제
- canonical coin system이라는 개념이 있다.

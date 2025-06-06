# 생각의 흐름
1. 음... 일단 부분문제로 쪼개 보자... 아무래도 배열 하나하나를 보면 될 것 같다
2. 어라 그런데 이전, 이후 문제에 영향을 주는데 이게 어떻게 그리디지??
3. 대충 이번 문제에 해당하는 위치를 확인해서 값이 다르면 스위치를 누르면 되지 않을까..??
4. 모르겠다 [(풀이 확인)](https://velog.io/@cjkangme/%EB%B0%B1%EC%A4%80-2138.-%EC%A0%84%EA%B5%AC%EC%99%80-%EC%8A%A4%EC%9C%84%EC%B9%98-%ED%8C%8C%EC%9D%B4%EC%8D%AC)
5. i번째 스위치를 눌러서 결정되는 값은, i번째 값이 아니라 i-1번째 값임.
6. 이렇게 생각하면 이제 i번째 스위치를 누르는 방법은 이미 정해져있다고 생각할 수 있음(경우의 수가 없음. 탐욕 선택 속성을 만족. 그냥 동일하게 만들면 됨)
7. 다만, 2번째 스위치가 1번째 위치를 결정하기 때문에, 1번째 스위치는 누르냐 마냐를 알 수가 없음 => 경우의 수 발생
8. 따라서 1번째 스위치를 누른 경우와 누르지 않은 경우로 구분한 뒤, 각각에 대해서는 그리디하게 답을 결정하면 됨

![Ongoing-382](https://github.com/user-attachments/assets/6bb700be-77d5-49c9-b40a-5d8b67cf1fc7)
![Ongoing-383](https://github.com/user-attachments/assets/f865738b-4544-4f5c-b82b-22b6a851c5a8)


# 배운점
- 파이썬에서 리스트를 clone하고 싶으면 그냥 빈배열 더하기 연산을 해주면 됨. 왠지 리스트는 불변이고 연산하면 새로운 리스트 객체를 만들 것 같아서 찍었는데 잘 동작함 ㅋㅋ
- 부분문제를 쪼개야 한다는 점을 알아내는 것이 1차적으로는 중요해보임. 그리고 일반적으로는 배열을 하나하나 보는 식으로 쪼개면 되는 듯
- 결국 핵심은 i번째 스위치가 i-1번째 값을 결정한다는 사실이었음. i번째 스위치가 i번째 값을 결정한다고 생각하면 이전 문제에 영향을 주는 것이지만, 이렇게 생각하면 이전 문제에 영향을 주지 않는, 탐욕 선택 속성이 확보됨
- 그리디 문제여도 경우의 수를 구분해야하는 식의 조합이 가능하다는 것을 알게 됨

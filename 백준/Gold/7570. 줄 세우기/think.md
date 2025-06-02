# 생각의 흐름
1. 일단 연속하는 부분 수열이라는 건 찾음
2. 그런데.. 그걸 어떻게 구하는 지 모름
3. LIS 개념 학습
4. 근데 이걸로 푸는 거 아님
5. 증가하는 부분 수열이면서 간격이 1이어야 함
6. 하... dp 진짜 개못하는 것 같음. 아무튼 현재 숫자로 만들 수 있는 부분 수열의 최대 길이 = 이전 숫자로 만들 수 있는 부분 수열의 최대 길이 + 1
7. 그래서 그냥 dp[nums[i]] = dp[nums[i]-1] + 1 임..

![Ongoing-439](https://github.com/user-attachments/assets/ba068fc8-9083-4f61-bcb9-d36a8047ed7e)
![Ongoing-440](https://github.com/user-attachments/assets/8dbfb491-b958-4991-97f6-8c418cec6288)
![Ongoing-441](https://github.com/user-attachments/assets/e000b19b-90c7-4b38-8371-87a233b48153)
![Ongoing-442](https://github.com/user-attachments/assets/269e6817-22dc-4d4e-8ca6-054cc8b12ca5)

# 배운점
- dp 공부 좀 해야겠다...
- 이분탐색 구현 시 check(lo)=check(mid)가 되도록 조건식을 짜야 함.

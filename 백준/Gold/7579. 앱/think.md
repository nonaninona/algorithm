# 생각의 흐름
어렵다 어려워... 백팩 문제 느낌인 것까진 파악했는데, 부분문제의 범위가 너무 넓다는 걸 극복하지 못했음
1. 완탐 => 2^100 = 1000^10 => 삽불가능
2. 그리디하게되면 비용대비 메모리??인데 쪼갤 수 없잖아 => 어 잠만 이거 백팩 문제st네
3. 에... 그러면 dp인데... 근데 뭐가 "반복되는" "부분문제"지..(dp의 2가지 조건)
4. 반복이 되는 지는 잘 모르겠어... 그래서 코드를 짜서 반복해서 나오는 문제가 있는 지 찾아봄 => 있음
<img width="976" alt="Pasted Graphic" src="https://github.com/user-attachments/assets/2653dd99-d0bd-4157-8fbd-1394be56d2e4" />
5. 흠터레스팅.. 그렇다면 부분문제는 무엇인가?? => 아무래도 f(현재 메모리의 합, 남은 앱 목록) 정도로 정의할 수 있을 것 같음
6. 그런데... 현재 메모리의 합은 10,000,000임;;; dp 배열 만들다가 끝날 듯
7. 음 그러면... f(현재 index, 방문 상태) 정도로?? 이러면 방문 상태가 2^100임 ㅋㅋㅋㅋ
8. 아 놔 어떻게 하는 건데... 답 찾아봄
9. 와... 비용을 문제의 답이 아니라 인자로 넣으면 되는 구나.. ㄷㄷㄷㄷ f(현재 index, 비용의 합)으로 하면 됨
10. 부분 문제 간의 관계 즉, 그 뭐냐 그 점화식은 => f(현재 index, 비용의 합) = max(f(이전 index, 비용의 합), f(이전 index, 비용의 합 - 현재 index 비용) + 현재 index 메모리 값)가 됨
11. 아 파이썬에서 2차원 배열 선언할 때, 열부터 만들어야 되는 건데 왜 이걸 까먹었지 ㅎㅎ;;
12. 맞춤

![Ongoing-362](https://github.com/user-attachments/assets/7da15309-06ee-4a79-a404-9ca891e22614)
![Ongoing-363](https://github.com/user-attachments/assets/aeaba549-6e5e-48bc-933c-16c5cb5fcd41)
![Ongoing-364](https://github.com/user-attachments/assets/06209e83-aed6-4d77-b66b-ee653d93b6b9)
![Ongoing-365](https://github.com/user-attachments/assets/bcdb7329-0e23-4030-849d-eae663e9a1c2)
![Ongoing-366](https://github.com/user-attachments/assets/bc729076-d0f9-4d60-93e6-73459a811841)
![Ongoing-367](https://github.com/user-attachments/assets/89c99e2a-82a7-425d-a0f3-e32437316b9b)
![Ongoing-368](https://github.com/user-attachments/assets/6553447d-23ff-4f5e-b6f8-d7829ebb5f8b)


# 다른 사람 답 참고
[비용을 부분문제의 인자로 가져가세요](https://kau-algorithm.tistory.com/558#:~:text=%EC%83%88%EB%A1%9C%EC%9A%B4%20%EC%95%B1%EC%9D%84%20%ED%99%9C%EC%84%B1%ED%99%94%ED%95%98%EA%B8%B0%20%EC%9C%84%ED%95%B4%EC%84%9C%20%EA%B8%B0%EC%A1%B4%EC%97%90,%EC%95%88%EC%97%90%20%EB%AC%B8%EC%A0%9C%EB%A5%BC%20%ED%95%B4%EA%B2%B0%ED%95%A0%20%EC%88%98%20%EC%9E%88%EC%8A%B5%EB%8B%88%EB%8B%A4.)

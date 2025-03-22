# 생각의 흐름
nlogn이면 생각해볼 목록에 parametric search도 추가하도록 하자
1. 어라...? nlogn이네? heapq 조져버려~
2. 어라...? 시간 왜 초과야...
3. 아니 그러면 n으로 풀어야 하나?? 그리디? 선형으로 순회하면서 뭘 해야하는 거지?
4. 결국 답 봄 => parametric search임...
5. 아놔 이진 탐색 구현 또 까먹음 ㅋㅋㅋ 또 공부함... 이번엔 확실히 외우고 가자
- \[lo, hi\]이고 check(lo) != check(hi)를 만족하는 구간 잡기
- lo = mid, hi = mid로 하면, 마지막에 lo + 1 == hi를 만족하는 결과 생성
- 이때 lo와 hi가 서로 경계에 걸쳐있는 상태임
- lower bound => v\[i-1\] < k <= v\[i\]인 i 찾기
- upper bound => v\[i-1\] <= k < v\[i\]인 i 찾기
6. 아무튼 이분 탐색을 통해서 찾아야 하는 값은 => 시작된 작업의 수가 n인 "시간"
7. 따라서 결과적으로는 \[작업 수가 n이 안되는 최후의 시간, 작업 수가 n을 최초로 넘는 시간\]이 경계가 되도록 해주면 됨.
8. 근데 왜... 그 시간을 가지고 최후의 core 번호를 찾는 걸 계속 틀리지..?? 심지어 일부만 틀린 게 아니고 다 틀림;
9. 아... cores는 코어가 일을 처리하는 데 걸리는 시간인데... 코어 번호로 자꾸 활용하고 있었네. 답을 cores의 원소 값으로 하면 어떡하냐;;
10. 그리고 코어 번호는 1부터 시작한다는 것도 유의해야 함.

![Ongoing-369](https://github.com/user-attachments/assets/19e23e4a-1ab0-4d83-8bb4-cf27f8bfa1f9)
![Ongoing-370](https://github.com/user-attachments/assets/e4ba8c2d-1637-4f7a-a0ad-978bb53227b7)
![Ongoing-371](https://github.com/user-attachments/assets/c3a32e77-7202-4164-9cac-e3ffe2d82ebf)
![Ongoing-372](https://github.com/user-attachments/assets/1f15fabb-d84e-4c95-9ea1-74e04fede49a)
![Ongoing-373](https://github.com/user-attachments/assets/a7c3922e-6489-4561-ae46-75c6efdf3c13)


# 다른 사람 답 참고
[짜잔 parametric search였답니다~](https://velog.io/@longroadhome/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-LV.4-%EC%84%A0%EC%9E%85-%EC%84%A0%EC%B6%9C-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81-JS)<br>
[이분탐색 또 까먹었니?](https://www.acmicpc.net/blog/view/109)

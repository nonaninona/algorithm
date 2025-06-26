# 생각의 흐름
1. 음... 완탐인 경우 (N-1)C(M-1)이겠군..
2. 이걸 어떻게 이분탐색으로 풀지?
3. 정렬이 뭐지? 파라매트릭 서치인가?
4. 아... 블루레이의 크기에 대해 이분탐색을 하면 되는군
5. 최소값은 강의 중 최댓값이고, 최대값은 N의 최댓값 * 음반의 최댓값
6. check에서 true or false를 리턴해야겠네
7. lo, hi 중에 뭐가 답인지 확실히 알 수가 있나?

![Ongoing-453](https://github.com/user-attachments/assets/c1567f92-3bd5-43d8-b08e-b0c712b210a1)

# 배운점
- List<Integer>를 stream 한다고 해서 바로 integer 연산이 되지 않음. mapToInt를 해줘야 함.
- max()에 orElse 처리도 해줘야 함.

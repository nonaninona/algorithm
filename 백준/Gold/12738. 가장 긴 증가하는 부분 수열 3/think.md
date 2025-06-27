# 생각의 흐름
1. 오 LIS 뭐더라...
2. 아 그러니까 naive -> dp -> dp + 이분탐색이었지
3. dp는 해당 위치(i)의 원소를 마지막으로 하는 LIS의 길이를 저장하면 됨 => i+1의 dp 값은 0~i 중에 i+1의 원소 값보다 작은 애중 dp 값이 제일 큰 애 + 1
4. ```
   dp[i+1] = 0
   for j in range(i+1): 
     if nums[j] < nums[i+1]:
       dp[i+1] = max(dp[i+1], dp[j]+1)
   ```
5. 이분탐색은 저 for문을 없애기 위해 도입. dp 배열이 채워진 nums 원소를 가지고 정렬된 배열을 구성하는 것.
6. 만약 10, 30, 20, 40 이 들어온다면
7. 10 -> 10, 30 -> 10, 20 -> 10, 20, 40 처럼 진행됨
8. 원소들보다 큰 수가 들어오면 맨 뒤에 붙이고, 그게 아니라면 이분탐색으로 적절한 위치(lower_bound)를 찾아서 더 작으면 교체
9. 원소가 들어가는 (인덱스+1)이 곧 dp 배열의 값

![Ongoing-455](https://github.com/user-attachments/assets/ba48304b-8f77-410c-be32-637c3fcb9e89)

# 배운점
- 이분탐색 할 때마다 보는 글을 또 봤음. 결국 check(lo) != check(hi), check(lo) == check(mid)면 lo = mid 만 알면 됨.
- 물론 upper, lower bound에서는 -1~N 구간인 거랑, 식 자체도 이해해야하지만

# 생각의 흐름
1. 음... 그냥 다 구해도 되겠는데(계산 실수로 인해 잘 못 판단함)?
2. 완탐 ㄱㄱ~
3. 아 잘짰다 어 근데 왜 시간초과가??
4. 아 최악의 경우 5C2(=252) x 6의 10승인데 6의 6승으로 봄
5. 어라랍 그러면 다 구하면 안되나?? 근데 다 안구하고 어떻게 찾지? 단순히 기댓값을 가지고 구할 순 없는데..
6. 모르겠다 ㅠ.ㅠ 힌트 봄

![image](https://github.com/user-attachments/assets/59fc3e22-f5c6-4045-aede-985882da75a5)
![image](https://github.com/user-attachments/assets/9da4959b-122a-4ac4-bcd0-2422c8cc8c93)
![image](https://github.com/user-attachments/assets/d9eb3044-f0e1-43c1-9467-4287fdd5dfdd)


# 다른 사람 답 참고
[힌트](https://velog.io/@oxboxx/%EC%A3%BC%EC%82%AC%EC%9C%84-%EA%B3%A0%EB%A5%B4%EA%B8%B0-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B2%A8%EC%9A%B8-%EC%9D%B8%ED%84%B4%EC%8B%AD-Lv.-3-Python)(딱 이분탐색이라는 글자까지만 봄) A의 합, B의 합 끼리 비교하는 과정에서 이진탐색만 써도 경우의 수가 많이 줄어듦<br>
[여기](https://www.acmicpc.net/blog/view/109) 참고해서 이진탐색 구현하기 다시 한 번 정리<br>
```
lo = 0
hi = n-1
while lo + 1 < hi:
  if check(mid):
    lo = mid
  else:
    hi = mid
return lo 또는 hi
```
이때 lo와 hi는 결정 경계에 위치함. 즉 check(lo) != check(hi)임<br>
check의 로직을 잘 구성해야함<br>
그 기준은 check(mid)값이 check(lo)와 check(hi) 중 어디에 해당하는 지를 확인하면 됨<br>
그러니까 예를 들어 \[... , 100, 101, ...\]와 같은 배열이 있으면 mid가 100일 때 T이어야 하는지 F여야 하는지를 확인하고, check(50)(=check(lo))이 T인지 F인지를 확인해서 check식을 짜면 된다는 뜻<br>
lowerbound, upperbound는 각각<br>
v\[i-1\] < k <= v\[i\]인 i,<br>
v\[i-1\] <= k < v\[i\]인 i를 찾는 것임<br>
이것도 위의 내용과 일맥상통함. <br>
예를 들어 \[..., 99, 100, 101., ...\]인 배열이 있을 때, k = 100이라고 해보자<br>
그러면 lowerbound는 100의 인덱스를, upperbound는 101의 인덱스를 찾아야 함<br>
그러니까 lowerbound는 그 경계가 lo=99, hi=100이어야 하는 것이고<br>
upperbound는 그 경계가 l=100, hi=101이어야 하는 것임<br>
그렇기에 check(100)이 lower냐 upper냐에 따라 달라짐<br>
lower인 경우, check(100)==check(101)이어야 하고,<br>
upper인 경우, check(99)==check(100)이어야 함<br>
따라서, lower는 k에 대한 check식이 mid >= k이고 => check(100)==check(101)가 됨, upper는 mid > k이어야 => check(99)==check(100)!=check(101)가 됨.


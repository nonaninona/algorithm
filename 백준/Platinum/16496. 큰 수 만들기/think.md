# 생각의 흐름
1. 음.. 그냥 내림차 정렬하면 안되나?
2. 예제 1이 반례네...
3. 그러면 34, 30, 3을 34330으로 붙일려면 어떻게 정렬을 해야하나?
4. 3 > 30이라는 건데...
5. 음 대충 모든 숫자 길이를 동일하게 맞추고 뒤에를 가장 끝의 수로 채우면 안되나?
6. 33 > 30이 되도록..
7. 아니 90퍼 쯤에서 틀림..
8. 답 봤음. 정렬 시 비교의 기준이 a + b와 b + a를 비교하는 거였음

# 배운점
- from functools import cmp_to_key를 이용해서 comparator를 만들 수 있다. .sort(key=cmp_to_key(func_name)) 와 같이 씀
- 좀 더 잘 생각해보자.. 집중해서

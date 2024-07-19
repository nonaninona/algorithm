n, m, k = map(int, input().split())

# holy shit 이러면 배열 값 다 받을 수 있음..
# N을 입력받을 필요도 없네..
arr = list(map(int, input().split()))
arr.sort()
first = arr[-1]
second = arr[-2]

ret = 0
for i in range(1, m+1):
  if i % (k+1) == 0:
    ret += second
  else:
    ret += first

print(ret)

# 내가 책보다 잘 짠듯 뿌듯

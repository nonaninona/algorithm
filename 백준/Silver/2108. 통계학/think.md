# 생각의 흐름
1. 뭐 그냥 파이썬 기초 함수들 활용하면 되겠는데
2. 파이썬 반올림 어떻게 하지? => round()
올림, 내림은
```
import math
math.floor()
math.ceil()
```
4. 최빈값 구하는 건 살짝 까다롭네
그래도 계수정렬st로 하면 되겠다
5. 앗 "절댓값"이 4000 이하구나 그럼 음수도 신경써줘야겠네
6. 엥 시간 초과?? O(NlogN)으로 짰는디.. 입출력 문젠가 보네

# 다른 사람 답 참고
1. 아니 뭐 별별 모듈이 많구만 Counter니 뭐니
2. 근데 내 생각엔 저 filter나 listComprehension을 쓰는 게 좋아보이는 군

**[원래 코드]**
```
import sys
input = sys.stdin.readline
print = sys.stdout.write

N = int(input().strip())
nums = []
for _ in range(N):
    nums.append(int(input().strip()))
nums.sort()

counts = [0 for _ in range(4000 + 1 + 4000)]
for num in nums:
    counts[num+4000] += 1

maxCount = -1
maxNums = []
for (i, count) in enumerate(counts):
    if maxCount < count:
        maxCount = count
        maxNums = [i-4000]
    elif maxCount == count:
        maxNums.append(i-4000)
maxNums.sort()
maxNum = -1
if len(maxNums) > 1:
    maxNum = maxNums[1]
else:
    maxNum = maxNums[0]

print(str(round(sum(nums)/N)) + "\n")
print(str(nums[N//2]) + "\n")
print(str(maxNum) + "\n")
print(str(max(nums)-min(nums)) + "\n")
```

**[개선코드]**
```
import sys

N = int(sys.stdin.readline().strip())
nums = []
counts = [0 for _ in range(4000 + 1 + 4000)]
for _ in range(N):
    num = int(sys.stdin.readline().strip())
    nums.append(num)
    counts[num+4000] += 1
nums.sort()

sys.stdout.write(str(round(sum(nums)/N)) + "\n")

sys.stdout.write(str(nums[N//2]) + "\n")

maxNums = [ x for x in range(len(counts)) if counts[x] == max(counts)]
maxNums.sort()
if len(maxNums) > 1:
    sys.stdout.write(str(maxNums[1]-4000) + "\n")
else:
    sys.stdout.write(str(maxNums[0]-4000) + "\n")

sys.stdout.write(str(max(nums)-min(nums)) + "\n")
```

근데 개선이라고 하기 뭐한게... 속도가 2배 이상 느려졌다.
저 list comprehension 부분이 문제인듯.

filter로 작성하면
```
maxNums = list(filter(lambda x: counts[x] == max(counts), range(len(counts))))
```
이런 너낌

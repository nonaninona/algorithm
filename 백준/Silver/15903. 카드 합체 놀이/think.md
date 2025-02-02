# 생각의 흐름
아니 뭐 풀이 자체는 너무 쉬워서 할 말이 없는데...<br>
뭔가 힙을 써야 시간복잡도를 맞출 수 있을 것 같아서<br>
왜냐하면 최악의 경우 mnlogn인데 한 1억 5천 정도임<br>
근데 그냥 내장 sort로 제출했는데 맞추긴 함;;

**힙을 쓴 코드**
```
import heapq, sys
N, M = map(int, sys.stdin.readline().rstrip().split())
A = list(map(int, sys.stdin.readline().rstrip().split()))

heapq.heapify(A)

for i in range(M):
    a = heapq.heappop(A)
    b = heapq.heappop(A)
    heapq.heappush(A, a+b)
    heapq.heappush(A, a+b)

print(sum(A))
```


# 다른 사람 답 참고

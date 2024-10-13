# 생각의 흐름
1. 어 뭐 생각할게 딱히 없다

# 다른 사람 답 참고
파이썬의 입출력을 빠르게 만들어주는 방법이 있다
바로 sys.stdin.readline과
sys.stdout.write인데,
아마 저수준 입출력 함수들인 것 같다.

근데 공백이나 개행문자에 대한 flushing을 안해주므로, 다 수동으로 해야함.

**[예시]**
```
import sys
sinput = sys.stdin.readline
sprint = sys.stdout.write
N = int(sinput().rstrip())
sprint(str(num) + "\n")
```

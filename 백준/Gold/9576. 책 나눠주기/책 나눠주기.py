import sys
input = sys.stdin.readline

K = int(input())
for i in range(K):
    N, M = map(int, input().split())
    students = []
    for i in range(M):
        a, b = map(int, input().split())
        students.append((a-1, b-1))
    given = [False] * N

    def solve():
        global students
        global given

        students.sort(key=lambda x:(x[1], x[0]))

        ret = 0
        for a, b in students:
            for i in range(a, b+1):
                if not given[i]:
                    given[i] = True
                    ret += 1
                    break

        return ret

    answer = solve()
    print(answer)
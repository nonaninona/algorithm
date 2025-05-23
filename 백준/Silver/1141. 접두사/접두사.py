# 짧은 애부터?
# 뭐 긴 애부터 해도 다를 건 없어보이긴 함
# 근데 python에 startWith 있나
# N^2도 가능

N = int(input())
words = []
for i in range(N):
    words.append(input())
words.sort(key = lambda x:len(x))

count = N
for i in range(N):
    w = words[i]
    l = len(w)
    for j in range(i+1, N):
        if w == words[j][0:l]:
            count -= 1
            break
print(count)
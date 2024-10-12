N = int(input())

l = []
for _ in range(N):
    (name, grade) = input().split()
    l.append((name, int(grade)))
l.sort(key=lambda x:x[1])

for (name, grade) in l:
    print(name, end=" ")

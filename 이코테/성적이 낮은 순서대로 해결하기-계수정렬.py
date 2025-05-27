N = int(input())
students = [[] for i in range(100_000)]
for i in range(N):
    name, score = input().split()
    students[int(score)-1].append(name)

for score in range(len(students)):
    for name in students[score]:
        print(name, end=" ")

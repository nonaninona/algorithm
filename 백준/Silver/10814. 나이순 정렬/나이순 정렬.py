import sys
N = int(sys.stdin.readline().rstrip())
users = []
for i in range(N):
    inputs = sys.stdin.readline().rstrip().split()
    users.append((int(inputs[0]), inputs[1]))
users.sort(key=lambda x:x[0])
for (age, name) in users:
    print(age, name)
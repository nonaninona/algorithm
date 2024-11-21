import sys

nameSet = set()

count = 0
while True:
    line = sys.stdin.readline()
    if line=="":
        break
    name = line[11:len(line)-1]
    if name not in nameSet:
        count += 1
        nameSet.add(name)
print(count)
import sys
s = set()
M = int(sys.stdin.readline().rstrip())

def isInSet(number):
    ret = False
    for n in s:
        if number == n:
            ret = True
            break
    return ret

for _ in range(M):
    userInput = sys.stdin.readline().rstrip().split()
    if userInput[0] == "add":
        s.add(int(userInput[1]))
    elif userInput[0] == "remove":
        s.discard(int(userInput[1]))
    elif userInput[0] == "check":
        isExist = isInSet(int(userInput[1]))
        if isExist:
            print(1)
        else:
            print(0)
    elif userInput[0] == "toggle":
        isExist = isInSet(int(userInput[1]))
        if not isExist:
            s.add(int(userInput[1]))
        else:
            s.discard(int(userInput[1]))
    elif userInput[0] == "all":
        for i in range(1, 21):
            s.add(i)
    elif userInput[0] == "empty":
        s.clear()
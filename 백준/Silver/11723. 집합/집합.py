import sys
s = [False for i in range(21)]
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
        s[int(userInput[1])] = True
    elif userInput[0] == "remove":
        s[int(userInput[1])] = False
    elif userInput[0] == "check":
        isExist = s[int(userInput[1])]
        if isExist:
            print(1)
        else:
            print(0)
    elif userInput[0] == "toggle":
        s[int(userInput[1])] = not s[int(userInput[1])]
    elif userInput[0] == "all":
        for i in range(len(s)):
            s[i] = True
    elif userInput[0] == "empty":
        for i in range(len(s)):
            s[i] = False
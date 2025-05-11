import sys
input = sys.stdin.readline

string = list(input())

def solve():
    stack = []
    for s in string:
        if len(stack) == 0:
            stack.append(s)
        elif s == "(" or s == "[":
            stack.append(s)
        elif s == ")":
            peek = stack[-1]
            num = 0
            while peek != "(":
                if not isinstance(peek, int):
                    return 0
                num += peek
                stack.pop()

                if len(stack) == 0:
                    return 0

                peek = stack[-1]

            stack.pop()

            if num == 0:
                stack.append(2)
            else:
                stack.append(2*num)
        elif s == "]":
            peek = stack[-1]
            num = 0
            while peek != "[":
                if not isinstance(peek, int):
                    return 0
                num += peek
                stack.pop()

                if len(stack) == 0:
                    return 0

                peek = stack[-1]

            stack.pop()

            if num == 0:
                stack.append(3)
            else:
                stack.append(3*num)

    for num in stack:
        if not isinstance(num, int):
            return 0
    return sum(stack)

answer = solve()
print(answer)
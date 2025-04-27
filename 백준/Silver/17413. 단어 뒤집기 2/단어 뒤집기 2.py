def solve(S):

    ret = ""
    sub_str = ""
    is_reverse = True

    for s in S:
        if s == "<":
            ret += sub_str[::-1]
            sub_str = ""
            ret += s
            is_reverse = False
            continue
        elif s == ">":
            ret += s
            is_reverse = True
            continue
        elif s == " ":
            ret += sub_str[::-1]
            sub_str = ""
            ret += s
            continue

        if not is_reverse:
            ret += s
        if is_reverse:
            sub_str += s

    ret += sub_str[::-1]
    return ret


S = input()
answer = solve(S)
print(answer)
def check_count(target, ball_list):
    ret = 0
    isFirst = True
    for b in ball_list:
        if b != target:
            isFirst = False
        if not isFirst and b == target:
            ret += 1
    return ret

def solve(balls, N):
    ret = 500_001

    ret = min(ret, check_count("R", balls[::]))
    ret = min(ret, check_count("B", balls[::]))
    ret = min(ret, check_count("R", balls[::-1]))
    ret = min(ret, check_count("B", balls[::-1]))

    return ret

N = int(input())
balls = list(input())
answer = solve(balls, N)
print(answer)
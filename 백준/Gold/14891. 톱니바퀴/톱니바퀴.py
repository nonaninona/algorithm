import sys
input = sys.stdin.readline

from collections import deque

gears = [deque(list(input().strip())) for i in range(4)]
K = int(input())
commands = []
for i in range(K):
    n, dir = map(int, input().strip().split())
    commands.append((n-1, dir))

def is_turn_left(target_n):
    turn_left = False

    target = gears[target_n]
    target_l, target_r = target[6], target[2]

    if target_n >= 1:
        left = gears[target_n-1]
        left_l, left_r = left[6], left[2]
        if target_l != left_r:
            turn_left = True

    return turn_left


def is_turn_right(target_n):
    turn_right = False

    target = gears[target_n]
    target_l, target_r = target[6], target[2]

    if target_n <= 2:
        right = gears[target_n + 1]
        right_l, right_r = right[6], right[2]

        if target_r != right_l:
            turn_right = True

    return turn_right

def turn_gear(n, dir):
    if dir == 1:
        temp = gears[n].pop()
        gears[n].appendleft(temp)
    elif dir == -1:
        temp = gears[n].popleft()
        gears[n].append(temp)

def turn_left_gear(n, dir):
    turn_left = is_turn_left(n)
    turn_gear(n, dir)
    if turn_left:
        turn_left_gear(n - 1, dir * -1)

def turn_right_gear(n, dir):
    turn_right = is_turn_right(n)
    turn_gear(n, dir)
    if turn_right:
        turn_right_gear(n + 1, dir * -1)


def solve():
    global gears
    global commands

    for n, dir in commands:
        # 타겟 좌우 회전 여부 판단
        turn_left = is_turn_left(n)
        turn_right = is_turn_right(n)

        # 타겟 회전
        turn_gear(n, dir)
        # 좌우 여부 판단에 따라 좌우 회전
        if turn_left:
            turn_left_gear(n-1, dir * -1)
        if turn_right:
            turn_right_gear(n+1, dir * -1)


    s = 1
    ret = 0
    for i, g in enumerate(gears):
        mag = 0
        if g[0] == "1":
            mag = 1
        ret += s * mag
        s *= 2

    return ret

answer = solve()
print(answer)
N, M = map(int, input().split())
j = int(input())
pos = []
for _ in range(j):
    pos.append(int(input()))

left = 1
right = M

move = 0
for p in pos:
    if p < left:
        dist = left - p
        move += dist
        left -= dist
        right -= dist
    elif right < p:
        dist = p - right
        move += dist
        left += dist
        right += dist
print(move)
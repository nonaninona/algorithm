from collections import deque
n, w, l = map(int, input().split())
t = list(map(int, input().split()))
time = 0
bridge = [0] * w
trucks = deque(t)

while trucks:
    for i in range(w-1):
        bridge[i] = bridge[i+1]
    bridge[w-1] = 0

    if sum(bridge) + trucks[0] <= l:
        bridge[w-1] = trucks.popleft()

    time += 1

time += w
print(time)
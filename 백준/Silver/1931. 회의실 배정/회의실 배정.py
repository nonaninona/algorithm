N = int(input())
times = []
for i in range(N):
  times.append(tuple(map(int, input().split())))

times.sort(key=lambda x : (x[1],x[0]))

lastEndTime = -1
count = 0
for i in range(N):
  if times[i][0] >= lastEndTime:
    lastEndTime = times[i][1]
    count += 1
print(count)
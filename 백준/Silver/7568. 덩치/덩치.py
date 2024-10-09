N = int(input()) 
mass = []
for i in range(N):
  mass.append(tuple(map(int, input().split())))

ranks = []
for i in range(N):
  rank = 1
  for j in range(N):
    if i == j:
      continue
    if mass[i][0] < mass[j][0] and mass[i][1] < mass[j][1]:
      rank += 1
  ranks.append(rank)

for i in range(N):
  print(ranks[i], end=" ")
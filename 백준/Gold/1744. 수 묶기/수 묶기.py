N = int(input())
nums = []
for i in range(N):
    nums.append(int(input()))
nums.sort()

negatives = []
zeros = []
positives = []
for num in nums:
    if num > 0:
        positives.append(num)
    elif num == 0:
        zeros.append(num)
    else:
        negatives.append(num)

total = 0
for i in range(len(positives)//2):
    if positives[-1-i*2] == 1 or positives[-1-(i*2+1)] == 1:
        total += positives[-1-i*2] + positives[-1-(i*2+1)]
    else:
        total += positives[-1-i*2] * positives[-1-(i*2+1)]
if len(positives) % 2 == 1:
    total += positives[0]

for i in range(len(negatives)//2):
    total += negatives[i*2] * negatives[i*2+1]
if len(negatives) % 2 == 1:
    if len(zeros) == 0:
        total += negatives[-1]

print(total)
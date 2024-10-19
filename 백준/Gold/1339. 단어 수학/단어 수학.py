N = int(input())
words = [list(input()) for i in range(N)]
counts = [0 for i in range(26)]
for word in words:
    for i in range(1, len(word)+1, 1):
        counts[ord(word[-1 * i])-65] += 10**(i-1)
counts.sort(reverse=True)
total = 0
num = 9
for count in counts:
    if count == 0:
        break
    total += num * count
    num -= 1
print(total)
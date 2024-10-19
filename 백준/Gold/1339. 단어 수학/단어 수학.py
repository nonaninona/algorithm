N = int(input())
words = [list(input()) for i in range(N)]

counts = {}
ch = 'A'
while ch <= 'Z':
    counts[ch] = 0
    ch=chr(ord(ch)+1)

occurs = [[0 for i in range(8)] for j in range(26)]
for word in words:
    for i in range(1, len(word)+1, 1):
        w = word[-1 * i]
        occurs[ord(w)-65][i-1] += 1

for i in range(26):
    w = chr(i+65)
    for j in range(8):
        if occurs[i][j] != 0:
            counts[w] += 10**j * occurs[i][j]

order = []
for key in counts:
    order.append((key, counts[key]))
order.sort(key=lambda x:x[1], reverse=True)

alphabet = dict()
num = 9
for (c, n) in order:
    alphabet[c] = num
    num -= 1
    if num < 0:
        break

nums = []
for word in words:
    num = ""
    for w in word:
        num += str(alphabet[w])
    nums.append(int(num))

print(sum(nums))
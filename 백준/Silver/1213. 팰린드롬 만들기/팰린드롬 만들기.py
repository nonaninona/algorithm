s = list(input())
words = {}

for c in s:
    if c in words:
        words[c] += 1
    else:
        words[c] = 1

count = 0
middleWord = ""
for w in words:
    if words[w] % 2 == 1:
        count += 1
        middleWord = w

# print(words)
if len(s) % 2 == 0:
    if count != 0:
        print("I'm Sorry Hansoo")
        exit()
else:
    if count != 1:
        print("I'm Sorry Hansoo")
        exit()

keys = list(words.keys())
keys.sort()

ret = ""
middle = ""
if len(s) % 2 == 1:
    middle = middleWord
    words[middleWord] -= 1

length = 0
kidx = 0
while length < len(s) // 2:
    w = keys[kidx]
    if words[w] == 0:
        kidx += 1
        continue
    ret += w
    words[w] -= 2
    length += 1

ret2 = ret[::-1]

print(ret + middle + ret2)
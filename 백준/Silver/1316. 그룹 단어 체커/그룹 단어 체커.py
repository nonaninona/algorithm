n = int(input())

words = []
for i in range(n):
  words.append(input())

count = 0
for word in words:
  charSet = set()
  curChar = ''
  for i in range(len(word)):
    c = word[i]
    if c != curChar and c in charSet:
      break
    else:
      curChar = c
      charSet.add(c)

    if i == len(word)-1:
      count += 1

print(count)
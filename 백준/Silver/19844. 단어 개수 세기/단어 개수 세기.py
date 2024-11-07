text = input()
text = text.replace(' ', '-')
words = text.split('-')
total = 0
frontWords = ['c', 'j', 'n', 'm', 't', 's', 'l', 'd', 'qu', 's']
endChars = ['a', 'e', 'i', 'o', 'u', 'h']
for w in words:
    if '\'' in w:
        wordList = w.split('\'')
        if wordList[0] in frontWords and wordList[1][0] in endChars:
            total += 2
        else:
            total += 1
    else:
        total += 1
print(total)
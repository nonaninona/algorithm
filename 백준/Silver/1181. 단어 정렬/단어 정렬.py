N = int(input())
words = set()
for _ in range(N):
    words.add(input())
wordsList = list(words)
wordsList.sort(key = lambda x : (len(x), x))
for word in wordsList:
    print(word)
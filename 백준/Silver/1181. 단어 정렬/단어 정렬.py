import sys
N = int(sys.stdin.readline().rstrip())
words = set()
for _ in range(N):
    words.add(sys.stdin.readline().rstrip())
wordsList = list(words)
wordsList.sort(key = lambda x : (len(x), x))
for word in wordsList:
    sys.stdout.write(word + "\n")
N = int(input())
village = list(map(int, input().split()))
print(sum(village)-max(village))
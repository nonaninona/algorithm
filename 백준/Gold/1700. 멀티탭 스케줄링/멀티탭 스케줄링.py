N, K = map(int, input().split())
nums = list(map(int, input().split()))

plugs = set()
count = 0
for i, n in enumerate(nums):
    if n in plugs:
        continue

    if len(plugs) >= N:
        # print(i)
        l = list(plugs)
        # print("l : ", l)
        for j in range(i+1, len(nums)):
            if len(l) == 1:
                break
            if nums[j] in l:
                l.remove(nums[j])
            # print("l : ", l)
        # print("num : ", l[0])
        plugs.remove(l[0])
        count += 1
    plugs.add(n)

print(count)
N = int(input())
switches = list(map(int, input().split()))
S = int(input())
students = []
for i in range(S):
    g, n = map(int, input().split())
    students.append((g, n))

def switch(idx):
    switches[idx] = 1 - switches[idx]

def solve():
    for g, n in students:
        if g == 1:
            target = n-1
            while target < N:
                switch(target)
                target += n
        else:
            target = n - 1
            switch(target)
            dist = 1
            while True:
                if target-dist >= 0 and target+dist < N and switches[target-dist] == switches[target+dist]:
                    switch(target - dist)
                    switch(target + dist)
                    dist += 1
                    continue
                break

solve()
for i in range(1, N+1):
    print(switches[i-1], end=" ")
    if i % 20 == 0:
        print()
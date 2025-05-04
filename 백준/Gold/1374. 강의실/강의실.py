import heapq

def solve(N, times):
    queue = [0]
    heapq.heapify(queue)

    times.sort(key=lambda x:x[1])

    ret = 1
    for id, start, end in times:
        top = heapq.heappop(queue)
        if top <= start:
            heapq.heappush(queue, end)
        else:
            heapq.heappush(queue, top)
            heapq.heappush(queue, end)
            ret += 1
    return ret

N = int(input())
times = [tuple(map(int, input().split())) for i in range(N)]
answer = solve(N, times)
print(answer)
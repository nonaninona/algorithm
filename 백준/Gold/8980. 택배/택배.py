def solve(N, C, infos):
    truck = [0] * 2000

    ret = 0
    for i in range(N):
        # 짐 내리기
        ret += truck[i]
        truck[i] = 0

        # 짐 목록
        cur_info = [0] * 2000
        for dest, count in infos[i]:
            cur_info[dest] += count
        for j in range(i+1, N):
            dest, count = j, truck[j]
            cur_info[dest] += count

        # 짐 싣기
        cur_volume = 0
        is_end = False
        for j in range(i, N):
            if is_end:
                truck[j] = 0
                continue
            if cur_volume + cur_info[j] > C:
                truck[j] = C - cur_volume
                is_end = True
                continue
            truck[j] = cur_info[j]
            cur_volume += truck[j]

    return ret

N, C = map(int, input().split())
M = int(input())
infos = [[] for i in range(2000)]
for i in range(M):
    info = tuple(map(int, input().split()))
    infos[info[0]-1].append((info[1]-1, info[2]))
answer = solve(N, C, infos)
print(answer)
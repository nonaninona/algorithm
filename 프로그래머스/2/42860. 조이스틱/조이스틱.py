def solution(name):
    updown = 0
    for ch in name:
        updown += 13 - abs(ord("N")-ord(ch))
        
    rname = name[::-1]
        
    # 오른쪽으로만 이동
    rightmost = len(name)
    for (idx, ch) in enumerate(name):
        if ch != "A":
            rightmost = idx
    
    # 왼쪽으로만 이동
    leftmost = len(name)
    for (idx, ch) in enumerate(rname):
        if idx == len(name)-1:
            break
        if ch != "A":
            leftmost = idx+1
    
    # 오른쪽으로 가다가 왼쪽으로 꺾기
    rightleft = len(name)
    for (idx, ch) in enumerate(name):
        if ch == "A":
            continue
        for idx2 in range(idx+1, len(name), 1):
            if name[idx2] != "A":
                print("idx : ", idx)
                print("idx2 : ", idx2)
                print("val : ", idx * 2 + len(name) - idx2)
                rightleft = min(rightleft, idx * 2 + len(name) - idx2)
                break
    
    
    leftright = len(name)
    for (idx, ch) in enumerate(rname):
        if ch == "A":
            continue
        for idx2 in range(idx+1, len(rname), 1):
            if rname[idx2] != "A":
                leftright = min(leftright, 1 + idx * 2 + len(name) - idx2)
                break
                
    print("leftmost : ", leftmost)
    print("rightmost : ", rightmost)
    print("rightleft : ", rightleft)
    print("leftright : ", leftright)
    
    RL = min(leftmost, rightmost, rightleft, leftright)
    if RL == len(name):
        RL = 0
    answer = RL + updown
    return answer
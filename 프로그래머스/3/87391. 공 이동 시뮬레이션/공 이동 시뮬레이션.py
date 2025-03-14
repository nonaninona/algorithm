def solution(n, m, x, y, queries):
    
    pos = [x, y, x+1, y+1]
    # print(pos)
    
    result = 0
    for command, dx in reversed(queries):
        # print(command, dx)
        u = pos[0]
        l = pos[1]
        d = pos[2]
        r = pos[3]
        
        if command == 0:
            if l == 0:
                pos = movePos(pos, 0, 0, 0, dx, n, m)
            else:
                pos = movePos(pos, 0, dx, 0, dx, n, m)
        elif command == 1:
            if r == m:
                pos = movePos(pos, 0, -dx, 0, 0, n, m)
            else:
                pos = movePos(pos, 0, -dx, 0, -dx, n, m)
        elif command == 2:
            if u == 0:
                pos = movePos(pos, 0, 0, dx, 0, n, m)
            else:
                pos = movePos(pos, dx, 0, dx, 0, n, m)
        elif command == 3:
            if d == n:
                pos = movePos(pos, -dx, 0, 0, 0, n, m)
            else:
                pos = movePos(pos, -dx, 0, -dx, 0, n, m)
        
        # print(pos)
        
        if isZero(pos):
            break
    
    result = (pos[2] - pos[0]) * (pos[3] - pos[1])
    # print(result)
    
    answer = result
    return answer

def isZero(pos):
    return pos[0] == pos[2] or pos[1] == pos[3]

def movePos(pos, mu, ml, md, mr, n, m):
    u = pos[0]
    l = pos[1]
    d = pos[2]
    r = pos[3]
    
    if mu > 0:
        u = min(n, u+mu)
    elif mu < 0:
        u = max(0, u+mu)
    
    if ml > 0:
        l = min(m, l+ml)
    elif ml < 0:
        l = max(0, l+ml)
    
    if md > 0:
        d = min(n, d+md)
    elif md < 0:
        d = max(0, d+md)
    
    if mr > 0:
        r = min(m, r+mr)
    elif mr < 0:
        r = max(0, r+mr)
        
    return [u, l, d, r]
        
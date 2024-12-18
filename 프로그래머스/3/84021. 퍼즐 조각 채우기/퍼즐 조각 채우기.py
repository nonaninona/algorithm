def solution(game_board, table):
    groupCount = check_game_board(game_board)
    for g in game_board:
        print(g)
    print()
    
    blanks = get_blanks(game_board, groupCount)
    for b in blanks:
        for r in b:
            print(r)
        print()
    
    tableGroupCount = check_table(table)
    for g in table:
        print(g)
    print()
    
    pieces = get_piece(table, tableGroupCount)
    for b in pieces:
        for r in b:
            print(r)
        print()
    
    for r in pieces[0]:
        print(r)
    print()
    
    p = rotate_block(pieces[0])
    for r in p:
        print(r)
    print()
    
    print(is_same_block(pieces[0], pieces[0]))
    print(is_same_block(pieces[0], p))
    
    isUsedBlock = [False for i in range(len(blanks))]
    isUsedPiece = [False for i in range(len(pieces))]
    
    answer = 0
    for i in range(len(blanks)):
        for j in range(len(pieces)):
            print()
            if isUsedBlock[i] or isUsedPiece[j]:
                continue
            b = blanks[i]
            p = pieces[j]
            
            for k in range(4):
                if is_same_block(b, p):
                    answer += get_area(b)
                    isUsedBlock[i] = True
                    isUsedPiece[j] = True
                    break
                else:
                    p = rotate_block(p)                
    
    return answer

def get_area(block):
    ret = 0
    for i in range(6):
        for j in range(6):
            if block[i][j] == 1:
                ret += 1
    return ret

def rotate_block(block):
    b = [[0] * 6 for _ in range(6)]
    ml, md = 100, -1 
    for i in range(6):
        for j in range(6):
            if block[i][j] == 1:
                md = max(md, i)
                ml = min(ml, j)
    for bi in range(6):
        for bj in range(6):
            i = md - bj
            j = ml + bi
            if i < 0 or j < 0 or i >= 6 or j >= 6 or block[i][j] != 1:
                b[bi][bj] = 0
            else:
                b[bi][bj] = 1
    return b

def is_same_block(block1, block2):
    ret = True
    for i in range(6):
        for j in range(6):
            if block1[i][j] != block2[i][j]:
                return False
    return True

def get_blanks(gameBoard, groupCount):
    lenY, lenX = len(gameBoard), len(gameBoard[0])
    
    blanks = []
    for n in range(2, 2+groupCount):
        blank = [[0] * 6 for _ in range(6)]
        i, j, bi, bj = 0, 0, 0, 0
        ml, mu = 100, 100 
        for i in range(lenY):
            for j in range(lenX):
                # print(i, j, gameBoard[i][j], n, mu, ml)
                if gameBoard[i][j] == n:
                    mu = min(mu, i)
                    ml = min(ml, j)
        for bi in range(6):
            for bj in range(6):
                i = mu + bi
                j = ml + bj
                if i >= lenY or j >= lenX or gameBoard[i][j] != n:
                    blank[bi][bj] = 0
                else:
                    blank[bi][bj] = 1
        blanks.append(blank)
    return blanks
    

def check_game_board(gameBoard):
    lenY, lenX = len(gameBoard), len(gameBoard[0])
    visited = [[False for j in range(lenX)] for i in range(lenY)]
    groupNumber = 2
    Dy = [0, -1, 0, 1]
    Dx = [-1, 0, 1, 0]
                
    def dfs(y, x, isFirst):
        if y < 0 or x < 0 or y >= lenY or x >= lenX:
            return False
        if visited[y][x]:
            return False
        if gameBoard[y][x] == 1:
            return False
        
        visited[y][x] = True
        gameBoard[y][x] = groupNumber
        
        for dy, dx in zip(Dy, Dx):
            dfs(y+dy, x+dx, False)
        
        return isFirst
        
    for i in range(lenY):
        for j in range(lenX):
            if dfs(i, j, True):
                groupNumber += 1
    return groupNumber - 2

def get_piece(table, tableGroupCount):
    lenY, lenX = len(table), len(table[0])
    
    pieces = []
    for n in range(1, 1+tableGroupCount):
        piece = [[0] * 6 for _ in range(6)]
        i, j, bi, bj = 0, 0, 0, 0
        ml, mu = 100, 100 
        for i in range(lenY):
            for j in range(lenX):
                # print(i, j, gameBoard[i][j], n, mu, ml)
                if table[i][j] == n:
                    mu = min(mu, i)
                    ml = min(ml, j)
        for bi in range(6):
            for bj in range(6):
                i = mu + bi
                j = ml + bj
                if i >= lenY or j >= lenX or table[i][j] != n:
                    piece[bi][bj] = 0
                else:
                    piece[bi][bj] = 1
        pieces.append(piece)
    return pieces

def check_table(table):
    lenY, lenX = len(table), len(table[0])
    visited = [[False for j in range(lenX)] for i in range(lenY)]
    groupNumber = 1
    Dy = [0, -1, 0, 1]
    Dx = [-1, 0, 1, 0]
                
    def dfs(y, x, isFirst):
        if y < 0 or x < 0 or y >= lenY or x >= lenX:
            return False
        if visited[y][x]:
            return False
        if table[y][x] == 0:
            return False
        
        visited[y][x] = True
        table[y][x] = groupNumber
        
        for dy, dx in zip(Dy, Dx):
            dfs(y+dy, x+dx, False)
        
        return isFirst
        
    for i in range(lenY):
        for j in range(lenX):
            if dfs(i, j, True):
                groupNumber += 1
    return groupNumber - 1


        

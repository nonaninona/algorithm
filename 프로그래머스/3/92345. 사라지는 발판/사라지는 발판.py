def solution(board, aloc, bloc):
    answer = dfs(0, board, aloc[0], aloc[1], bloc[0], bloc[1])
    return answer

def OOB(board, y, x):
    if y < 0 or x < 0 or y >= len(board) or x >= len(board[0]):
        return True
    if board[y][x] == 0:
        return True
    return False
    

def dfs(depth, board, myY, myX, opY, opX): # 턴 수를 반환
    # print("depth : ", depth)
    if board[myY][myX] == 0:
        return 0
    
    Dy = [0, -1, 0, 1]
    Dx = [-1, 0, 1, 0]
    
    myTurn = 0
    for dy, dx in zip(Dy, Dx):
        if OOB(board, myY + dy, myX + dx): # out of bound 체크
            continue
        
        board[myY][myX] = 0
        move = dfs(depth+1, board, opY, opX, myY + dy, myX + dx)+1
        # print("move : ", move)
        board[myY][myX] = 1
        
        # 홀수 턴이 진행되고 끝난다(move가 짝수) => 내가 이긴 거임(바로 base로 가는 거)
        if myTurn % 2 == 0 and move % 2 == 0: # 현재 판단이 패배, 이번 가지도 패배인 경우
            myTurn = max(myTurn, move)
        elif myTurn % 2 == 0 and move % 2 == 1: # 현재 판단이 패배지만 이번 가지가 승리
            # 어? "난 승리를 할 수 있다" 승리할 가지 선택(턴 수 선택)
            myTurn = move
        elif myTurn % 2 == 1 and move % 2 == 1: # 현재 판단이 승리인데, 이번 가지도 승리
            # 최대한 빨리 이긴다
            myTurn = min(myTurn, move)
        # else: 현재 판단이 승리인데, 이번 가지는 패배 => 할 게 없음
    
    # print("return : ", myTurn)
    return myTurn
        
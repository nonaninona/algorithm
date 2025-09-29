def solution(my_string, s, e):
    answer = ''
    S = my_string[s:e:-1]
    print(S)
    answer = my_string[:s] + S + my_string[e:]
    
    print(answer)
    return answer
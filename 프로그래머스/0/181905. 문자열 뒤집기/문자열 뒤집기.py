def solution(my_string, s, e):
    S = my_string 
    return S[:s]+S[s:e+1][::-1]+S[e+1:]
    
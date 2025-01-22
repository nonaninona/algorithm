def solution(number, k):
    s = []    
    for n in number:            
        while len(s) > 0 and k > 0:
            top = s[-1]
            if top >= n:
                break
            s.pop()
            k -= 1
        
        s.append(n)
    
    # print(s)     
    
    answer = "".join(s)
    return answer[:len(number)-k]
def solution(numbers, target):
    
    def calc(subResult, depth):
        if depth == len(numbers)-1:
            ret = 0
            if subResult + numbers[depth] == target:
                ret += 1
            if subResult - numbers[depth] == target:
                ret += 1
            return ret
        
        return calc(subResult + numbers[depth], depth+1) + calc(subResult - numbers[depth], depth+1)
    
    answer = calc(0, 0)
    return answer

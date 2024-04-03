def solution(array, commands):
    answer = []
    n = len(commands[0])
    
    for i in range(n) :
        i, j, k = commands[i][0], commands[i][1], commands[i][2]
        
        array2 = array[i-1:j]
        array2.sort()
        answer.append(array2[k-1])
        
    return answer

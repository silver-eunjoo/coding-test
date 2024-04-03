def solution(array, commands):
    answer = []
    
    for a,b,c in commands :
        
        array2 = array[a-1:b]
        array2.sort()

        answer.append(array2[c-1])
        
    return answer
#이렇게 바꾸니 통과됐다!

# def solution(array, commands):
#     answer = []
#     n = len(commands[0])
    
#     for i in range(n) :
#         i, j, k = commands[i][0], commands[i][1], commands[i][2]
        
#         array2 = array[i-1:j]
#         array2.sort()
#         answer.append(array2[k-1])
        
#     return answer


# def solution(array, commands):
#     answer = []
#     for a,b,c in commands:
#         tmp_arr = array[a-1:b]
#         tmp_arr.sort()
#         answer.append(tmp_arr[c-1])
#     return answer
# 엥... 이건 다 통과되는데, 어째서 위에 코드는 다 런타임 에러가 뜰까?

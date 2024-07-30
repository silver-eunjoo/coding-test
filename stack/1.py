def solution(s):
    answer = -1
    stack = []

    for i in s :
        if len(stack) == 0 : # 스택 empty method
            stack.append(i) # 스택의 push method
        else :
            if i == stack[-1] :
                stack.pop() # 스택의 pop method
            else :
                stack.append(i)
                
    if len(stack) == 0 :
        answer = 1
    else :
        answer = 0
    return answer

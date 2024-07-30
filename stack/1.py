def solution(s):
    answer = -1
    pre = s[0]
    i = 1
    
    while i != len(s) :
        if pre == s[i] :
            s = s[0:i-1] + s[i+1:len(s)]

            if len(s) == 0 :
                break
            pre = s[0]
            i=0
            
        else :
            pre = s[i]
            
        i+=1

    if len(s) == 0 :
        answer = 1
    else : 
        answer = 0
    return answer

# stack을 생각하면서 풀어야 한다...

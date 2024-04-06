def solution(citations):
    answer = 0
    
    citations.sort()
    
    # if there is 0, slice the array
    if 0 in citations :
        count = citations.count(0)
        if count == len(citations) :
            return 0
        citations = citations[count:]
    
    print(citations)
    
    n = len(citations)
    point = int(n/2) #midpoint index
    h = citations[point] # midpoint number
    
    if citations[0] > n :
        return 0
    
    while True :
        if h<=n-point :
            break
        else :
            point-=1
            h = citations[point]
            
    answer = h
    return answer

# i fixed the code, but only 2 tcs solved hahahahah
# missed tc 1 [1,1,1,2,2] => return 2 (but, my code returns 1)
# missed tc 2 [1,10,11] => return 2 (but, my code returns 1)

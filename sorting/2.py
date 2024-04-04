# 가장 큰 수
def solution(numbers):
    answer = ''
    global temp
    temp = []
    for i in numbers :
        if i < 10 :
            temp.append(str(i))
        else :
            slicing(i)
    
    temp.sort(reverse=True)
    answer = ''.join(temp)
    return answer

def slicing(number) : 
    while(number != 0) :
        temp.append(str(number%10))
        number = int(number/10)

# 이렇게 했는데.. 테케가 실패하길래 다시 보니, 아마 1. 숫자 재배치 먼저 2. 그 후에 슬라이싱 없이 가장 큰 수를 만들어야 하는 것 같다.
# 완전히 잘못 해석했구만.
# i'll be back after having dinner 

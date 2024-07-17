#3항 연산자
def getWeight():
    weight = float(input("몸무게: "))
    #1. [참일 때의 값] if [조건식] else [거짓일 때의 값]
    # return weight if weight>=0 else weight*(-1)
    #2. [조건식] and [참일때의 값] or [거짓일때의 값]
    return weight>=0 and weight or weight*(-1)

#3항 연산자 중첩
#[참1] if [조건1] else [참2] if [조건2] else .... [거짓에 해당하는 값]

#15, 16, 17을 리스트에 담고
#리스트 각각의 요소가 2의 배수인지, 3의 배수인지, 아니면 둘 다 아닌지 판정해서 출력하기

numlist = list([15,16,17])

def isMul(a):
    result = "2의 배수" if a%2==0 else "3의 배수" if a%3==0 else "2,3의 배수가 아님"
    print(f"{a}는 {result}")
    
for i in range(0,3):
    isMul(numlist[i])
    
print("-----------------------")

#조건이 길어지면 그냥 조건문 쓰는게 훨씬 보기 편함

def isMul2(a):
    if(a%2==0):
        result = "2의 배수"
    elif(a%3==0):
        result = "3의 배수"
    else:
        result = "2,3의 배수가 아님"
    
    print(f"{a}는 {result}")

for j in range(0,3):
    isMul2(numlist[i])
#function (함수)
#def 함수명(파라미터명):
    #code

def test():
    print("잠못 잔 나")

###################
test()

def test2(): # :을 쓰면 무조건 다음줄에 들여쓰기가 필수
    print("이렇게")

###################

#정수 2개를 넣으면 그 합을 출력 하는 함수

def sum():
    in_a = int(input("숫자 입력"))
    in_b = int(input("숫자 입력"))
    print(in_a+in_b)
sum()

#함수 파라미터에 기본값을 정의 할 수도 있음
def printSum(a=5, b=8):
    print(a+b)
#######
printSum(4,10) # 14
printSum() # 13

#정수 3개를 넣으면 그 합을 '출력'하는 함수
#파이썬에서도 오버로딩 적용이 가능할까? 아쉽지만 불가능
def tripleSum(a=0,b=0,c=0):
    print(a+b+c)
tripleSum(1,2,3)
tripleSum()

#정수 2개를 넣으면 그 합을 '구하는' 함수

def getSum(a=0,b=0):
    return a+b
print(getSum(7,7))

#정수 2개를 넣으면 사칙연산 결과를 '구하는' 함수
def getCalc(a,b=1):
    calc = {"sum":a+b,"sub":a-b,"mul":a*b,"div":a/b if (b!=0) else 0}
    return getCalc
print(getCalc)

def calc(a,b):
    q = a+b
    w = a-b
    e = a*b
    r = a/b
    return q,w,e,r #tuple 하나를 리턴

u, i, _, p = calc(20,10) #이렇게 처리하면 곱하기 결과 안 가져올 수 있음
print(u,i,p)








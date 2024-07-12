#-*- coding:utf-8 -*-

#정수 2개를 입력받아서, 사칙연산에 대한 결과와
#앞의 수를 뒤의 수로 나눴을 때의 나머지 값을 출력

a = int(input('a : '))
b = int(input('b : '))

add = a+b
sub = a-b
mul = a*b
div = a/b
rem = a%b

print(add, sub, mul, div, rem)

#몫
f = a // b 
print('몫', f)

#거듭제곱 표현
g = a**b 
print(g)

#문자열 결합(concat)
z = "zzzzzzz"
h = str(a)+z
print(h)

#숫자 * 문자열 -> 지정한 숫자만큼 문자열을 반복 출력
i = a * z
print(i)

print('##########')
#단, a++, a--는 사용이 불가능함
a+=3
print(a)


print('###비교 연산자###')
##########
j = a>10
print(j)

## && : and, || or
k = (a>10) and (b<3)
print(k)

# ! : not
l = not k
print(l)

# m : x가 5~10일때 True / 아니면 False
print('m : x가 5~10일때 True / 아니면 False')
#m = (a>=5 and a<=10)
m = (5<=a<=10) #이게 가능함...
print('a의 값 : ', a,'\n''m의 값' , m)

print('###############')

#3항 연산자
#Python에는 있다고하는 사람도 있고 없다는 사람도 있다 - 형태 때문에
# [참 일 때의 값] if [ 조건식 ] else [ 거짓일 때의 값 ]

#정수를 하나 입력받아서 그게 짝수면 => '짝수' , 홀수면 '홀수' 출력
inin = int(input('정수 입력 : '))
result = '짝수' if (inin%2)==0 else '홀수'
print(result)

#위의 버전이 너무 가독성이 안좋아서 python 3.8 버전 이후로...
#[조건식] and [참일 때의 값] or [거짓일 때의 값] - 얘도 삼항 연산자라기엔 좀 그런데...?



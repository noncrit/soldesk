#-*- coding:utf-8 -*-

"""
Java : 값을 표현하기 위해서 최적의 자료형을 개발자가 직접 선정
-> 메모리 사용량 최적화가 가능함
자료형 변수명 = 값;
int a = 10;

Python : Python이 알아서 자료형을 선정
자료형을 굳이 알 필요가 없음
자동으로 자료형을 선정하는 시간동안 자원을 사용함 -> 메모리 사용량 최적화가 힘들어짐
파이썬의 자료형은 전부 참조형 - 메모리 heap에 주소 형태로 담김 -> 메모리 사용량이 큼
변수명 = 값
"""
from pycparser.ply.cpp import t_CPP_FLOAT

a = 10
print(a)
#a의 자료형
print(type(a))

print(id(a)) #의 주소값 - 참조형이라서 주소값이 리턴됨

a = 20
print(id(a))

b =10
print(id(b))
#파이썬은 값을 변경할 때 메모리에 저장된 값을 지우고 다시 저장하는 형태는 아님
#대신 또 다른 메모리 공간에 값을 저장하고 그 곳을 a 변수로 지정하게 됨
#값을 지우지 않기 때문에 10값은 그대로 남아있고, 이것을 b가 10이라고 선언하면 a가 10일때 썻던 메모리를 다시 할당받음
#변수를 그냥 포인터처럼 사용하는 느낌? (추측 : 아니면 코드 스코프 전체에서 10이 할당된 것을 기억하고 있던건가?)

print('###############')


#Python의 자료형(Data type)
p_str = "Kim" #str: #문자열"
print(p_str, type(p_str))

#정수
p_int = 10
print(p_int, type(p_int))

#실수
p_float = 1.234
print(p_float, type(p_float))

#논리(True, False - 맨앞은 대문자로
p_bool= True
print(p_bool)

#List 배열안의 자료형을 통힐할 필요 엇없음
p_list={3,7,5}
print(p_list, type(p_list))


#자료구조 : 맵 - dict
p_dict = {
    'name':'Beaver',
    'age':'100'
    }

print(p_dict, type(p_dict))

#set : 집합
p_set = {6,7,4}
print(set, type(p_set))

#tuple
p_tuple = (5,6,7)
print(p_tuple, type(p_tuple))

#형 변환(Type Casting)
d = 1
print(type(d), id(d));
d = str(d)
print(type(d), id(d));

#주의할점 : Boolean 타입 형 변환
#False : 0 / True : 1
e = False
e = int(e)
print(e)

###############################
#키보드 입력받기(keyboard input)
ki = input('키:')
print(ki, type(ki))

ki = float(ki)
print(ki, type(ki))

ki2 = float(input('몸무게:'))
print(ki2, type(ki2))




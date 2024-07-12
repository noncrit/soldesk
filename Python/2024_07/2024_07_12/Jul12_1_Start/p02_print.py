# -*- coding:utf-8 -*-

"""
Java : 
컴퓨터를 효율적으로 활용하려함 -> 변수의 자료형 직접 선언 필수, 
파이썬에 비해 완벽한 객체지향 언어
코드 내용이 비교적 명확함 대신, 코드가 길어짐


Python :
사람이 쓰기 편하게 만들어진 언어
자료형을 파이썬이 알아서 지정함
완벽한 객체지향 언어는 아님
일단 코드가 짧음 - 자동으로 처리되는 영역이 많음
대신 코드가 길어지면 오히려 헷갈릴 수도
"""

#기본적인 출력 방식
#print 자체에 enter(줄바꿈) 기능 내장 되있는거 확인 가능
print("hello world")
print('hello world')
print()

#end option
#enter가 end의 기본값으로 설정되어있음
print('파이썬이', end=' ')
print('본격적으로', end=' ')
print('시작', end=' ')
print(end='\n')

#구분자(Seperator)
#기본 구분자는 띄어쓰기로 설정되어있음
print('내', '일', '토', '요', '일')
print('내', '일', '토', '요', '일', sep='ㅋ')
#메일주소, 전화번호 출력해보기
print('010', '1234', '5678', sep='-')
print('ksj0996', 'naver.com', sep='@')
print()

#출력 형식(Format)
print('{} and {}'.format('1번', '2번'))
print('{1} and {0}'.format('1번', '2번')) #인덱스 지정 가능/0번부터 시작함
print('{p1} and {p2}'.format(p1='life', p2='Egg'))
print()

# %d, %f, %s 모두 사용 가능
print('%d' % 123)
print('%.2f' % 123.45678)

#10이라는 값을 0번째에, 11.11111이라는 값을 1번째에 소수점 둘째자리까지 출력
print('{0} and {1}'.format('%d'% 10, '%.2f' % 11.11111) )
print('{0: d} and {1: .2f}'.format(10, 11.11111) ) #띄어쓰기 된 부분 주의



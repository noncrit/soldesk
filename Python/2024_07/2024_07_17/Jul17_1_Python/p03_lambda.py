#람다(Lambda) 함수
#장점 : 메모리 절약, 가독성 향상, 코드가 간결함
#일반 함수 : 함수 생성 => 메모리에 할당
#람다 함수 : 즉시 실행 함수 => 사용이 끝난 후 메모리 초기화

#표현법 :
# lambda 파라미터 : 표현식 

#변수를 할당해주는 일반적인 함수
def hab(num):
    x = num + 100
    return x

print(hab(100))

#람다 함수 버전
(lambda num: print(num+100))(100)

#숫자 2개 넣으면 그 곱을 출력하는 함수
(lambda a,b: print(a*b))(11,12)


#숫자 두 개 넣으면 그 합을 구하는 함수
#함수의 결과값만 할당함
hab2 = (lambda x,y: (x+y))(10,20)
print(hab2)

#Java : 강제로 Exception 처리를 하게 해놓았음
#try-catch-finally : 직접 처리
#throw : 떠넘기기

#Python : 하기 싫으면 안해도 됨
# try - except - else - finally

#Error: 컴파일 진행 시(소스를 기계어로 바꿀 때) 컴파일 작업을 실행하지 못하는 상황(CompileTime)
#Warning: 정리가 안된 소스(ex: 쓸모없는 변수, close() 안했거나 등등)
#Exception: 실행하다가 예외적인 상황이 발생해서 코드가 정상적으로 돌아가지 않는 상황(Runtime)

#Python : 인터프리터 방식 - 코드 실행하면 그 때부터 한줄씩 기계어로 바꿔서 실행
#코드 실행하다가 문제가 발생하면 Error인지, Exception인지 판별이 어려움

#---------------------------

#정수 2개를 입력받아서 앞의 숫자를 뒤의 숫자로 나눴을 때 그 몫을 출력

try:
    a = int(input("숫자 a 입력"))
    b = int(input("숫자 b 입력"))

    result = a/b
    print(result)
    
    l = list([1,23,456])
    print(l[b])
    
# except ZeroDivisionError:
    # print("Divide by Zero!!")
    #
# except IndexError:
    # print("list 범위를 넘어갔으요")
    
#귀찮으니 일괄처리 방법 - Exception 사용하기
except Exception as asdf:
    print(asdf)

#else를 사용하는 이유
#에러가 발생할 가능성이 높은 부분과 그렇지 않은 부분을 명확히 구분지어 작성자의 의도를 명확하게 하기 위함 
else:
    print("try쪽에서 문제가 없으면 그 다음 내용을 실행하는 블록")

finally:
    print("문제가 있든 없든 무조건 실행(return 보다 우선해서 실행)")

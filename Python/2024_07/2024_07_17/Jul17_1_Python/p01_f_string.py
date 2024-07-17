from datetime import datetime

#좋아하는 음료 이름, 마시는  횟수를 입력받아서 그 내용을 출력

class drinks:
    
    def __init__(self, name, drink_per_day):
        self.name=name
        self.drink_per_day = drink_per_day
        
    def printInfo(self):
        print("음료 이름 : ", self.name)
        print("하루에 마시는 횟수 : %d" %(self.drink_per_day))


######################

drink = input("음료 : ")
count = int(input("마시는 횟수"))

dd = drinks(drink, count)

dd.printInfo()

print("-----------")

#Python 3.6 이후로 f-string 이라고 부르는 포맷팅을 좀 더 쉽게 할 수 있는 방법이 추가됨

#f-string의 형태 : f 와 {} 만 기억하면 된다.
#f"문자열 {변수명} 문자열 ....."의 형태

print(f"저는 {dd.name}을 좋아하고, 하루에 {dd.drink_per_day}잔을 마십니다.")

#소수점 관련한 반올림 표현
#기본적으로 % 포맷팅과 매우 유사함
#하지만 {}를 사용해서 포맷팅 할 때에는 포맷팅하는 값의 자료형에 상관없이 {}를 사용하면 된다.

f = 1.125
#f = 1.135
print(f"{f}")       # 1.125 / 1.135
print(f"{f:.1f}")   # 1.1   / 1.1 
print(f"{f:.2f}")   # 1.13(틀림?!)  1.12 ??? / 1.14

#Python의 반올림은 반올림하려는 수가 올림, 내림 했을 때
#경계값 5가 기준이 될 때, 바꾸려는 수가 0,1,2 라면 반올림 처리가 정상적으로 이뤄지지 않음(?!)
#파이썬 공식문서 => 이진 부동 소수점의 한계

# 문자 정렬
s1 = "left"
result1 = f"|{s1:<10}|"
print(result1)

s2 ="mid"
result2 = f"|{s2:^10}|"
print(result2)

s3 = "right"
result3 = f"|{s3:>10}|"
print(result3)

#작성 방법
#중괄호 {} 안에 있는 변수 뒤에 콜론 : 붙인 후
#왼쪽 정렬(<), 오른쪽 정렬(>), 가운데 정렬(^) 의 옵션을 넣고
#그 후에 자릿수를 알려주는 숫자를 넣어서 정렬 옵션을 완성

#f-string에서 중괄호를 출력하려면 escaping을 어떻게 처리해야 할까?
num = 10
result4 = f"my age : {num}, {{num}}, {{{num}}}"
print(result4)

#중괄호를 연속해서 2개를 사용하면 중괄호 자체를 문자로 출력, 3번 사용하면 문자({ }) + 포맷터 형태이므로 중괄호 + 변수값 출력이 가능


#f-string과 dict

d = {
        "name":"Kim",
        "gender":"male",
        "age":100
    }

result5 = f"name :{d['name']}, gender: {d['gender']}, age: {d['age']}"
print(result5)

#f-string과 list
n = list([100,200,300])

print(f"list: {n[0]},{n[1]},{n[2]}")

#기존에 리스트에 접근하는 방법과 동일하게 {} 안에 리스트에 대한 접근을 활용하면 됨!
print("----------------")

num2 = 1234567890
print(num2)

#3자리마다 콤마 찍기
print(f"{num2:,}")

date1  = datetime.today()
print(date1)

#연 - 월 - 일 => 요일
print(f"{date1: %Y - %m - %d} is on a {date1:%A}")

#정리
#1. 문자열 맨 앞에 f 를 붙인다
#2. 사용하고 싶은 변수, 값을 중괄호 안에 넣는다
#3. 출력

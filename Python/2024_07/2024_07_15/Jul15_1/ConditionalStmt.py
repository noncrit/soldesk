p_01_conditnionalStmt

#파이썬은 괄호처리, 세미콜론 안 쓰니 꼭 들여쓰기 해주기
if True:
    print("와 ~ 조건문")
if False:
    print("안나오죠?")

#우선 순위 ( 산술 > 관계 > 논리)
print(10 +2 > 8 + 3) # 12.11
print(10 +2 * 2 > 8 + 3 * 2) # 14 > 14
print(((10+2)>3) and (6+4 == 10)) #True
#####################################


#   if 조건 A:
#       코드
#   else:
#        코드

# 놀이기구  A : 성인, 150이상 (값은 입력받아서)
# 입력시에 => 탑승 가능 or 탑승 불가 출력하기

a = input("나이 입력")
b = input("키 입력")
a=int(a)
b=int(b)

if (a>=19 and b>=150):
    print("탑승가능")
else:
    print("탑승 불가")

#python 다중 조건문
#if - elif -elif  ... - else ....
#다중 조건문
# 80점 이상 A, 79점 이상 B, 60점 이상 C, 나머지 D
score = int(input("점수를 입력하세요"))
if score>100 or score<0:
    print("???")
grade =str
if score>=80:
    result = "A"
elif score>=70:
    result="B"
elif score>=60:
    result="C"
else:
    result = "D"
print(grade)

#################
#switch case는 파이썬에 없음
#대신 in, not in으로 사용
abc = {"name" : "비버" , "age" : 19, "phone": "010-1111-2222"}

print("name" in abc) #True 가 출력됨 - in의 return type은 boolean
print(20 in abc.values()) #20이 컬렉션 abc에 속하나 판단 - > False
print("height" not in abc) #True

# -*-* coding:utf-8 -*-

#str
s = "Can't tuna kkk"
print(s)

#문자열 각각에 접근하고 싶다면 인덱스 활용
print(s[3])
print(s[4])

#특정 문자열을 뽑아오고 싶다면
#0번째부터 (6-1) 번째 까지의 문자열
print(s[0:6])

#2번째부터 (10-1)번째까지의 문자열을 2칸씩 건너서 출력
print(s[2:10:2])


print('')
#List
#리스트( 순서 O, 중복 O, 수정 O, 삭제 O) - 특정 원소는 인덱스로 접근
a = [123, 4, 5, 56, 4, 78, 1011]
print(a, type(a))
print(a[0])
print(a[0:3])
print(a[0:5:2])

# [-n] 맨 뒤부터 n번째
print(a[-1])

# 요소의 크기
print(len(a))

#요소에 값 추가(맨 뒤로)
a.append(7777)
print(a)

#요소의 특정 위치에 값 추가(인덱스는 0부터 시작함)
a.insert(2, 2222)
print(a)

#특정 요소 수정
a[0] =1
print(a)

#특정 요소 삭제
del a[0]
print(a)

#정렬기능 존재함
#기본 : 오름차순 정렬
a.sort()
print(a)

#옵션 넣기 가능
a.sort(key=None, reverse=True)
print(a)

print('-------------------')

#Tuple : 순서 O, 중복 O, 값의 수정 X, 값의 삭제 X
tuple1 = ('1', '2', '3')

#삭제, 수정 불가능
#del(tuple1)
#tuple1[0]='4'
print(tuple1)

t = (1,2,3,4,5,4,4)
print(t)

#인덱스로 특정 순서 데이터 반환 가능
print(t.index(5))

#count 함수로 count의 파라미터가 튜플 안에 몇개나 있는지 확인 가능
print(t.count(3))

#튜플로 값을 선언할 수 있음, 소괄호 없어도 가능
#이 경우, a1 b1 변수에 튜플 형식으로 값을 집어넣은거라 a1, b1 변수 자체는 수정이 가능함
(a1, b1) = (10, 20)
print(a1)
a1 =30
print(a1)

#파이썬에서의 값 교환 방식 - Temp 필요 없음, 갯수 제한도 없음
#아래 형식만 지켜주면 그냥 교환 가능
print(a1,b1)
(a1,b1) = (b1,a1)
print(a1, b1)
print('-------------------')


#Set(집합) : 중복된 값 제거(같은 값은 1개만 존재), 출력 순서 랜덤
#구현을 어떻게 한 걸까?
s = {"ㅋ","ㅋ","ㄹ","ㅃ","ㅃ"}
print(s)
print(len(s))

#set을 List로 바꾸기
s = list(s)
print(s)

print('-------------------')

#Dict (=map) {key:value, ...} JSON이랑 비슷함
d = {"name": "곽두팔", "age":12}
print(type(d))

#특정 키로 접근하기
print(d["name"])
print(d["age"])

#Range 
# 0~(10-1) 까지의 정수 범위를 나타냄
r = range(10)
print(r, type(r))

# 2~(10-1) 까지의 정수 범위
r2 = range(2,10)

# 2 ~ (10-1)까지의 범위를 3씩 건너뛰어서 나타냄
r3 = range(2, 10, 3)

#예제
# 0 ~ 9 까지 있는 List 출력
toTen = range(0,10)
toTen_list = list(toTen)
print(toTen_list)

# 1 ~20 중 홀수만 있는 List 출력
to20 = range(1,21,2)
to20_list = list(to20)
print(to20_list)

#다른 방식으로 구현
to20_2_list = []
for to20_2 in range(0, 20):
    if (to20_2 % 2) == 0:
        pass  # 조건에 맞지 않으면 아무 작업도 수행하지 않음
    else:
        to20_2_list.append(to20_2)
        
print(to20_2_list)

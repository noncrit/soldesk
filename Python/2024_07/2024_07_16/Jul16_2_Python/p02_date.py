from datetime import date, datetime


#현재 시간, 날짜를 알아오고 싶을 때( _ 없는걸로 가져오기 )
now = datetime.today()
print(now)

#특정 시간, 날짜
yesterday = datetime(2024, 7, 15)

print(yesterday)
print(type(yesterday))
print(yesterday.year)
print(yesterday.month)

#생일을 입력받아서 나이를 계산해주는 프로그램

birth = input("생년월일을 입력해주세요. 0000/00/00")

birth_c = birth[0:4]
#print(birth)

age = int(datetime.today().year) - int(birth_c)
print("당신의 나이는 %d 살 입니다." %age)
#print(age)


#strptime : str => datetime
bd = datetime.strptime(birth, "%Y/%m/%d")
print(bd)

#strftime : datetime => str
bd = datetime.strftime(bd, "%A")
print(bd)

###########################
"""
%Y : 연도 4자리, / %y : 연도 뒤의 2자리
%m : 월
%d : 일
%H : 시간(24시간) / %I : 시간(12시간)
%p : AM, PM
%M : 분 / %S : 초 / %a : 요일(짧게/Tue) / %A : 요일(길게/Tuesday) / 


"""
###########################
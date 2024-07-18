#input으로 숫자 2개를 입력 -> 테이블에 있는 커피 데이터를 가격기준 오름차순 정렬
#받아온 숫자 2개는 시작값 ~ 끝값
#시작값 ~ 끝 값 까지의 평균 가격을 출력
from cx_Oracle import connect

start = int(input("시작 숫자 입력 : "))
end = int(input("끝 번호 숫자 입력 : "))

con = connect("jin/asd321@localhost:1521/xe")

sql = "select avg(c_price)"
sql += " from (select rownum as rn, c_price"
sql += " from (select c_price from jul18_coffee order by c_price))"
sql +=  f" where rn between {start} and {end}"

cur = con.cursor()
cur.execute(sql)


#cur 안쪽에 tuple 형태로 데이터가 들어가있음 - a의 자료형은 tuple
#tuple 이라는 표시를 위해 (X,) 데이터가 하나여도 무조건 콤마를 찍어줌
for a in cur:
    print(a)
    print(a[0])


con.close()
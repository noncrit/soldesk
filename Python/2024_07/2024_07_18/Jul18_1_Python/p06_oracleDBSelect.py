#input으로 숫자 2개를 입력 -> 테이블에 있는 커피 데이터를 가격기준 오름차순 정렬
#받아온 숫자 2개는 시작값 ~ 끝값
#시작값 ~ 끝 값 까지의 평균 가격을 출력
from cx_Oracle import connect

start = int(input("시작 숫자 입력 : "))
end = int(input("끝 번호 숫자 입력 : "))

con = connect("jin/asd321@localhost:1521/xe")

sql = "select c_price from jul18_coffee order by c_price asc"

cur = con.cursor(sql)

cur.execute(sql)

avg = 0
#divide by zero 때문에 1부터 시작, 마지막 평균 계산 할 때 -1 해줘서 숫자 맞추기
counter = 1

for c in cur:
    
    if start<=counter<=end:
        avg+=c[0]
        counter+=1

#print(counter)
avg=avg/(counter-1)

print(f"{start}번째 부터 {end}까지의 평균 가격 : {round(avg,2)}")
        
con.close()
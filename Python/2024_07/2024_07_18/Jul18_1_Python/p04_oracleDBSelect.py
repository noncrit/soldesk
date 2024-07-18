from cx_Oracle import connect

#각각의 커피 이름, 가격, 원두 정보 가격 오름차순으로 정렬해서 출력

#DB 연결
con = connect("jin/asd321@localhost:1521/xe")

#sql 문 작성
sql = "select c_name, c_price, c_bean from jul18_coffee order by c_price"

#cursor에 넣고 수행하기 / 결과 받아오기
#Select이라서 데이터 받아와야함

cur = con.cursor()

#SQL문 수행
cur.execute(sql)    #수행하면 select의 결과가 cur에 tuple 형태로 들어감

# data = cur.fetchall()   #전체 결과 모두 불러오기
# for i in data:
    # print(i)


# for c in cur:
    # print(c, type(c))
    
for n, p, b in cur:
    print(n, p, b)
    print("---------")

con.close()
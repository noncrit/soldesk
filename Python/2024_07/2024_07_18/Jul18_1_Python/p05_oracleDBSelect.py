from cx_Oracle import connect

#원두의 이름을 검색해서 해당 원두를 사용하는 커피의 종류가 몇 개인지, 원두를 사용하는 커피의 평균가를 출력

#DB 연결
con = connect("jin/asd321@localhost:1521/xe")

bean = input("원두 이름 입력\n")

#sql 문 작성
sql = f"select count(*) from JUL18_COFFEE where c_bean='{bean}'"

sql2 = f"select round(avg(c_price),2) from JUL18_COFFEE where c_bean='{bean}'"

sql3 = "select count(*),round(avg(c_price),2) "
sql3 +=  " from JUL18_COFFEE"
sql3 += f" where c_bean='{bean}'"
#cursor에 넣고 수행하기 / 결과 받아오기
#Select이라서 데이터 받아와야함

cur = con.cursor(sql)
cur2 = con.cursor(sql2)
cur3 = con.cursor(sql3)

#SQL문 수행
cur.execute(sql)    #수행하면 select의 결과가 cur에 tuple 형태로 들어감
cur2.execute(sql2)
cur3.execute(sql3)

print(f"{bean} 원두를 사용하는 커피의 종류 : ",cur.fetchall()[0][0])
print(f"{bean} 원두를 사용하는 커피의 평균가 :" , cur2.fetchall()[0][0])
print("-----")

for c,a in cur3:
    print("해당 원두를 사용하는 커피의 종류 : ", c, "\n원두를 사용하는 커피의 평균가 : ",a)

con.close()
from cx_Oracle import connect

#테이블에 데이터 집어넣기

#1. DB에 연결
con = connect("jin/asd321@localhost:1521/xe")

#3. data 확보
#커피 원두 종류 : 로부스타 / 아라비카 / 리베리카
#각 원두당 커피의 종류 3~4개 씩 넣기

n = input("커피의 이름 : ")
p = int(input("가격 : "))
b = input("원두 종류 : ")

#4. SQL 작성
# Java : 데이터 파라미터로 줘야 하는 자리에 ? 로 처리
# MyBatis : #{멤버 변수명} 저장 객체 만들어서 가져왔음
# Python : 완성된 SQL 문 사용 할 예정 - 문장 끝나고 세미콜론(;) 절대 넣지 않기

sql = f"insert into jul18_coffee values(jul18_coffee_seq.nextval, '{n}', {p}, '{b}')"
# print(sql)

#5. DB 관련 작업(sql문을 DB 서버로 전송 / sql문 실행 / 실행 결과 받아오기) : 총괄객체 하나 선언
#Java : Prepared Statement(Pstmt)
#Python : cursor()

cur = con.cursor()

#6. 작업 수행(SQL 문을 서버로 전송, 실행, 결과 받기)
cur.execute(sql)

#7. 결과 처리
if cur.rowcount == 1: #영향을 받은 데이터의 행(row)수가 1개라면
    print("성공!")
    #실제 DB상에 반영을 위해 commit 필요함 (Python은 오토 커밋 지원 안함)
    con.commit()


#2. DB 연결 종료
con.close()





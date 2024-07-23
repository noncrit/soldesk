from cx_Oracle import connect

#Table에 들어있는 데이터들을 뽑아올 예정
#번호값을 제외한 모든 데이터를 csv 파일 형식으로 담기

con = connect("jin/asd321@localhost:1521/xe")
cur = con.cursor()

sql = "select sl_place_name,sl_phone,sl_x,sl_y from search_location"
#select * 으로 들고왔으면 아래 for 문에서 번호값 순서에 _ 으로 생략처리 해버리면 ㅇㅋ

cur.execute(sql)

data = cur.fetchall()

print(data)

path = "C:\\Users\\sdedu\\Desktop\\Python_lib\\Location\\loc.csv"

# file = open(path, "w", encoding="UTF-8")

with open(path, "w", encoding="UTF-8") as f:
    for name, phone, x, y in data:
        f.write(f"{name},{phone},{x},{y}\n")
         
con.close()

print("-완-")




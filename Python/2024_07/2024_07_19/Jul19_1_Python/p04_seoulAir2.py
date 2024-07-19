from cx_Oracle import connect

#DB에 있는 미세먼지 데이터 -> .csv 파일에 저장 (데이터는 ,로 구분)

con = connect("jin/asd321@localhost:1521/xe")

cur = con.cursor()

sql = "select * from jul19_dust"

file = open("C:\\Users\\sdedu\\Desktop\\Python_lib\\file_test/dust.csv", "w",  encoding="UTF-8")

cur.execute(sql)

data = cur.fetchall()

#print(data)

for day, area, pm10, pm25 in data:
    file.write(f"{day},{area},{pm10},{pm25}\n")
    print("쓰기 성공")

file.close()
con.close()

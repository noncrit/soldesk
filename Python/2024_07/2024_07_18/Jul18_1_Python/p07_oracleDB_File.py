

#DB 연결 => 커피 이름, 가격, 원두 정보를 => 확장자가 csv인 파일로 생성(데이터를 ,를 기분으로 구분)
#ex) 이름,가격,원두
#    이름,가격,원두 ...

from cx_Oracle import connect

file = open("C:\\Users\\sdedu\\Desktop\\Python_lib\\file_test/coffee.csv", "a",  encoding="UTF-8")
con = connect("jin/asd321@localhost:1521/xe")

sql = "select c_name, c_price,c_bean from jul18_coffee order by c_price asc"
comma =","

cur = con.cursor(sql)

cur.execute(sql)

# for a in cur:
    # #print(a)
    # file.write(a[0])
    # file.write(",")
    # file.write(str(a[1]))
    # file.write(",")
    # file.write(a[2])
    # file.write(",\n")
    
for a,b,c in cur:
    #print(a)
    file.write(f"{a},{str(b)},{c}\n")
    # file.write(a)
    # file.write(",")
    # file.write(str(b))
    # file.write(",")
    # file.write(c)
    # file.write(",\n")
    

print("성공!")
file.close()
con.close()


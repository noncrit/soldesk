from cx_Oracle import connect

#DB에 있는 데이터를 csv 파일에 저장
#번호,시간,온도,최고기온,날씨,바람속도

con = connect("jin/asd321@localhost:1521/xe")

cur = con.cursor()

sql = "select w_no, hour, temp, tmx, wfKor, wdKor from jul19_weather"

cur.execute(sql)

file = open("C:\\Users\\sdedu\\Desktop\\Python_lib\\file_test/weather.csv", "a",  encoding="UTF-8")

for w_no, hour, temp, tmx, wfKor, wdKor in cur:
    # print(w_no)
    # print(hour)
    file.write(f"{w_no},{hour},{temp},{tmx},{wfKor},{wdKor}\n")
    print("작성 완료")

file.close()
con.close()



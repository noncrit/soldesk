#http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4122066000
#https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4122066000
#/wid/queryDFSRSS.jsp?zone=4122063000 (옛날에 했던 데이터)
from http.client import HTTPConnection, HTTPSConnection
from xml.etree.ElementTree import fromstring
from cx_Oracle import connect

#기상청 RSS로 가져온 데이터에서
#시간대 / 기온 / 최고기온 / 날씨(한글) / 바람의 방향(한글)
#이 요소들을 DB에 넣기

hc = HTTPConnection("www.kma.go.kr")
hcs = HTTPSConnection("www.kma.go.kr")

hcs.request("GET", "/wid/queryDFSRSS.jsp?zone=4122066000")

res = hcs.getresponse()  #응답 가져오기
resBody = res.read()    #응답 내용
print(resBody.decode()) #출력(한글처리)

con = connect("jin/asd321@localhost:1521/xe")

cur = con.cursor()

for w in fromstring(resBody).iter("data"):   
    # print(w.find("hour").text)
    # print(w.find("temp").text)
    # print(w.find("tmx").text)
    # print(w.find("wfKor").text)
    # print(w.find("wdKor").text)
    
    hour = w.find("hour").text
    temp = w.find("temp").text
    tmx = w.find("tmx").text
    wfKor = w.find("wfKor").text
    wdKor = w.find("wdKor").text
    
    sql = f"insert into jul19_weather values({hour},{temp},{tmx},'{wfKor}','{wdKor}', jul19_weather_seq.nextval)"
    cur.execute(sql)
    if cur.rowcount ==1:
        print("작업 성공")
        print("--------")
        con.commit()
    
con.close()
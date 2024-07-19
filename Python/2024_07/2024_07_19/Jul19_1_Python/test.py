from http.client import HTTPConnection, HTTPSConnection
from xml.etree.ElementTree import fromstring
from cx_Oracle import connect

#기상청 RSS로 가져온 데이터에서
#시간대 / 기온 / 최고기온 / 날씨(한글) / 바람의 방향(한글)
#이 요소들을 DB에 넣기
#https://www.weather.go.kr/w/rss/dfs/hr1-forecast.do?zone=4122063000

hc = HTTPConnection("www.kma.go.kr")
hcs = HTTPSConnection("www.weather.go.kr")

hcs.request("GET", "/w/rss/dfs/hr1-forecast.do?zone=4122063000")

res = hcs.getresponse()  #응답 가져오기
resBody = res.read()    #응답 내용
print(resBody.decode()) #출력(한글처리)

con = connect("jin/asd321@localhost:1521/xe")

cur = con.cursor()

for w in fromstring(resBody).iter("data"):   
    print(w.find("hour").text)
    print(w.find("temp").text)
    print(w.find("tmx").text)
    print(w.find("wfKor").text)
    print(w.find("wdKor").text)
    
con.close()
#http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4122066000
#https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4122066000
from http.client import HTTPConnection, HTTPSConnection
from xml.etree.ElementTree import fromstring


# http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4122066000
#http,https 두 가지 모두 구현 - 커넥션 구현만 다르게해주면 끝

hc = HTTPConnection("www.kma.go.kr")
hcs = HTTPSConnection("www.kma.go.kr")

hcs.request("GET", "/wid/queryDFSRSS.jsp?zone=4122066000")

res = hcs.getresponse()  #응답 가져오기
resBody = res.read()    #응답 내용
# print(resBody.decode()) #출력(한글처리)

#XML Parsing
#DOM 객체를 여러 개 찾기 : .getiterator("태그명"), .iter("태그명")
#DOM 객체 하나 찾기 : .find("태그명")

#XML 을 pythonn string으로 만들기

# kmaweather = fromstring(resBody)
# weathers = kmaweather.iter("data")
# #print(weathers)
#
# for w in weathers:
    # print(w)
    # print("---")

for w in fromstring(resBody).getiterator("data"):   
    print(w.find("hour").text)
    print(w.find("temp").text)
    print(w.find("wfKor").text)
    print("--------")



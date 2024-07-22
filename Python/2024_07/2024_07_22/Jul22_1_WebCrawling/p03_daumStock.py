from fake_useragent.fake import UserAgent
import urllib.request as req
from json import loads

#어떤 브라우저들은 보통 get, post 방식으로 요청을 보내는 주체가 사람이 아닌 프로그램인 것을 확인하는 경우 접속을 차단해버림
#'나 컴퓨터 아님'을 증명해야 함 -> 라이브러리 하다 사용할 예정

#fake header 정보 (가상으로 User-agent 랜덤 생성)
#Python으로 정보를 크롤링하지만, 마치 웹 브라우저에서 실행하는 것 처럼 인식하도록 만들기

ua = UserAgent()
# print(ua.ie)
# print(ua.msie)
# print(ua.chrome)
# print(ua.safari)
# print(ua.random)

#헤더 선언 : dict 형태로(key, value)

h = {
        "User-Agent":ua.chrome,
        "referer":"https://finance.daum.net/" #해당 경로를 통해 접근했음을 나타냄
    }

#다음 금융 (주식) 요청 URL
url = "https://finance.daum.net/api/search/ranks?limit=10"

#요청

res = req.urlopen(req.Request(url, headers=h)).read().decode()

#응답 데이터 확인
#print('res : ', res)

#응답 데이터를 => python 으로 바꾼후 순위, 주식명, 거래가를 콘솔에 출력

data = loads(res)
print(data["data"])
#List 안의 객체가 dict들 이니까 그냥 리스트인채로 접근해야함
for a in data["data"]:
    # print(a)
    print("--------")
    rank = a["rank"]
    name = a["name"]
    tradePrice = a["tradePrice"]
    print("순위 : ", rank)
    print("주식명 : ", name)
    print("거래 가격 : ",tradePrice)


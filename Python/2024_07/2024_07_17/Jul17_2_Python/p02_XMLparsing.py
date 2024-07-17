#a
#a
from http.client import HTTPSConnection
from urllib.parse import quote
from xml.etree.ElementTree import fromstring


#https://openapi.naver.com/v1/search/shop.xml

#상품명 : 직접 입력
#xml 파싱해서
#문서의 상품 이름 / 최저가 / 브랜드 / 대분류 카테고리 출력하기

#한글 인코딩 주의!!
pname = input("상품명을 입력해주세요")
#URL Encode
pname = quote(pname)
print(pname)

hcs = HTTPSConnection("openapi.naver.com")
headers = {"X-Naver-Client-Id":"a",
           "X-Naver-Client-Secret":"a"}
#이번에는 단순 검색요청이라 body에 데이터 들어갈게 없음
hcs.request("GET", f"/v1/search/shop.xml?query={pname}", headers=headers)

res = hcs.getresponse()
resBody = res.read()
print(resBody.decode())

for w in fromstring(resBody).iter("item"):
    print("-----")
    #상품명
    print(w.find("title").text.replace("<b>", "").replace("</b>", ""))
    
    #최저가
    lprice=int(w.find("lprice").text)
    print(f"₩ {lprice:,}")
    
    #브랜드명
    print(w.find("brand").text)
    
    #대분류 카테고리
    print(w.find("category1").text)
    

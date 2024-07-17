#6fba57e94e4317694bf83087f3fe44f5
#https://dapi.kakao.com/v3/search/book
from http.client import HTTPSConnection
from httpx._urlparse import quote
from json import loads
from _operator import add

#책의 키워드를 검색해서 책 제목, 작가, 할인가, 도서 소개 내용을 출력
search = input("검색할 내용을 입력해주세요")

search = quote(search)
print(search)


api = '6fba57e94e4317694bf83087f3fe44f5'
h = {
        "Authorization":"KakaoAK 6fba57e94e4317694bf83087f3fe44f5"
    }

huc = HTTPSConnection("dapi.kakao.com")

huc.request("GET", f"/v3/search/book?query={search}", headers=h)
res = huc.getresponse()
resBody = res.read()

data = loads(resBody)

print(data)
index = 0
max_length = len(data["documents"])
#예외처리를 이걸로 해주든가, 아니면 try-except 쓰자

#for x in y  사용할 때 x가 y의 어떤 데이터이고, 어떤 형식인지 확실히 알고 쓰기
#w의 경우 data["documents"]의 하위 객체 -> 0 ~ end 번 까지의 dict를 나타냄
#이걸 제대로 이해하고 코드를 짰으면 index 변수는 필요하지 않았음 
for w in data["documents"]:
    #제목
    # title = data["documents"][index]["title"]
    title = w["title"]
    
    #작가
    authors = ""
    max_length_author = len(data["documents"][index]["authors"])
    for t in data["documents"][index]["authors"]:
        authors=authors+(t)+" "

    #join 활용한 작가명 가져오기
    authors2 =", ".join(w["authors"])
    #.join() : list를 문자열로 만들 때 쓰임  
    #구분자.join() : list의 요소들을 지정한 구분자로 나눠서 하나의 문자열로 합쳐줌  
    #",".join(b["authors"]))
    
    #할인가    
    #sale_price =data["documents"][index]["sale_price"]
    sale_price =w["sale_price"]
    
    #내용 설명
    #contents = data["documents"][index]["contents"]
    contents = w["contents"]
    
    #출판사
    publisher= data["documents"][index]["publisher"]
   
    print("-----")
    print(title)
    print(authors)
    print(authors2)
    print(sale_price)
    print(contents)
    print(publisher)
    if index<max_length:
        index +=1

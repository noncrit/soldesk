import requests
from bs4 import BeautifulSoup
from urllib.parse import quote

#https://search.daum.net/search?w=news&m=&q=%ED%8C%A8%EC%8A%A4%20%EC%98%A4%EB%B8%8C%20%EC%97%91%EC%9E%90%EC%9D%BC&nzq=poe&DA=NSJ

#검색어 - 직접 입력
#요청했을 때 나오는 결과의 1~5페이지의 뉴스 제목을 출력

def newTitle(url, q):
    
    for i in range(0,5):
        print(f"================== {i+1} 페이지===================")
        url_full = url + q + "&enc=utf8&cluster=y&cluster_page=1&DA=DNS"+"&p="+str(i+1)
        print(url_full)
        
        res = requests.get(url_full)
        
        soup = BeautifulSoup(res.text,'html.parser')
        
        ul = soup.select_one("ul.c-list-basic")
        
        #원래는 선택자 경로 복사로 쭉 이어와야함
        titles = ul.select(".item-title")
        # print(type(titles))
        
        for i in titles:
            print(i.text)

#######################

q = quote(input("검색어 입력 : "))

url = "https://search.daum.net/search?w=news&m=&q="

newTitle(url, q)

import requests
from bleach._vendor.parse import quote
from bs4 import BeautifulSoup

#네이버 노래 검색
#가수, 노래 제목을 직접 입력해서 요청
#노래 가사에 대한 내용을 출력
def naverMusic(singer, title):
    
    url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query="+singer+"+"+title+"+%EA%B0%80%EC%82%AC"
    
    res = requests.get(url)
    
    if res.status_code==200:
    
        soup = BeautifulSoup(res.text, 'html.parser')
        
        #두 가지 방식 중 하나가 쓰임 NoneType과 타입이 같으면(1번 방식 아니면) 아래쪽 실행하면 됨
        intro_box = soup.select_one(".cm_content_wrap").find("div", class_="intro_box")
        
        if(type(intro_box)==type(None)):
            intro_box = soup.select_one(".cm_content_wrap").find("div", class_="text_expand text_center _ellipsis")
         
        print(intro_box.text)
    
    else:
        print(res.status_code)
    
    

##############

artist = quote(input("가수 입력\n"))
title = quote(input("노래 제목 입력\n"))

naverMusic(artist, title)


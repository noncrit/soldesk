from urllib.parse import urlencode, quote
import requests
from bs4 import BeautifulSoup

#CSS 선택자로 데이터 접근하기
#지식IN 검색 결과 중 제목만 들고오려고함
#https://kin.naver.com/search/list.naver?query=
#검색어를 입력했을 때,
#url 주소 뒤에 요청 파라미터로 start=숫자 넣게 되면 시작 글 번호 지정 가능
#관련 뉴스 내용 중 뉴스 내용 5페이지까지의 뉴스 제목들을 콘솔에 출력

# https://search.naver.com/search.naver?where=news&query=%ED%94%BC%EC%9E%90&sm=tab_tmr&nso=so:r,p:all,a:all&sort=0
def getTitle(url):
    
    for i in range(0,5):
        #1페이지 1~10/ 2페이지 11~20 ... 5페이지 41~50
        print(f"================== {i+1} 페이지===================")
        start = 10 * i + 1 #1/11/21.../41
        url_full = url + q + "&sm=tab_tmr&nso=so:r,p:all,a:all&sort=0&start=" + str(start)
        
        res = requests.get(url_full)
        
        soup = BeautifulSoup(res.text, 'html.parser')
        
        news = soup.select(".news_tit")
        
        for n in news:
            print(n.text)
        
        


##############################################    
q = quote(input("검색어 입력 : "))
# print(q)

url = f"https://search.naver.com/search.naver?ssc=tab.news.all&where=news&sm=tab_jum&query={q}"
#
# response = requests.get(url)
#
# if response.status_code==200:
    # html = response.text
    #
    # soup = BeautifulSoup(html, 'html.parser')
    #
    # title = soup.select_one("div.main_pack")
    # # print(title)
    # #main_pack > section.sc_new.sp_nnews._fe_news_collection._prs_nws > div.api_subject_bx > div.group_news > ul
    #
    # titles = title.select("section.sc_new.sp_nnews._fe_news_collection._prs_nws > div.api_subject_bx > div.group_news > ul>li")
    #
    # for title in titles:
        # a = title.find("div").select("news_contents")
        # print(title.find("div", class_="news_contents").find("a", class_="news_tit").get("title"))
        #
print("-------------------------")

getTitle(url)
    
    
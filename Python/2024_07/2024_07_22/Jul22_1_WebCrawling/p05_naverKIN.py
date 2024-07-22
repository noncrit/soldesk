from urllib.parse import urlencode, quote
import requests
from bs4 import BeautifulSoup

#CSS 선택자로 데이터 접근하기
#지식IN 검색 결과 중 제목만 들고오려고함
#https://kin.naver.com/search/list.naver?query=

q = quote(input("검색어 입력 : "))
# print(q)


url = f"https://kin.naver.com/search/list.naver?query={q}"

# cmd => pip install requests
# requests : urllib 보다는 조금 간편한 형태

response = requests.get(url)
#정상적인 요청 결과 : 200
# print(response.status_code)

if response.status_code==200:
    html = response.text
    # print(html)
    soup = BeautifulSoup(html, 'html.parser')
    
    #ul 태그의 basic1에 접근
    #select_one을 사용하는 경우 : 전체 HTML 문서의 처음부터 찾게 되며
    #가장 처음에 만나는 해당 selector를 호출함
    ul = soup.select_one("ul.basic1")
    
    #s_content > div.section > ul > li:nth-child(1) > dl > dt >a
    #>는 하위 태그 표시
    #select : 해당하는 selector들의 모든 내용이 list에 담긴다
    # > : 그 하위에 있는 selector 전부 다
    titles = ul.select("li>dl>dt>a")
    
    for title in titles:
        print(title.text)
else:
    print(response.status_code)








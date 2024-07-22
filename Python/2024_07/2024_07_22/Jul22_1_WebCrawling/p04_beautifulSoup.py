from bs4 import BeautifulSoup
# Beautiful Soup 라이브러리 사용

# cmd - pip install bs4

htmlEx = """
<html>
<head>
<meta charset="UTF-8">
<title>우리는 bs4로 Web Crawling을 할 거에요!</title>
</head>
<body>
<h1>다들 월요일이고, 비가 많이와서 힘드시겠지만</h1>
<h2>조금만 더 힘내보아요</h2>
<p><b>Beautiful Soup</b></p>
<p>Python에서 Crawling 할 때 유용하게 사용할 수 있는 Library
<a href="#">구글</a>
<a href="#">네이버</a>
<a href="#">유튜브</a>
</p>
<p>How to use bs4</p>
</body>
</html>
"""

#BS4 객체 생성
#html.parser : HTML 문법 규칙에 따른 문자열, 해당 문법을 바탕으로 특정 단어의 의미, 구조를 분석하는 프로그램
soup = BeautifulSoup(htmlEx, 'html.parser')

# print(soup)

#코드 예쁘게 정리해주는 기능이 soup에 있긴함 (정?리)
# print(soup.prettify())

#HTML title 찾아오기
title = soup.html.head.title
print(title)    #Title의 태그명 까지 모두 가지고옴
print(title.text)
print(title.getText())
print("----------------------------------")

#h1 태그 텍스트 출력하기
h1 = soup.html.body.h1
print(h1.getText())
print(h1.string)
print("----------------------------------")

#p태그 접근하기
p1 = soup.html.body.p
print(p1)
print(p1.string)
print(p1.text)
print("----------------------------------")

#next_sibling : HTML 동일한 레벨상의 다음 요소를 불러오기
#<-> previous_sibling
#태그와 태그 사이에 개행(\n) 이 있는 경우 -> 사이 공간은 엔터로 취급
#근데 이 개행 처리를 bs가 하나의 요소로 인식해버림 - next_sibling을 한번 더 실행
p2 = p1.next_sibling.next_sibling
print(p2)
print(p2.text)
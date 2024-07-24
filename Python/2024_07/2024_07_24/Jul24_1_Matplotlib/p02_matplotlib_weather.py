from http.client import HTTPConnection
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
import numpy as np
from xml.etree.ElementTree import fromstring
#기상청 데이터 -> 각 시간별 기온(temp), 습도(reh)를 선 그래프로 표현(RSS는 3시간 단위 )

#음수 부호(마이너스 값) 안나오는 것 방지
plt.rcParams["axes.unicode_minus"] = False

fontFile = "C://Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

#http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4122063000

hc = HTTPConnection("www.kma.go.kr")

hc.request("GET", "/wid/queryDFSRSS.jsp?zone=4122063000")

res = hc.getresponse()

data = res.read()

x_hour = list([])
temp = list([])
reh = list([])

hc.close()

for w in fromstring(data).iter("data"):
    hour = int(w.find("hour").text)+int(w.find("day").text)*24
    x_hour.append(hour)
    
    temp.append(float(w.find("temp").text))
    
    reh.append(int(w.find("reh").text))

# print(len(x_hour))
# print(len(temp))
# print(len(reh))

x1 = plt.subplot()  #여러 그래프들을 동시에 시각화
temp_graph = x1.plot(x_hour, temp, "r-o")
x1.set_xlabel("시간")
x1.set_ylabel("기온")

#twinx - x축을 공유하는 그래프
x2 = x1.twinx()
reh_graph = x2.plot(x_hour, reh, "b:^")
x2.set_ylabel("습도")
#p1 + p2 는 범주 합치기
x1.legend(temp_graph + reh_graph, ["온도", "습도"])

plt.xticks([12,24,48], ["오늘","내일","내일 모레"])

plt.show()




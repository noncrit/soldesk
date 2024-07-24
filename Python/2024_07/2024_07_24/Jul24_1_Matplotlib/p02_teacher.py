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

hours = []
temps = []
rehs = []

for w in fromstring(data).iter("data"):
    hours.append(w.find("hour").text + "시")
    temps.append(float(w.find("temp").text))
    rehs.append(float(w.find("reh").text))
    
# print(hours)

#x축 시간 처리를 위한 인덱스
#range는 리스트를 리턴함
indexes = range(len(hours))
# print(range(len(hours))[10])

x1 = plt.subplot()
p1 = x1.plot(indexes, temps, "r-o")
x1.axis([None, None, None, 38])
x1.set_xlabel("시간")
x1.set_ylabel("기온")

x2 = x1.twinx()
p2 = x2.plot(indexes, rehs, "b:^")
x2.set_ylabel("습도")
x2.axis([None, None, 0, 100])

plt.title("날씨", loc="center")
x1.legend(p1+p2, ["기온","습도"])

plt.xticks(indexes, hours)

plt.show()

hc.close()






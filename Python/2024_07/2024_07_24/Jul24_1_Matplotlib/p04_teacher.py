import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
import numpy as np
from http.client import HTTPConnection
from json import loads

#음수 부호(마이너스 값) 안나오는 것 방지
plt.rcParams["axes.unicode_minus"] = False

fontFile = "C://Windows/Fonts/malgun.ttf"
fontName = fm.FontProperties(fname=fontFile, size=50).get_name()
plt.rc("font", family=fontName)

#강사님 코드

#서북권, 도심권, 동북권 ... 의 미세먼지(PM10) / 초미세먼지(PM25)의 평균값을 권역별로 구한 후
#bar 그래프로 표현 (누적합 형태)

hc = HTTPConnection("openapi.seoul.go.kr:8088")

hc.request("GET", "/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/")

resBody = hc.getresponse().read()
# print(resBody.decode())

airData = loads(resBody)

#{'동남권': 3 ...} 권역별 등장 횟수 카운팅을 위한 dict
whereDict = {} 

#{'동남권': 25.6 ...} 미세먼지 수치를 권역별로 구분하기 위한 dict
pm10Dict = {}
pm25Dict = {}

for a in airData["RealtimeCityAir"]["row"]:
    where = a["MSRRGN_NM"]
    pm10 = float(a["PM10"])
    pm25 = float(a["PM25"])
    
    if where in pm10Dict:
        pm10Dict[where] += pm10
        pm25Dict[where] += pm25
        whereDict[where] += 1
    else:
        pm10Dict[where] = pm10
        pm25Dict[where] = pm25
        whereDict[where] = 1
        
###########

names = []
pm10s = []
pm25s = []

for k,v in whereDict.items():
    names.append(k)
    pm10s.append(pm10Dict[k] / v)
    pm25s.append(pm25Dict[k] / v)
    
print(names); print(pm10s); print(pm25s);

plt.bar(names, pm10s, color="#FFA7A7")
plt.bar(names, pm25s, color="#B2CCFF", bottom = pm10s)
plt.legend(["미세먼지","초미세먼지"])

plt.show()

hc.close()

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

#방금 만든 csv 파일 활용
#연월에 맞춰서 -> 유임승차, 무임승차, 유임하차, 무임하차
#선 그래프로 나타내기

path = "C:/Users/sdedu/Desktop/Subway_data/Jul25_Subway_inout.csv"

prnDict, frnDict, panDict, fanDict = {},{},{},{}

with open(path,"r",encoding="UTF-8") as f:
    for line in f.readlines():
        line = line.replace("\n","").split(",")
        
        when = line[0]
        prn = int(line[3]); frn = int(line[4])
        pan = int(line[5]); fan = int(line[6])
        
        if when in prnDict:
            prnDict[when] += prn
            frnDict[when] += frn
            panDict[when] += pan
            fanDict[when] += fan
        else:
            prnDict[when] = prn
            frnDict[when] = frn
            panDict[when] = pan
            fanDict[when] = fan

whens, prns, frns, pans, fans = [],[],[],[], []

for k,v in prnDict.items():
    whens.append(k)
    prns.append(v)
    frns.append(frnDict[k])
    pans.append(panDict[k])
    fans.append(fanDict[k])
    
# print("------------------")
# print(whens)
# print(prns)
# print(frns)  

plt.plot(whens,prns,color="#EF9A9A")
plt.plot(whens,frns,color="blue")
plt.plot(whens,pans,color="#90CAF9")
plt.plot(whens,fans,color="black")

plt.legend(["유임승차","무임승차","유임하차","무임하차"])
plt.title("월별 지하철 유/무임 승차 정보")
plt.show()


            
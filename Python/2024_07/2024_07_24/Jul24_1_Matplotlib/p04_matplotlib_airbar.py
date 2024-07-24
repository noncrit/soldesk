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

#나의 목표 : 완전 자동화 -> 권역에 대한 정보를 내가 코드에서 명시적으로 선언 안 할 예정 - 동적으로 데이터에서 받아올 것

#서북권, 도심권, 동북권 ... 의 미세먼지(PM10) / 초미세먼지(PM25)의 평균값을 권역별로 구한 후
#bar 그래프로 표현 (누적합 형태)

#http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/

hc = HTTPConnection("openapi.seoul.go.kr:8088")

hc.request("GET", "/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/")

res = hc.getresponse().read()
# print(res)

data = loads(res)
# print(data)

regions= []

#권역 이름을 동적으로 받아와서 regions 리스트에 할당
for d in data["RealtimeCityAir"]["row"]:
    if d["MSRRGN_NM"] not in regions:
        regions.append(d["MSRRGN_NM"])

# print(len(regions))

#권역별 미세먼지(pm10)/초미세먼지(pm25) 데이터 정리를 위해 regions에 받아온
#권역 이름을 이용해 dict의 키를 생성하고, 해당 dict의 하위 객체로 pm10, pm25를 추가함
#예를 들어 regions에 A,B가 있었다면
#아래에서는 
#pm_data["A"] = { 'pm10': [], 'pm25': [] }
#pm_data["B"] = { 'pm10': [], 'pm25': [] }
#이런식으로 pm_data 내부에 A,B 키로 구분 할 수 있는 같은 형식의 dict들이 만들어짐
pm_data = {}
for i, region in enumerate(regions):
    pm_data[region] = {
        'pm10': [],
        'pm25': []
    }

# print(pm_data.keys())

#서울시 미세먼지/초 미세먼지 데이터값을 받아와서 아까 생성한 pm_data에 넣는 루프문
# if key in str(d["MSRRGN_NM"]) 
# 위의 부분을 통해 key와 데이터에서 받아온 권역 이름이 일치하는 경우에만 
# pm_data[해당 키] 의 pm10, pm25 리스트에 각각 값을 추가함
for d in data["RealtimeCityAir"]["row"]:
    pm10_val = float(d["PM10"])
    pm25_val = float(d["PM25"])
    
    for key in pm_data.keys():
        if key in str(d["MSRRGN_NM"]):
            pm_data[key]["pm10"].append(pm10_val)
            pm_data[key]["pm25"].append(pm25_val)

#권역별 미세먼지 평균값 계산을 위한 동적 dict 생성
#key값은 데이터에서 받아온 regions의 값을 따름
#마찬가지로 regions의 데이터를 이용해 키를 생성하고 평균값 계산을 위한 dict의 하위 리스트 pm10_avg, pm25_avg를 생성한다.
pm_data_avg = {}
for i, region in enumerate(regions):
    pm_data_avg[region] = {
        'pm10_avg': [],
        'pm25_avg': []
    }
    
#pm_data에 key를 기반으로 접근해 평균을 계산한 후, 
#pm_data_avg["해당 키 값"]["pm10_avg"], pm_data_avg["해당 키 값"]["pm25_avg"] 에 각각 계산한 평균값을 저장
for key in pm_data_avg:
    # print(key)
    pm10_avg = round( sum(pm_data[key]["pm10"]) / len(pm_data[key]["pm10"]), 2)
    pm25_avg = round( sum(pm_data[key]["pm25"]) / len(pm_data[key]["pm25"]), 2)
    # print(pm10_avg)
    pm_data_avg[key]["pm10_avg"]=pm10_avg
    pm_data_avg[key]["pm25_avg"]=pm25_avg

#그래프를 그리기위한 matplotlib 포맷 구현하는 반복문
#미세먼지는 회색, 초미세먼지는 빨간색으로 누적합 형식으로 그래프 그리기
#목차도 추가
for key in pm_data_avg:
    plt.bar(key, pm_data_avg[key]["pm10_avg"], color="gray")
    plt.bar(key, pm_data_avg[key]["pm25_avg"], color="red", bottom=pm_data_avg[key]["pm10_avg"])

plt.title("서울 권역별 평균 미세먼지", loc="center")
plt.legend(["미세먼지","초미세먼지"])
plt.show()
        
hc.close()


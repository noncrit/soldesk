from http.client import HTTPConnection, HTTPSConnection
import calendar
from json import loads
import math

#http://openapi.seoul.go.kr:8088
#/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/1/1000/20151101/
#4f626857416f6c6c3632586a416843

#2021 ~ 2023년 3년치 데이터를
#연,월,일,노선번호,정류장명(역명),승차총승객수,하차총승객수
#csv 파일에 저장하기
#데이터 요청은 한번에 최대 1000건

#정류장(역명) -> 쉼표(,)가 들어있을수도 있음
#쉼표를 마침표로(.) 바꿔서 저장

#인원수 -> 정수 형태로 저장

year = [2021,2022,2023]
month_day = {}

for y in year:
    for month in range(1,13):
        month_day[y] = {
            "day":[]
        }
        
#년도별 각 월의 일수를 1~12 월까지 저장
for y in year:
    for month in range(1,13):
        month_day[y]["day"].append(calendar.monthrange(y, month)[1])     

#calendar.monthrange(year, month)
# for a in month_day[2021]["day"]:
    # print(a)
    
#포맷팅 된 month
month =[]
for i in range(1,13):
    month.append("%02d"%i)
    
 
hc = HTTPConnection("openapi.seoul.go.kr:8088")

#파일 경로
path = "C:/Users/sdedu/Desktop/bus_data/bus.csv"
file = open(path,"w",encoding="UTF-8")

for y in year:
    for m in month:
        for a in month_day[y]["day"]:
            for b in range(1,a+1):
                # print(f"{y}{m}"+"%02d"%b)
                # print(f"/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/1/2/{y}{m}"+"%02d/" % b)
                hc.request("GET", f"/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/1/2/{y}{m}"+"%02d/" % b )
                res = hc.getresponse().read()
                data = loads(res)
                data_range = data["CardBusStatisticsServiceNew"]["list_total_count"]
                # print(data_range)
                target_range = math.ceil((data_range/1000) +1)
                # print(target_range)
                #1~1000/1001~2000
                for x in range(1,target_range):
                    hc.request("GET", f"/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/{1+(x-1)*1000}/{x*1000}/{y}{m}"+"%02d/" % b )
                    # print(f"/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/{1+(x-1)*1000}/{x*1000}/{y}{m}"+"%02d/" % b)
                    res2 = hc.getresponse().read()
                    data2 = loads(res2)
                    
                    for k in data2["CardBusStatisticsServiceNew"]["row"]:
                        year_in = k["USE_YMD"][0:4]
                        mont_in = k["USE_YMD"][4:6]
                        day_in = k["USE_YMD"][6:8]
                        RTE_NO = k["RTE_NO"]
                        SBWY_STNS_NM = k["SBWY_STNS_NM"]
                        SBWY_STNS_NM.replace(",", ".")
                        GTON_TNOPE = int(k["GTON_TNOPE"])
                        GTOFF_TNOPE = int(k["GTOFF_TNOPE"])
                        file.write(f"{year_in} {mont_in} {day_in}, {RTE_NO}, {SBWY_STNS_NM}, {GTON_TNOPE}, {GTOFF_TNOPE}\n")
            
            print(f"{y} {m} {b} success")     

file.close()


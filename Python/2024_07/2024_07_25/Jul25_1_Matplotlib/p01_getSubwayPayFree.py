from http.client import HTTPConnection
from json import loads
import math

#http://openapi.seoul.go.kr:8088/json/CardSubwayPayFree/1/5/201501/
#4f626857416f6c6c3632586a416843

#2019 ~ 2023년 까지 월별로 하나의 파일 (csv) 형식으로 저장
#연월(ex:201901),호선명,지하철역,유임승차인원,무임승차인원,유임하차인원,무임하차인원

year = [2019,2020,2021,2022,2023]

month =[]
for i in range(1,13):
    month.append("%02d"%i)
    
hc = HTTPConnection("openapi.seoul.go.kr:8088")
filepath = "C:/Users/sdedu/Desktop/Subway_data/Jul25_Subway_inout.csv"
file = open(filepath, "w", encoding="UTF-8")

for y in year:
    for m in month:
        url = f"/4f626857416f6c6c3632586a416843/json/CardSubwayPayFree/1/5/{y}{m}/"
        url.replace(" ","%20")
        hc.request("GET", url=url)
        res = hc.getresponse().read()
        # print(res.decode())
        data = loads(res)
        # print(data)
        total_count = int(data["CardSubwayPayFree"]["list_total_count"])
        target_count = math.ceil((total_count/100)) +1
            
        for x in range(1,target_count):
            url_t = f"/4f626857416f6c6c3632586a416843/json/CardSubwayPayFree/{1+(x-1)*100}/{x*100}/{y}{m}/"
            url_t.replace(" ","%20")
            print(url_t)
            hc.request("GET", url_t)
            res2 = hc.getresponse().read()
            data_t = loads(res2)
                
            for t in data_t["CardSubwayPayFree"]["row"]:
                USE_MM = t["USE_MM"]
                    
                SBWY_ROUT_LN_NM = t["SBWY_ROUT_LN_NM"]
                    
                STTN = t["STTN"]
                   
                #유임승차인원
                RMIO_GTON_NOPE = int(t["RMIO_GTON_NOPE"])
                    
                #무임승차인원
                FREECHRG_GTON_NOPE = int(t["FREECHRG_GTON_NOPE"])
                    
                #유임하차인원
                RMIO_GTOFF_NOPE = int(t["RMIO_GTOFF_NOPE"])
                    
                #무임하차인원
                FREECHRG_GTOFF_NOPE = int(t["FREECHRG_GTOFF_NOPE"])
                    
                t_string = f"{USE_MM},{SBWY_ROUT_LN_NM},{STTN},{RMIO_GTON_NOPE},{FREECHRG_GTON_NOPE},{RMIO_GTOFF_NOPE},{FREECHRG_GTOFF_NOPE}\n"
                # print(t_string)
                
                file.write(t_string)
                print(t_string)
    
file.close()
hc.close()
    



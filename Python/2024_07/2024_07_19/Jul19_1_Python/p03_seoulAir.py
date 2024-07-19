#서울 권역별 미세먼지 API
#http://openAPI.seoul.go.kr:8088/(인증키)/json/RealtimeCityAir/1/25/
from http.client import HTTPConnection
from json import loads
from cx_Oracle import connect

#4f626857416f6c6c3632586a416843

#구 이름, 미세먼지 수치, 초 미세먼지 수치를 DB에 담기
#조건 : 데이터들을 여러 기간에 걸쳐서 데이터를 모은다고 가정

hc = HTTPConnection("openAPI.seoul.go.kr:8088")

hc.request("GET", "/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/")

result = hc.getresponse().read()

result = loads(result)

# print(result)

con = connect("jin/asd321@localhost:1521/xe")

cur = con.cursor()

sql = f"select jul19_dust_seq.nextval from dual"
cur.execute(sql)
con.commit()

for w in result["RealtimeCityAir"]["row"]:
    #print(w)
    areaName = w["MSRSTE_NM"]
    dust = float(w["PM10"])
    dust_small = float(w["PM25"])
    
    sql = f"insert into jul19_dust values(jul19_dust_seq.currval,'{areaName}',{dust},{dust_small})"
    cur.execute(sql)
    if cur.rowcount==1:
        print("성공")
        con.commit()

con.close()

    
    



from http.client import HTTPSConnection
from urllib.parse import quote
from json import loads
from cx_Oracle import connect

#6fba57e94e4317694bf83087f3fe44f5
#https://www.google.co.kr/maps/place/%ED%8F%89%ED%83%9D%EC%8B%9C%EC%B2%AD/data=!4m10!1m2!2m1!1z7Y-J7YOd7Iuc7LKt!3m6!1s0x357b3a6306ec5da7:0xe49c3fdefa36a968!8m2!3d36.992329!4d127.112695!15sCgztj4ntg53si5zssq2SAQljaXR5X2hhbGzgAQA!16s%2Fg%2F1tdwsl85?hl=ko&entry=ttu

#36.992329,127.112695

#https://dapi.kakao.com/v2/local/search/keyword.JSON
#응답 데이터는 JSON으로 받아올 예정

#검색어를 입력 -> 위도/경도 받아오기(구글?) -> 반경 1km 이내에 있는 검색어에 대한 위치 정보
#받아올 데이터 -> 장소명(업체명), 전화번호, 경도, 위도
#전화번호 없는 경우 : "-" 로 대체해서 처리
#경도, 위도는 소수점 6번째 자리까지 저장

url = "https://dapi.kakao.com/v2/local/search/keyword.JSON"

header = {"Authorization": "KakaoAK 6fba57e94e4317694bf83087f3fe44f5"}

#검색어 입력
search = quote(input("검색어 입력\n"))
x=36.9923
y=127.112695
search_url = f"?query={search}&y={y}&x={x}&radius=1000"

url = url + search_url
# print(url)

huc = HTTPSConnection("dapi.kakao.com")

huc.request("GET", url, headers=header)

res = huc.getresponse().read()
# print("-----")
# print(res.decode())
# print("----")

res = loads(res)
# print("---res---")
# print(res)

#선언 여기다 하면 마지막 데이터만 들어간다...
# needed_info = {"place_name":"_", "phone":"_", "longtitue":0, "lattitue":0}
result_list = []

con = connect("jin/asd321@localhost:1521/xe")
cur = con.cursor()

for k in res["documents"]:
    # print(k)
    needed_info = {"place_name":"_", "phone":"_", "longtitue":0, "lattitue":0}
    needed_info["place_name"]=k["place_name"]
    needed_info["phone"]=k["phone"]
    needed_info["longtitue"]=round(float(k["x"]),6)
    needed_info["lattitue"]=round(float(k["y"]),6)
    result_list.append(needed_info)
    
    sql = "insert into search_location values("
    sql +="search_location_seq.nextval, "
    sql +=f"'{k['place_name']}', "
    sql +=f"nvl('{k['phone']}','-'), "
    sql +=f"{float(k['x']):.6f}, "
    sql +=f"{float(k['y']):.6f})"
    cur.execute(sql)
    
con.commit()
con.close()
print("sql 처리 완료")

# print(result_list)

for i in result_list:
    for k,v in i.items():
        print(k, " ",v)
        
    print("--------------------")
    

huc.close()
    



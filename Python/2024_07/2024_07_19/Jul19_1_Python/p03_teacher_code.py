#강사님 코드
#서울 권역별 미세먼지 API
#http://openAPI.seoul.go.kr:8088/(인증키)/json/RealtimeCityAir/1/25/
from http.client import HTTPConnection

#4f626857416f6c6c3632586a416843

hc = HTTPConnection("openAPI.seoul.go.kr:8088")
hc.request("GET", "/4f626857416f6c6c3632586a416843/json/RealtimeCityAir/1/25/")

resBody = hc.getresponse().read()
print(resBody.decode())




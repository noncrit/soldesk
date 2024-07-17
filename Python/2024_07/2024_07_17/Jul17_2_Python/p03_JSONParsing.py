#https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
from urllib.parse import quote
from http.client import HTTPSConnection
from json import loads
from _operator import index

#OpenWeather 이용한 JSON Parsing 실습
#42008a8c8e7402a3fc9d3b1a7df8fee9

#https://api.openweathermap.org
#/data/2.5/weather?q={city name}&appid={API key}

#도시 이름 : 영어만 가능
#요청 파라미터 추가 가능
#응답 내용을 출력

api = "42008a8c8e7402a3fc9d3b1a7df8fee9"
cityname=input("도시 이름 입력(영어로)")

#URL Encode(Not needed)
cityname=quote(cityname)

print(cityname)

hcs = HTTPSConnection("api.openweathermap.org")
hcs.request("GET", f"/data/2.5/weather?q={cityname}&appid={api}&units=metric&lang=kr")

res = hcs.getresponse()

resBody = res.read()

print(resBody.decode()) #여기까지 http 통신

#JS JSON -> Python type string으로 바꾸기
#JS에서의 표현과 Python에서의 표현이 의미하는 것이 다른점에 유의하기!
#dict : { key : value }            // JS : object
#list : [1,2,3] => 인덱스 값으로 접근   // JS : list



#loads 하기 전에는 바이너리 파일인듯?
print(resBody)

#loads로 JSON data binary를 Python str 타입으로 바꿔줌
weatherData = loads(resBody)
print(weatherData)

#현재 받아온 데이터의 날씨 / 기온 / 체감기온 / 습도 / 바람의 속도
#데이터를 콘솔창에 출력하기

weather = weatherData["weather"][0]["description"]
temp = weatherData["main"]["temp"]
feelslike = weatherData["main"]["feels_like"]
humidity = weatherData["main"]["humidity"]
wind = weatherData["wind"]["speed"]

print(weather)
print(temp)
print(feelslike)
print(humidity)
print(wind)



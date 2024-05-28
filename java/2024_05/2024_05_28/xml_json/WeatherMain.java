package com.kim.http.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

// https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=42008a8c8e7402a3fc9d3b1a7df8fee9&units=metric&lang=kr
// OPEN weather API key
// 42008a8c8e7402a3fc9d3b1a7df8fee9

public class WeatherMain {
	
	public static void main(String[] args) throws IOException {
		
// 		https://api.openweathermap.org/data/2.5/weather
//		?q={city name}&42008a8c8e7402a3fc9d3b1a7df8fee9={API key}
//		&units=metric&lang=kr
		
		//도시의 이름을 콘솔에서 입력 (영어로 ex : seoul)
		//그 결과가 JSON 형식으로 출력됨
		
		//나라 이름
		//도시 이름
		//description
		//기온
		//체감온도
		//최저기온
		//최고기온
		//기압
		//습도
		try {
			
		Scanner sc= new Scanner(System.in);
		
		System.out.println("도시 이름을 입력해주세요.");
		String city_name=sc.next();
		String address = "https://api.openweathermap.org/data/2.5/weather"
						+"?q="+city_name+"&appid=42008a8c8e7402a3fc9d3b1a7df8fee9"
						+"&units=metric&lang=kr";
		
		InputStream is = HttpClient.download(address);
		String str = HttpClient.convert(is,"UTF-8");
		
		//파싱 진행
		
		JSONParser jp = new JSONParser();
		
		JSONObject jo = (JSONObject) jp.parse(str);
		
		//기온,기압,습도 관련된거 다 main에 있음
		JSONObject main = (JSONObject) jo.get("main");	
		
		//나라 이름
		JSONObject country = (JSONObject) jo.get("sys");
		
		//배열 안에 객체 들어있음 / 배열의 이름은 weather*******이 부분 잘보기!!!****** 구현 못했음
		JSONArray ja = (JSONArray) jo.get("weather");
		JSONObject jo2 = (JSONObject) ja.get(0);
		String description = (String) jo2.get("description");
		
		//상위 개체 이름 지정 안된놈 호출은 이렇게함
		String city = (String) jo.get("name");
		
		
			//나라 이름
			System.out.println("국가 : "+country.get("country"));
			System.out.println("도시 : "+city);
			System.out.println("날씨 : "+description);
			System.out.println("기온 : "+main.get("temp")+" ℃");
			
			double feelslike = (double) main.get("feels_like");
			System.out.println("체감 온도 : "+feelslike+" ℃");
			
			System.out.println("최저 기온 : "+main.get("temp_min")+" ℃");
			System.out.println("최고 기온 : "+main.get("temp_max")+" ℃");
			
			long pressure = (long) main.get("pressure");
			System.out.println("기압 : "+pressure+" Pa");
			
			long humiditiy = (long)	main.get("humidity");
			System.out.println("습도 : "+humiditiy+"%");
			
			System.out.println("--------------");	
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

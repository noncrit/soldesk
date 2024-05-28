package com.kim.http.client;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//37.0014431(y) 127.1245541(x)
//(rest key) //노출 금지! 카카오 dev 가서 직접 받아오기
public class LocSearchMain {
	// 기준점 주변 반경 5km이내의 입력받은 검색 키워드가 포함된 가게들을 거리 기준으로 정렬하기
	
	//JSON 방식
	//총 검색 결과수
	//현재페이지 결과 수
	
	//주소
	//전화번호
	//상호명
	//기준점과의 거리
	//를 출력
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("키워드를 입력해주세요.");
			String search=sc.next();
			System.out.println(search);
			
			search=URLEncoder.encode(search,"UTF-8");
				
			String address = "https://dapi.kakao.com/v2/local/search/keyword.JSON"
							+"?query="+search						//검색어 ?는 필수 파라미터!!!
							+"&y="+"37.0014431"+"&x="+"127.1245541"	//&은 요청 파라미터!!!
							+"&radius="+"5000"
							+"&sort="+"distance";
			
			//헤더처리
			//$는 여기부터 입력이라는 표시		
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("Authorization", "KakaoAK 6fba57e94e4317694bf83087f3fe44f5");
			
			InputStream is = HttpClient.download(address, headers);
			String str = HttpClient.convert(is, "UTF-8");
			System.out.println(str);
			
			//json parsing
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(str);	//가장 바깥을 감싸고 있는 객체!! 선언 어떻게하는지 잘 보기!!
			
			//총 검색 결과수 - meta - total_count (메타는 가장 바깥 객체에 있음)
			JSONObject meta = (JSONObject) jo.get("meta");
			System.out.printf("총 검색 결과 수 : %d개\n",meta.get("total_count"));
			
			//현재페이지 결과 수
			System.out.printf("총 검색 결과 수 : %d개\n",meta.get("pageable_count"));
			
			//documents 배열에 접근
			JSONArray ja = (JSONArray) jo.get("documents");
			JSONObject data = null;
			System.out.println("------------------------------------");
			
			for (int i = 0; i < ja.size(); i++) {
				data = (JSONObject) ja.get(i);
				
				System.out.printf("주소 : %s\n",data.get("address_name"));
				System.out.printf("전화번호 : %s\n",data.get("phone"));
				System.out.printf("상호명 : %s\n",data.get("place_name"));
				System.out.printf("거리 : %skm\n",data.get("distance"));
				
				System.out.println("------------------------------------");
			}
			
			//주소
			
			//전화번호
			//상호명
			//기준점과의 거리
			//를 출력
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}

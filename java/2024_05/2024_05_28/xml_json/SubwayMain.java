import java.io.InputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.kim.http.client.HttpClient;

//Json 파일

//자바 스크립트 기반

//객체  {"DOG", age : 3 } 

//배열 [1,2,3]

//자바와는 문법이 좀 다름

// http://openapi.seoul.go.kr:8088/sample/json/(인증키)/TbSeoulmetroStOrigin/1/275/
//http://openapi.seoul.go.kr:8088/sample/json/TbSeoulmetroStOrigin/1/275/

//http://openapi.seoul.go.kr:8088/sample/json/TbSeoulmetroStOrigin/1/275/
// 4f626857416f6c6c3632586a416843

//http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/TbSeoulmetroStOrigin/1/275/

//encoding 방식 UTF-8


public class SubwayMain {
	
	public static void main(String[] args) {
		try {
			
			String address = "http://openapi.seoul.go.kr:8088"
							+"/4f626857416f6c6c3632586a416843"
							+"/json"
							+"/TbSeoulmetroStOrigin"
							+ "/1"
							+ "/275"
							+ "/";
			InputStream is = HttpClient.download(address);
			String str = HttpClient.convert(is,"UTF-8");
//			System.out.println(str);
			
			//파싱 진행
			
			JSONParser jp = new JSONParser();
			
			JSONObject jo = (JSONObject) jp.parse(str);
//			System.out.println(jo);
			
			JSONObject metro = (JSONObject) jo.get("TbSeoulmetroStOrigin");
			System.out.println(metro);
			
			JSONArray row = (JSONArray) metro.get("row");
//			System.out.println(row);
			
			
			JSONObject data =null;
			
			for (int i = 0; i < row.size(); i++) {
				data = (JSONObject) row.get(i);
				System.out.println(data.get("STATION_NAME"));
				System.out.println(data.get("LINE"));
				System.out.println(data.get("ORIGIN"));
				System.out.println("--------------");	
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

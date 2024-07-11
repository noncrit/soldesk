package com.kim.jul102.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
	//기상청 XML 데이터를 받아와서 String 한 덩어리로 뭉쳐서 그대로 리턴
	public String getKoreaWeather(HttpServletRequest req) {
		try {
			URL u = new URL("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168060000");
			
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			//나오는 데이터 하나 하나를 하나의 덩어리로 뭉치기
			StringBuffer sb = new StringBuffer();
			
			//데이터 버퍼에 모두 뭉쳐놓고 엔터키 입력된 것 붙이도록 처리
			String line = null;
			while( (line = br.readLine() )!= null) {
				sb.append(line.replace("\r\n", ""));
			}
			
			return sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

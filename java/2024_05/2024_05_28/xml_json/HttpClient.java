package com.kim.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

//XML은 모두 문자열
//JSON은 자료형 구현 가능
//두고두고 쓸 예정!!!!
public class HttpClient {

	// 서버에 요청해서 다운받기
	public static InputStream download(String address) throws IOException {
		URL u = new URL(address);
		if (address.startsWith("https")) {
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			return huc.getInputStream();
		} else {
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			return huc.getInputStream();
		} 
	}
	
	//서버에 요청해서 데이터 다운로드(헤더 처리 가능)
	public static InputStream download(String address, HashMap<String, String> headers) throws IOException {
		//MAP => 배열을 대체할 수 있는 컬렉션 중 하나
		//HashMap<key, value> 키값을 불러오면 해당 키의 값이 호출되는 식으로 구현됨
		URL u = new URL(address);
		if (address.startsWith("https")) {
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			Set<String> headerName = headers.keySet();
			for(String hn : headerName) {
				huc.addRequestProperty(hn, headers.get(hn));
			}
			return huc.getInputStream();
		} else {
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			Set<String> headerName = headers.keySet();
			for(String hn : headerName) { //확장 for 문
				huc.addRequestProperty(hn, headers.get(hn));
			}
			return huc.getInputStream();
		}
	}
	
	// 다운받은걸 String으로 바꾸기
	public static String convert(InputStream is, String charset) throws IOException {
		InputStreamReader isr = new InputStreamReader(is, charset);
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;
		StringBuffer sb = new StringBuffer();
		while ( (line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
	
	
	
}


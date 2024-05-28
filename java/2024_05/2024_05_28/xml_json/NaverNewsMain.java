package com.kim.http.client;
//*****XPath 수업내용 다시보기 5/27**********
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.HashMap;
import java.util.Scanner;

import javax.management.modelmbean.XMLParseException;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

//Client ID
//6vURfrQzt4AT0WX0nJc9

//Secret key
//8Mf7WTOGQY //환경변수로 바꿔놓기-- 절대 노출 금지

//검색 : 요청 URL (XML 방식)
//	https://openapi.naver.com/v1/search/news.xml

//	?query={검색어}
//	&display={한번에 표시할 검색 갯수}
//	&start={검색 시작 위치 (1~100) default : 1}
//	&sort=sim HTTP/1.1

//인터넷 주소 체계

//https://search.naver.com/search.naver
//	https:// => 통신 프로토콜 규약
//	serch.naver.com => 컴퓨터의 주소(웹사이트)
//	search.naver => 폴더명/파일명/.... 이런식으로 하위 서비스(?) 디렉토리

//?ssc=tab.news.all&where=news&sm=tab_jum&query=%ED%95%9C%ED%99%94%EC%9D%B4%EA%B8%80%EC%8A%A4
//	?변수명=값&변수명=값&변수명=값&... : 서버에 요청할 파라미터, 클라이언트가 서버에 공개적(!)으로 요청할 정보를 담고있음

//	주소에 한글이나 특수문자 사용은 원칙적으로 쓸 수 없음 / 그래서 자동적으로 URL 인코딩을 사용 

// 검색어를 하나 콘솔에 입력
//	그 때 나오는 뉴스의 결과를 하나의 String에 담아서 출력

public class NaverNewsMain {
	
	public static void main(String[] args) {
		
		
		try {
			
			Scanner sc= new Scanner(System.in);
			
			System.out.println("검색어를 입력해주세요.");
			String search=sc.next();
			System.out.println(search);
			
			//인코딩 방식!!! 중요!!!
			search = URLEncoder.encode(search,"UTF-8");
			System.out.println(search);
			
			String address = "https://openapi.naver.com/v1/search/news.xml"
							+"?query="+search
							+"&display=10"
							+"&start=1";
							//얘네를 추가해야 인증이 가능//HttpsURLConnection 활용 (헤더 추가용으로 쓸 예정)
//							+"X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}"
//							+"X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}";
			
			
			
//			//헤더 추가하는 코드 라인, 서버 내부로 데이터를 전송할 때 사용(보안 유지하면서 전송)
//			URL u = new URL(address);
//			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
//			huc.addRequestProperty("X-Naver-Client-Id", "6vURfrQzt4AT0WX0nJc9");
//			huc.addRequestProperty("X-Naver-Client-Secret", "8Mf7WTOGQY");
//			
//			//InputStream 이해 잘 안되니 복습할 때 잘 보기
//			InputStream is = huc.getInputStream();
//			String result = HttpClient.convert(is, "UTF-8");
//			System.out.println(result);
			
			/////새로 추가한 기능으로 다시 구현
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("X-Naver-Client-Id", "6vURfrQzt4AT0WX0nJc9");
			headers.put("X-Naver-Client-Secret", "8Mf7WTOGQY");
			InputStream is = HttpClient.download(address, headers);
//			String result = HttpClient.convert(is, "UTF-8");
//			System.out.println(result);
			
			//뉴스의 제목(title)과 내용(description)을 파싱
			//Naver Open API - news 이거 안나오게
			//내용 : Naver Search Result 안나오게
			
		
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is,"UTF-8");
			
			int type = xpp.getEventType();
			String tagName = null;
			boolean data = false;
			//나오는 텍스트들 변수 하나에 담기(html 문법 거르기용)
			String t =null;
			
			while(type !=XmlPullParser.END_DOCUMENT) {
				
				if(type == XmlPullParser.START_TAG) {
					
					tagName = xpp.getName();
					if(tagName.equals("item") ){
						data = true;
					}
						
					} else if (type == XmlPullParser.TEXT) {
						if(data) {
					
							if(tagName.equals("title")) {
								t=xpp.getText();
								t=t.replace("<b>","");
								t=t.replace("</b>","");
								t=t.replace("&quot","");
								t=t.replace("&apos","");
								t=t.replace("&amp","");
								System.out.printf("제목 : %s\n",t);	
							}
							else if (tagName.equals("description")) {
								t=xpp.getText();
								t=t.replace("<b>","");
								t=t.replace("</b>","");
								t=t.replace("&quot","");
								t=t.replace("&apos","");
								t=t.replace("&amp","");
								System.out.printf("내용 : %s\n",t);
								System.out.println("=----------------------");
							}
						}
				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();
				type = xpp.getEventType();
			}
					
					
					
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}//end of main
}

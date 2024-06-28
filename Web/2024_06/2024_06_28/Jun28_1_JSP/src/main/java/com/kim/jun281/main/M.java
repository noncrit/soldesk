package com.kim.jun281.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class M {
	
/*
값
parameter(a, b)
attribute(c)

-parameter
GET : 주소에(컨트롤러?파라미터명=값&파라미터명=값&.....)
POST: 내부 전달 방식(주소에 데이터가 드러나지 않음), 그래서 인코딩 방식까지 맞춰줘야함
View 쪽에서 만들어낸 값들
자료형 - String, String[]
request 소속

값 읽기
Java : request.getParameter("파라미터명");
JSP(EL) : ${param.파라미터명}

-attribute =>request 소속의 객체
M에서 만들어낸 값
자료형은 Object, request 객체 소속

값 읽기
Java : request.getAttribute("어트리뷰트명");
JSP(EL) : ${어트리뷰트명}


--------------
3번째 컨트롤러 쪽에서 새로운 요청이 일어나는 경우 => ThirdC까지 객체가 전달이 불가능함
Third까지 살아서 값을 보낼 수 있는 방법이 필요함
=>Session

--------------
HTTP 프로토콜의 특성이자 약점
Connectionless
사용자가 요청을 한 후에 응답을 받았을 때 연결이 끊기는 특징

Stateless
통신이 끝나면 state를 유지하지 않고 끊어버림

이 약점을 보완하기 위한 수단들 : Cookie, Session
------------------
Cookie
사용자의 상태 정보를 컴퓨터에 저장을 했다가 나중에 참조
사용자가 따로 요청을 하지 않아도 브라우저가 요청을 하면 자동으로 서버측에 전송함
한 번 유지시간을 정해놓으면 브라우저의 종료 여부와는 상관없이 쿠키값을 유지 할 수 있음(유지시간 동안은 값이 살아있음)
=>마지막 로그인 ID 저장하기, 장바구니, 팝업창 ...
Model에서 만들어낸 값
자료형은 String
기본 유지시간은 24시간
사용자 컴퓨터에 저장됨 - 암호화된다고는 하지만 내 컴퓨터에 직접 접근해서 저장하는식이라 위험함
노출되면 위험한 정보는 절대 쿠키에 저장하면 안된다.

값 읽기
Java: 현재 사용자 컴퓨터에 만들어져있는 모든 쿠키들에 접근, 그 중에 프로젝트에서 선언한 e 쿠키를 찾아왔음
JSP(EL)	: ${cookie.이름.value }
---------------------
Session
쿠키를 기반으로 동작, 하지만 사용자의 정보를 Server에서 관리함
접속시간 설정 가능, 일정 시간동안 응답이 없으면 해당 정보를 삭제
쿠키보다는 보안성이 좋음, 대신 메모리 사용량이 큼(쿠키보다는)
동접자 수가 많으면 => 메모리 사용량이 많아짐=> 서버 과부하 => 성능 저하

session은 session 소속의 attribute
Model에서 만들어낸 값
자료형 Object
Session에 연결만 되어있으면 어디서든지 사용 가능함
유지시간 : 기본 30분, 설정 가능
유지 시간동안 아무 요청도 안하면 자동으로 끊김
----------------------
Cookie : 정해놓은 시간이 만료되거나, 쿠키를 삭제하기 전 까지는 유지됨
Session: 만료되는 시간을 지정할 수는 있지만, 어쨌거나 브라우저가 종료되면 바로 삭제됨
*/
	
	public void makeSecondDate(HttpServletRequest request,HttpServletResponse response) {
		int c = 3000; //java class에서 만들어낸 값 - attribute
		request.setAttribute("cc", c);
		
		//추가 내용
		int d = 40000;
		HttpSession hs = request.getSession(); //사용자와 서버간의 연결 상태
		hs.setMaxInactiveInterval(15);	//단위 : second, 유지 시간 설정
		hs.setAttribute("d", d);	//Session 소속의 어트리뷰트로 d를 지정
		
		//쿠키 : 사용자 컴퓨터에 파일을 저장
		String e = "50000";
		Cookie ck=new Cookie("e",e);
		ck.setMaxAge(15); //쿠키 파일 유지 시간=>15초 지나면 자동 삭제
		response.addCookie(ck);	//응답 객체에 쿠키 추가
		

		
	}
	
	public void printSecondDataNew(HttpServletRequest request) {
		
		try {
			HttpSession hs = request.getSession();
			int d =(Integer) hs.getAttribute("d");
			System.out.println("세션값: "+d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//이 프로젝트, naver, daum, youtube 등등
		//현재 컴퓨터에 저장되어있는 쿠키들도 있음 => 그래서 배열로 선언
		Cookie[] cks=request.getCookies();
		for (Cookie ck : cks) {
			if(ck.getName().equals("e")) {
				System.out.println(ck.getValue());
			}
		}
	}
	
	public void printSecondData(HttpServletRequest request) {
		int a= Integer.parseInt(request.getParameter("a"));
		int b= Integer.parseInt(request.getParameter("b"));
		int c = (Integer) request.getAttribute("cc");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
	}
}

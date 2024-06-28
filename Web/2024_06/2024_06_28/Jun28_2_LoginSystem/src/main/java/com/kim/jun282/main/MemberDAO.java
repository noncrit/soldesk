package com.kim.jun282.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {
	
	// 페이지를 여기저기 다닐텐데, 그때마다 로그인이 되어있는지 확인이 되야함
	public static boolean loginCheck(HttpServletRequest request) {
		
		Member m = (Member) request.getSession().getAttribute("m");
		//로그인이 유지중이거나 로그인에 성공했으면 위의 줄의 attribute가 있을것
		return (m!=null);
	}
	
	//로그인 기능
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			//로그인 성공한 유저 정보
			//사이트에 어디서든지 사용 가능하게
			//일정 시간이 지나면 로그인 상태 해제
			//session 소속의 attribute 또는 cookie 이용
			//cookie는 위험!!!
			
			if(id.equals("헬프") && pw.equals("me")) {
				Member m = new Member(id,pw);
				req.getSession().setAttribute("m", m);
				req.getSession().setMaxInactiveInterval(10);
			}
			
			//한번 로그인에 성공했으면 다음에 이 사이트에 들어왔을 때, <input>에 id 값이 남아있도록 구현
			//접속을 끊어도, 재부팅해도 정보가 남아있도록 => Cookie
			
			Cookie c = new Cookie("lastLoginId",id);
			c.setMaxAge(600);
			res.addCookie(c);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}

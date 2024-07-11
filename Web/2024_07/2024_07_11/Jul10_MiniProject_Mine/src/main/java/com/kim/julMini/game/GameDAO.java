package com.kim.julMini.game;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.julMini.user.User;

@Service
public class GameDAO {
	
	@Autowired
	private SqlSession ss;
	
	public String getData(HttpServletRequest req) {
		
		try {
			URL u = new URL("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4122063000");
			
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			
			InputStream is = huc.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			
			StringBuffer sb = new StringBuffer();
			
			String line = null;
			
			while((line=br.readLine())!=null) {
				sb.append(line);
			}
			
			return sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
		
	}
	
	public List<User> userResult(User u, HttpServletRequest req) {
		//user_code 세터로 넣지도 않고 그냥 오토매핑으로 처리한거야...?
		List<User> user = ss.getMapper(GameMapper.class).getUserResult(u);
		return user;
		
	}
	
	public List<User> isUser(HttpServletRequest req) {
		try {
			int user_code_in = Integer.parseInt(req.getParameter("user_code"));
			BigDecimal user_code = BigDecimal.valueOf(user_code_in);
			User u = User.getUser();
			
			System.out.println(user_code);
			
			u.setUser_code(user_code);
			
			List<User> user = ss.getMapper(GameMapper.class).getUserResult(u);
			
			System.out.println("로그인  성공");
			
			return user;
			
		} catch (Exception e) {
			System.out.println("로그인  실패");
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void gameResult(HttpServletRequest req) {
		
		try {
			int win = Integer.parseInt(req.getParameter("win"));
			int lose = Integer.parseInt(req.getParameter("lose"));
			int user_code_in = Integer.parseInt(req.getParameter("user_code"));
			BigDecimal user_code = BigDecimal.valueOf(user_code_in);
			
			User u = User.getUser();
			
			u.setUser_code(user_code);
			
			if (win==1) {
				u.plusWin();
			} else {
				System.out.println("lose:" + lose);
				u.plusLose();
			}
			
			req.setAttribute("user", u);
			
			int i = ss.getMapper(GameMapper.class).updateUserRecord(u);
			
			if(i==1) {
				System.out.println("업데이트 성공");
			}
			else {
				System.out.println("업데이트 실패");
			}
			
		} catch (Exception e) {
			System.out.println("game result Exception");
			e.printStackTrace();
		}
		
	}
	

	
	public void regUser(HttpServletRequest req) {
		
		try {
			int user_code_in = Integer.parseInt(req.getParameter("user_code"));
			BigDecimal user_code = BigDecimal.valueOf(user_code_in);
			
			String name = req.getParameter("name");
			
			User u = User.getUser();
			
			u.setUser_code(user_code);
			u.setName(name);
			u.setWin(BigDecimal.valueOf(0));
			u.setLose(BigDecimal.valueOf(0));
			u.setTotal_play(BigDecimal.valueOf(0));
			
			//객체에 SQL 문에서 필요한 변수들을 담아서 보내는 형태 - 객체의 변수명과 SQL측에서 사용 할 변수명이 같아야 유효
			int result = ss.getMapper(GameMapper.class).regUser(u);
			
			if(result==1) {
				System.out.println("등록 성공");
			}
			else {
				System.out.println("등록 실패");
			}
		} catch (Exception e) {
			System.out.println("등록 실패, Exception");
			e.printStackTrace();
		}
	}
	
}

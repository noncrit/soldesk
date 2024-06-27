package com.kim.jun261.Apple;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.kim.db.manager.KimDBManager;

public class AppleReg {
	
	public AppleReg() {
		
	}
	
	public void AppleReg(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int dataCount=0;
			
		try {
			
			con=KimDBManager.connect("ksjPool");
			
			String origin=request.getParameter("a_ORIGIN");
			String color=request.getParameter("a_COLOR");
			String taste=request.getParameter("a_TASTE");
			int price=Integer.parseInt(request.getParameter("a_PRICE"));
			
			//textArea에서 엔터친거: \r\n
			//웹페이지에서 엔터친거 : <br>
			
			String introduce=request.getParameter("a_INTRODUCE").replace("\r\n", "<br>");
			
			String sql = "insert into JUN26_APPLE "
					+"values(?, ?, ?, ?, ?)";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, origin);
			pstmt.setString(2, color);
			pstmt.setString(3, taste);
			pstmt.setInt(4, price);
			pstmt.setString(5, introduce);
			
			dataCount=pstmt.executeUpdate();
			
			//C U D :executeUpdate()로 실행 -> 영향받은 데이터의 갯수가 리턴됨
			//R : executeQuery()로 실행 -> Select의 결과가 Result Set의 형태로 반환됨
			
			if(dataCount == 1) {
				System.out.println("데이터 입력 성공");
				request.setAttribute("regResult", "[등록 성공]");
			}
			else {
				System.out.println("실패");
				request.setAttribute("regResult", "[등록 실패]");
			}
			
			
		} catch (Exception e) {
			System.out.println("실패");
			request.setAttribute("regResult", "[등록 실패]");
			e.printStackTrace();
		}
		
		finally {
			KimDBManager.close(con, pstmt, null);
		}
		
	}

}

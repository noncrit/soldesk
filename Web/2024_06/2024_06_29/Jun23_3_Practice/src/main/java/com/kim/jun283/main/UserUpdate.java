package com.kim.jun283.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import com.kim.jun283.db.KimDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UserUpdate {
	
	public UserUpdate() {
		// TODO Auto-generated constructor stub
	}
	
		public boolean UpdateUserDetail(HttpServletRequest request,MultipartRequest mr) {
		
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			con=KimDBManager.connect("ksjPool");
			
			
			String j_ID=mr.getParameter("j_ID");
			String j_PW=mr.getParameter("j_PW");
			String j_PWC=mr.getParameter("j_PWC");
			String j_NAME=mr.getParameter("j_NAME");
			String j_PN=mr.getParameter("j_PN");
			String j_BIRTH=mr.getParameter("j_BIRTH");
			String j_IMG=mr.getFilesystemName("j_IMG");
			
			System.out.println("Update파트 데이터 확인");
			System.out.println(j_ID);
			System.out.println(j_PW);
			System.out.println(j_IMG);
			
				if(pwdcheck(j_PW, j_PWC)) {
					String sql=
					"UPDATE JUN28_LOGIN "
					+ "SET j_PW=?, j_NAME=?, j_PN=?, j_BIRTH=?, j_IMG=? "
					+ "WHERE j_ID=?";
					
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, j_PW);
					pstmt.setString(2, j_NAME);
					pstmt.setString(3, j_PN);
					pstmt.setString(4, j_BIRTH);
					pstmt.setString(5, j_IMG);
					pstmt.setString(6, j_ID);
					
					if(pstmt.executeUpdate()==1) {
						request.setAttribute("r", "[업데이트 성공]");
						return true;
					}
					else {
						request.setAttribute("r", "[업데이트 실패]");
						return false;
					}//end of inner if/else
					
				}//end of outer if
				
				//else for outer if
				else {
					System.out.println("패스워드 체크 실패");
					return false;
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("유저 정보 업데이트 실패(error at catch)");
			
		}//end of catch
		
		finally {
			KimDBManager.close(con, pstmt, null);
		}
		System.out.println("Update : 마지막 false에 걸림");
		return false;
		
	}//end of method UpdateUserDetail
		
	public boolean pwdcheck(String pw, String pwc) {
		System.out.println("-----");
		System.out.println("pwdcheck");
		System.out.println(pw+" and " + pwc);
			
		if(pwc.equals(pw)) {
			return true;
		}
		else {
			return false;
		}
	}
}

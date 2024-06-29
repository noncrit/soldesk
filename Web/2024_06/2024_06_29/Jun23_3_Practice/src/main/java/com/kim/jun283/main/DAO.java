package com.kim.jun283.main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.jun283.db.KimDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAO {
	
	private int allAccountNum;
	private static final DAO DAO = new DAO();
	
	public static DAO getDAO() {
		return DAO;
	}
	
	public boolean loginCheck(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("LoginedUser");
		//로그인이 유지중이거나 로그인에 성공했으면 위의 줄의 attribute가 있을것
		return (user!=null);
	}
	
	public void getAllAccountNum(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			
			con=KimDBManager.connect("ksjPool");
			String sql="SELECT * FROM JUN28_LOGIN";
			
			while(rs.next()) {
				allAccountNum++;
			}
			request.setAttribute("allAccountNum", allAccountNum);
					
		} catch (Exception e) {
			System.out.println("모든 계정 숫자 카운트 실패");
			e.printStackTrace();
		}
		
		
	}
	
	public boolean register(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			String path=request.getServletContext().getRealPath("img");
			System.out.println(path); // 절대 경로의 위치
			
			//파일 업로드(원래의 request 객체를 덮어씀 + 저장 경로 지정)
			MultipartRequest mr = new MultipartRequest(
										request, path,
										//파일 업로드시 허용할 최대크기(byte단위)(10 MB)
										10 * 1024 * 1024,
										//request 파라미터의 인코딩 방식
										"UTF-8",
										//업로드한 파일 이름 중복시 파일이름 변경 루틴 지정
										//중복시에 파일명 뒤에 숫자를 붙이는 방식
										new DefaultFileRenamePolicy()
										);
			
//			String fileName = mr.getFilesystemName("j_IMG");
//			fileName = URLEncoder.encode(fileName,"UTF-8");
//			fileName = fileName.replace("+", " ");
			
			
			con=KimDBManager.connect("ksjPool");
			
			String j_ID=mr.getParameter("j_ID");
			String j_PW=mr.getParameter("j_PW");
			String j_PWC=mr.getParameter("j_PWC");
			String j_PN=mr.getParameter("j_PN");
			String j_NAME=mr.getParameter("j_NAME");
			String j_BIRTH=mr.getParameter("j_BIRTH");
			String j_IMG=mr.getFilesystemName("j_IMG");
//			request.setAttribute("fileName", j_IMG);
			
			System.out.println("DAO-register");
			System.out.println(j_ID);
			System.out.println(j_PW);
			System.out.println(j_PWC);
			System.out.println(j_NAME);
			System.out.println(j_PN);
			System.out.println(j_BIRTH);
			System.out.println(j_IMG);
			System.out.println("------------");
			
			if(pwdcheck(j_PW, j_PWC)) {
				
				String sql="INSERT INTO JUN28_LOGIN VALUES(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, j_ID);
				pstmt.setString(2, j_PW);
				pstmt.setString(3, j_PN);
				pstmt.setString(4, j_NAME);
				pstmt.setString(5, j_BIRTH);
				pstmt.setString(6, j_IMG);
				
				if(pstmt.executeUpdate()==1) {
					System.out.println("회원 가입 성공");
					return true;
				}
				else {
					System.out.println("회원 가입 실패");
					return false;
				}
				
			}
			else {
				System.out.println("pwdcheck fail");
				return false;
			}
		
			
		}
		 catch (Exception e) {
			System.out.println("회원가입 실패");
			e.printStackTrace();
		 }
		finally {
			KimDBManager.close(con, pstmt, null);
		}
		
		return false;	
		
	}
	
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
	
	public boolean login(HttpServletRequest request, HttpServletResponse response) {
		
		
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			request.setCharacterEncoding("UTF-8");
			con=KimDBManager.connect("ksjPool");
	
			
			
			String input_id=request.getParameter("j_ID");
			String input_pw=request.getParameter("j_PW");
			
			String sql_id=null;
			String sql_pw=null;
			String sql_img=null;
			
			String sql="SELECT J_ID,J_PW,J_IMG FROM JUN28_LOGIN WHERE J_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, input_id);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()){
				sql_id=rs.getString("J_ID");
				sql_pw=rs.getString("J_PW");
				sql_img=rs.getString("J_IMG");
			}
			System.out.println("input_id : "+input_id);
			System.out.println("sql_id : "+sql_id);
			System.out.println("input_pw : "+input_pw);
			System.out.println("input_id : "+sql_pw);
			System.out.println("J_IMG : "+sql_img);
			
			
			if(input_id.equals(sql_id)&&input_pw.equals(sql_pw)) {
				User LoginedUser = new User(sql_id,sql_pw,sql_img);
				request.getSession().setAttribute("LoginedUser",LoginedUser);
				request.getSession().setAttribute("LoginedUser_id", LoginedUser.getJ_ID());
				request.getSession().setAttribute("LoginedUser_pw", LoginedUser.getJ_PW());
				request.getSession().setAttribute("LoginedUser_img", LoginedUser.getJ_IMG());
				request.getSession().setMaxInactiveInterval(60);
				return true;
			}
			else {
				return false;
			}
			

		} catch (Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		}
		System.out.println("로그인 실패");
		return false;
		
	}
	
	public boolean getUserDetail(HttpServletRequest request,MultipartRequest mr) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			
			request.setCharacterEncoding("UTF-8");
		
			con=KimDBManager.connect("ksjPool");
			
			String user_id=mr.getParameter("j_ID");
			
			String sql="SELECT * FROM JUN28_LOGIN WHERE j_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs=pstmt.executeQuery();
			
			User user =null;
			
			while(rs.next()) {
				user = new User();
				user.setJ_ID(rs.getString("j_ID"));
				user.setJ_PW(rs.getString("j_PW"));
				//user.setJ_PWC(rs.getString("j_PWC"));
				user.setJ_NAME(rs.getString("j_NAME"));
				user.setJ_PN(rs.getString("j_PN"));
				user.setJ_BIRTH(rs.getString("j_BIRTH"));
				user.setJ_IMG(rs.getString("j_IMG"));
				request.setAttribute("user", user);
				System.out.println("DAO : getUserDetail : 유저 객체 어트리뷰트화 성공");
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println("유저 세부정보 가져오기 실패");
			e.printStackTrace();
			return false;
			
		}
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
		return false;
		
	}
	
public boolean getUserDetail(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			
			request.setCharacterEncoding("UTF-8");
		
			con=KimDBManager.connect("ksjPool");
			
			String user_id=request.getParameter("j_ID");
			
			String sql="SELECT * FROM JUN28_LOGIN WHERE j_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs=pstmt.executeQuery();
			
			User user =null;
			
			while(rs.next()) {
				user = new User();
				user.setJ_ID(rs.getString("j_ID"));
				user.setJ_PW(rs.getString("j_PW"));
				//user.setJ_PWC(rs.getString("j_PWC"));
				user.setJ_NAME(rs.getString("j_NAME"));
				user.setJ_PN(rs.getString("j_PN"));
				user.setJ_BIRTH(rs.getString("j_BIRTH"));
				user.setJ_IMG(rs.getString("j_IMG"));
				request.setAttribute("user", user);
				System.out.println("DAO : getUserDetail : 유저 객체 어트리뷰트화 성공");
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println("유저 세부정보 가져오기 실패");
			e.printStackTrace();
			return false;
			
		}
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
		return false;
		
	}
	
	
	
	public void sessionClose(HttpServletRequest request) {
		request.getSession().invalidate();
	}
	
	public boolean deleteUser(HttpServletRequest request) {
		
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		try {
			request.setCharacterEncoding("UTF-8");
			con=KimDBManager.connect("ksjPool");
			
			String input_ID=request.getParameter("j_ID");
			String input_PW=request.getParameter("j_PW");
			
			String sql="SELECT J_ID,J_PW FROM JUN28_LOGIN WHERE J_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, input_ID);
			
			rs=pstmt.executeQuery();
			
			String j_PW_DB ="invalid";
			String j_ID_DB = "invalid";
			
			while(rs.next()) {
				j_PW_DB=rs.getString("J_PW");
				j_ID_DB=rs.getString("J_ID");
			}
			
			if(input_ID.equals(j_ID_DB) && input_PW.equals(j_PW_DB)) {
				String sql2 = "DELETE FROM JUN28_LOGIN WHERE J_ID=?";
				pstmt=con.prepareStatement(sql2);
				pstmt.setString(1, input_ID);
				
				if(pstmt.executeUpdate()==1) {
					System.out.println("삭제 성공");
					return true;
				}
				else {
					System.out.println("삭제 실패");
					return false;
				}
					
			}
			else {
				System.out.println("삭제 실패 - DB 데이터와 불일치");
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("삭제 실패 - Exception");
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	
	
}

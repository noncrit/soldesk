package com.kim.jun283.main;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.jun283.db.KimDBManager;

public class DAO {
	
	private int allAccountNum;
	private static final DAO DAO = new DAO();
	
	public static DAO getApple() {
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
			
			con=KimDBManager.connect("ksjPool");
			
			String j_id=request.getParameter("j_id");
			String j_pw=request.getParameter("j_pw");
			String j_pwc=request.getParameter("j_pwc");
			String j_pn=request.getParameter("j_pn");
			String j_birth=request.getParameter("j_birth");
			String j_img=request.getParameter("j_img");
			
			System.out.println("DAO-register");
			System.out.println(j_id);
			System.out.println(j_pw);
			System.out.println(j_pwc);
			System.out.println(j_pn);
			System.out.println(j_birth);
			System.out.println(j_img);
			System.out.println("------------");
			
			if(pwdcheck(j_pw, j_pwc)) {
				
				String sql="INSERT INTO JUN28_LOGIN VALUES(?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, j_id);
				pstmt.setString(2, j_pw);
				pstmt.setString(3, j_pn);
				pstmt.setString(4, j_birth);
				pstmt.setString(5, j_img);
				
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
	
	public boolean pwdcheck(String pw,String pwc) {
		
		if(pwc.equals(pwc)) {
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
			con=KimDBManager.connect("ksjPool");
			
			String input_id=request.getParameter("j_id");
			String input_pw=request.getParameter("j_pw");
			
			String sql_id=null;
			String sql_pw=null;
			
			String sql="SELECT J_ID,J_PW FROM JUN28_LOGIN WHERE J_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, input_id);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()){
				sql_id=rs.getString("J_ID");
				sql_pw=rs.getString("J_PW");
			}
			
			if(input_id.equals(sql_id)&&input_pw.equals(sql_pw)) {
				User LoginedUser = new User(sql_id,sql_pw);
				request.getSession().setAttribute("LoginedUser",LoginedUser);
				request.getSession().setAttribute("LoginedUser_id", LoginedUser.getId());
				request.getSession().setAttribute("LoginedUser_pw", LoginedUser.getPw());
				request.getSession().setMaxInactiveInterval(600);
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
}

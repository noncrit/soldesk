package com.kim.jun261.Apple;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kim.db.manager.KimDBManager;

public class AppleDAO {
	private int allAppleCount;
	
	//객체로 인한 꼬임 방지 차원에서 싱글톤 패턴으로 선언
	private static final AppleDAO APPLEDAO = new AppleDAO();
	
	public AppleDAO() {
		// TODO Auto-generated constructor stub
	}

	public static AppleDAO getApple() {
		return APPLEDAO;
	}
	
	//모든 사과의 데이터를 다 가져올 수 있게
	
	public void getApple(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con=KimDBManager.connect("ksjPool");
			
//			String sql = "SELECT * FROM JUN26_APPLE ORDER BY a_PRICE";
			
			String sql = "SELECT * "
					+ "FROM "
					+ "(SELECT ROWNUM AS RN, a_ORIGIN, a_COLOR, a_TASTE, a_PRICE, a_INTRODUCE "
					+ "FROM JUN26_APPLE "
					+ "ORDER BY a_PRICE"
					+ ") "
					+ "WHERE RN BETWEEN 1 AND 4";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//C U D :executeUpdate()로 실행 -> 영향받은 데이터의 갯수가 리턴됨
			//R : executeQuery()로 실행 -> Select의 결과가 Result Set의 형태로 반환됨
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			
			Apple apple =null;
			
			while(rs.next() ){
				apple = new Apple();
				apple.setA_ORIGIN(rs.getString("a_ORIGIN"));
				apple.setA_COLOR(rs.getString("a_COLOR"));
				apple.setA_TASTE(rs.getString("a_TASTE"));
				apple.setA_PRICE(rs.getInt("a_PRICE"));
				apple.setA_INTRODUCE(rs.getString("a_INTRODUCE"));
				apples.add(apple);
				allAppleCount++;
			}
			request.setAttribute("apples", apples);
			
			
			request.setAttribute("allAppleCount", allAppleCount);
			allAppleCount=0;
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
	
	}
	
public void getAppleCount(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con=KimDBManager.connect("ksjPool");
			
			String sql = "SELECT * FROM JUN26_APPLE";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//C U D :executeUpdate()로 실행 -> 영향받은 데이터의 갯수가 리턴됨
			//R : executeQuery()로 실행 -> Select의 결과가 Result Set의 형태로 반환됨
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			
			Apple apple =null;
			
			while(rs.next() ){
				apple = new Apple();
				apple.setA_ORIGIN(rs.getString("a_ORIGIN"));
				apple.setA_COLOR(rs.getString("a_COLOR"));
				apple.setA_TASTE(rs.getString("a_TASTE"));
				apple.setA_PRICE(rs.getInt("a_PRICE"));
				apple.setA_INTRODUCE(rs.getString("a_INTRODUCE"));
				apples.add(apple);
				allAppleCount++;
			}
			
			request.setAttribute("apples", apples);
			request.setAttribute("allAppleCountBTN", allAppleCount);
			request.setAttribute("allAppleCount", allAppleCount);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
	
	}
	
	public void showAppleBy4(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ApplePagingUserIN=Integer.parseInt((String) request.getParameter("ApplePagingUserIN"));
		
		
		try {
			con=KimDBManager.connect("ksjPool");
			
			String sql = "SELECT * "
					+ "FROM "
					+ "(SELECT ROWNUM AS RN, a_ORIGIN, a_COLOR, a_TASTE, a_PRICE, a_INTRODUCE "
					+ "FROM JUN26_APPLE "
					+ "ORDER BY a_PRICE"
					+ ") "
					+ "WHERE RN BETWEEN ? AND ?";
				
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,(ApplePagingUserIN*4)-3);
			pstmt.setInt(2,(ApplePagingUserIN*4));
			rs=pstmt.executeQuery();
			
			//C U D :executeUpdate()로 실행 -> 영향받은 데이터의 갯수가 리턴됨
			//R : executeQuery()로 실행 -> Select의 결과가 Result Set의 형태로 반환됨
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			
			Apple apple =null;
			
			while(rs.next() ){
				apple = new Apple();
				apple.setA_ORIGIN(rs.getString("a_ORIGIN"));
				apple.setA_COLOR(rs.getString("a_COLOR"));
				apple.setA_TASTE(rs.getString("a_TASTE"));
				apple.setA_PRICE(rs.getInt("a_PRICE"));
				apple.setA_INTRODUCE(rs.getString("a_INTRODUCE"));
				apples.add(apple);
				allAppleCount++;
			}
			
			request.setAttribute("apples", apples);
		
			request.setAttribute("allAppleCount", allAppleCount);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
	}
	
public void showAppleBy4(HttpServletRequest request, int i) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ApplePagingUserIN=i;
		
		
		try {
			con=KimDBManager.connect("ksjPool");
			
			String sql = "SELECT * "
					+ "FROM "
					+ "(SELECT ROWNUM AS RN, a_ORIGIN, a_COLOR, a_TASTE, a_PRICE, a_INTRODUCE "
					+ "FROM JUN26_APPLE "
					+ "ORDER BY a_PRICE"
					+ ") "
					+ "WHERE RN BETWEEN ? AND ?";
				
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,(ApplePagingUserIN*4)-3);
			pstmt.setInt(2,(ApplePagingUserIN*4));
			rs=pstmt.executeQuery();
			
			//C U D :executeUpdate()로 실행 -> 영향받은 데이터의 갯수가 리턴됨
			//R : executeQuery()로 실행 -> Select의 결과가 Result Set의 형태로 반환됨
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			
			Apple apple =null;
			
			while(rs.next() ){
				apple = new Apple();
				apple.setA_ORIGIN(rs.getString("a_ORIGIN"));
				apple.setA_COLOR(rs.getString("a_COLOR"));
				apple.setA_TASTE(rs.getString("a_TASTE"));
				apple.setA_PRICE(rs.getInt("a_PRICE"));
				apple.setA_INTRODUCE(rs.getString("a_INTRODUCE"));
				apples.add(apple);
				allAppleCount++;
			}
			
			request.setAttribute("apples", apples);
		
			request.setAttribute("allAppleCount", allAppleCount);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
	}
	
public boolean getAppleDetail(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//get방식으로 파라미터 넘어온거 받아야함!!! AppleDetail.js 에서 함수로 파라
		String a_ORIGIN=request.getParameter("a_ORIGIN");
		
		try {
			con=KimDBManager.connect("ksjPool");
			
			String sql = "SELECT * "
					+ "FROM JUN26_APPLE "
					+ "WHERE a_ORIGIN=?";
					
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a_ORIGIN);
			
			rs=pstmt.executeQuery();
			
			
			//C U D :executeUpdate()로 실행 -> 영향받은 데이터의 갯수가 리턴됨
			//R : executeQuery()로 실행 -> Select의 결과가 Result Set의 형태로 반환됨
			
			Apple apple =null;
			
			while(rs.next() ){
				apple = new Apple();
				apple.setA_ORIGIN(rs.getString("a_ORIGIN"));
				apple.setA_COLOR(rs.getString("a_COLOR"));
				apple.setA_TASTE(rs.getString("a_TASTE"));
				apple.setA_PRICE(rs.getInt("a_PRICE"));
				apple.setA_INTRODUCE(rs.getString("a_INTRODUCE"));
				request.setAttribute("apple", apple);
				return true;
			}
			
			return false;
		
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}
		
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
	}

	public boolean getAppleDetail_teacher(HttpServletRequest request) {
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			con=KimDBManager.connect("ksjPool");
			
			String a_ORIGIN=request.getParameter("a_ORIGIN");
			
			String sql = "SELECT * "
					+ "FROM JUN26_APPLE "
					+ "WHERE a_ORIGIN=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, a_ORIGIN);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Apple apple = new Apple();
				apple.setA_ORIGIN(rs.getString("a_ORIGIN"));
				apple.setA_COLOR(rs.getString("a_COLOR"));
				apple.setA_TASTE(rs.getString("a_TASTE"));
				apple.setA_PRICE(rs.getInt("a_PRICE"));
				apple.setA_INTRODUCE(rs.getString("a_INTRODUCE"));
				request.setAttribute("apple", apple);
				return true;
			}
			//데이터 없는 경우(다른 사람이 데이터 지웠거나 등등) 동기화 처리...?
			return false;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;	//DB가 메롱한 경우
		}
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
	}

	public boolean UpdateAppleDetail(HttpServletRequest request) {
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
			
		
		try {
			request.setCharacterEncoding("UTF-8");
			con=KimDBManager.connect("ksjPool");
			
			String a_ORIGIN=request.getParameter("a_ORIGIN");
			String a_COLOR=request.getParameter("a_COLOR");
			String a_TASTE=request.getParameter("a_TASTE");
			int a_PRICE=Integer.parseInt(request.getParameter("a_PRICE"));
			//textArea에서 엔터친거: \r\n
			//웹페이지에서 엔터친거 : <br>
			
			String a_INTRODUCE=request.getParameter("a_INTRODUCE").replace("\r\n", "<br>");
			
			
			String sql = "UPDATE JUN26_APPLE "
					+ "SET a_COLOR=?, a_TASTE=?, a_PRICE=?, a_INTRODUCE=? "
					+ "WHERE a_ORIGIN=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, a_COLOR);
			pstmt.setString(2, a_TASTE);
			pstmt.setInt(3, a_PRICE);
			pstmt.setString(4, a_INTRODUCE);
			pstmt.setString(5, a_ORIGIN);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[수정 성공]");
				return true;
			}
			else {
				request.setAttribute("r", "[수정 실패]");
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();	//DB가 메롱한 경우
		}
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		return false;
		
	}
	
	public void delete(HttpServletRequest request) {
		Connection con =null;
		PreparedStatement pstmt=null;
		
		try {
			con=KimDBManager.connect("ksjPool");
			
			String a_ORIGIN=request.getParameter("a_ORIGIN");
			String sql="DELETE FROM JUN26_APPLE WHERE a_ORIGIN=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, a_ORIGIN);
			
			//삭제(영향받은 데이터 수 1개 여야함)
			if(pstmt.executeUpdate()==1) {
				request.setAttribute("r", "[삭제 성공]");
				allAppleCount--;
				request.setAttribute("allAppleCount", allAppleCount);
			}
			else {
				request.setAttribute("r", "[삭제 실패]");
			}
			
			
		} catch (Exception e) {
			request.setAttribute("r", "[삭제 실패]");
			e.printStackTrace();
		}
		
		finally {
			KimDBManager.close(con, pstmt, null);
		}
		
	}
	
	
}

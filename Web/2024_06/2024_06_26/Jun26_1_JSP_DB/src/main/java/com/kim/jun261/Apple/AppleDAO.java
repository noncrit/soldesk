package com.kim.jun261.Apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kim.db.manager.KimDBManager;

public class AppleDAO {
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
			
			String sql = "SELECT * FROM JUN26_APPLE ORDER BY a_PRICE";
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
			}
			request.setAttribute("apples", apples);

			
			/*
			 * String ORIGIN=null; String COLOR=null; String TASTE=null; int PRICE=0; String
			 * INTRODUCE=null;
			 * 
			 * int counter=0;
			 * 
			 * while(rs.next()) { //rs.getXXX("DB컬럼명") : 현재 위치의 컬럼 읽기 //rs.getXXX(인덱스) : 비추!
			 * ORIGIN=rs.getString("ORIGIN"); request.setAttribute("ORIGIN"+counter,
			 * ORIGIN);
			 * 
			 * COLOR=rs.getString("COLOR"); request.setAttribute("COLOR"+counter, COLOR);
			 * 
			 * TASTE=rs.getString("TASTE"); request.setAttribute("TASTE"+counter, TASTE);
			 * 
			 * PRICE=rs.getInt("PRICE"); request.setAttribute("PRICE"+counter, PRICE);
			 * 
			 * INTRODUCE=rs.getString("INTRODUCE");
			 * request.setAttribute("INTRODUCE"+counter, INTRODUCE);
			 * 
			 * counter++; } System.out.println("total count : "+counter);
			 * request.setAttribute("counter", counter);
			 * 
			 * counter=0;
			 */
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
//		try {
//			rs.close();	//close 제대로 해줘야함!!
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			pstmt.close();	//close 제대로 해줘야함!!
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			con.close();	//close 제대로 해줘야함!!
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
	
	}
	
	
	
}

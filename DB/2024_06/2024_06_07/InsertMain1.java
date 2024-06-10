package com.kim.jun062.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMain1 {
	public static void main(String[] args) {
		
		//SQL문 사용해서 DB로 전송/ 결과 받아오기
		
		Connection con = null;
		
		try {
			//연결할 DB 서버 주소
			String addr = "jdbc:oracle:thin:@192.168.0.15:1521:xe";
			con = DriverManager.getConnection(addr,"jin","asd321");
//			System.out.println("Succeed!");
			
			//주의할점 2가지
			//1. 띄어쓰기
			String sql = "insert into jun07_product "
						+"values(jun07_product_seq.nextval, "
						+"'테스트', 10, 10,3)";
			
			//서버에 전송/실행/결과 받아오는 작업을 하는 총괄 매니저
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(); //서버에 전송/실행/결과받기
			
			pstmt.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			con.close();	//close 제대로 해줘야함!!
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
}	

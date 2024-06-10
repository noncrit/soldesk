package com.kim.jun062.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//JDBC(java Databse Connectivity) - 자바에서 DB 프로그래밍을 하기 위한 API
//ojdbc8.jar 사용

public class ConnectionMain {
	public static void main(String[] args) {
		
	
		Connection con = null;
	
		try {
			//연결할 DB 서버 주소
			String addr = "jdbc:oracle:thin:@192.168.0.15:1521:xe";
			con = DriverManager.getConnection(addr,"jin","asd321");
			System.out.println("Succeed!");
		
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

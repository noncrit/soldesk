package com.kim.jun062.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteMain {
	
	public static void main(String[] args) {
		//상품명 입력 => 입력한 내용을 포함하는 상품명의 정보 삭제
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			String addr = "jdbc:oracle:thin:@192.168.0.15:1521:xe";
			con = DriverManager.getConnection(addr,"jin","asd321");
			
			Scanner k = new Scanner(System.in);
			System.out.print("상품명: ");
			String name = k.next();
			
			String sql = "delete from jun07_proudct "
						+"where p_name like '%'||?||'%'";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			if(pstmt.executeUpdate()>=1) {
				System.out.println("성공!!");
			}
			else {
				System.out.println("그런 상품 없다");
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end of main
}

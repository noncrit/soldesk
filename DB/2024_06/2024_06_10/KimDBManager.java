package com.kim.db.last;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KimDBManager {
	
	public static Connection connect() throws SQLException {
		String addr = "jdbc:oracle:thin:@192.168.0.15:1521:xe";
		return DriverManager.getConnection(addr,"jin","asd321");	
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs ) {
		
		try {	
			rs.close();	//c,u,d에는 필요없고 r 때만 필요
		} catch (Exception e) {	//insert 하게 되면 NullpointerException 발생
//			e.printStackTrace();
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
		
	}
}

package com.kim.jun283.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class KimDBManager {
	
	public static Connection connect(String PoolName) throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+PoolName);
		//java:comp/env/ : context.xml의 경로
		
		return ds.getConnection();
		
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();	
		} catch (Exception e) {
		}
		
		try {
			pstmt.close();
		} catch (Exception e) {
		}
		
		
		try {
			con.close();
		} catch (Exception e) {	
		}
		
	}
}


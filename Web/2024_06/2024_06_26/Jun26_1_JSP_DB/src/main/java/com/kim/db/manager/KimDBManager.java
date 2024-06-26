package com.kim.db.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//기존 JDBC 프로그램 구현 => DBMS와 연동하는 작업
//클라이언트로부터 요청이 있을 때 마다 DB서버와 연결하기 위해서
//Connection 객체를 얻어내야 했음
//단점
//Connection 과정은 일정 시간이 드는 작업
//불필요한 연결에 의한 서버 자원 낭비 가능성

//이 단점들을 보완하고자 나온게 DBCP(DataBase Connection Pool)
//여러 개의 DB Connection을 하나의 Pool이라는 곳에 모아놓고 관리
//필요할 때 마다 Pool에서 호출해서 사용
//만약 사용 가능한 Connection이 없다면? 
//=>Connection 객체가 반환될 때까지 클라이언트는 대기
//사용이 끝난 Connection 객체는 다시 Pool로 반환

//InitialContext() : 이름이 있는 객체를 찾을 때 사용하는 객체
//DataSource : 커넥션 풀의 Connection을 관리하기 위한 객체
//lookup 메소드를 통해 관리, Connection 객체를 가져올 수 있음

//JNDI(Java Naming and Directory Interface)
//Java 기반의 API로 어떤 파일/프로그램에 이름 지정 및 디렉토리 지정이 가능함
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

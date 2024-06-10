package com.kim.db.last;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
//MVC 패턴 준수!!
//JDBC에서는 java.sql.Date 사용해야함
public class DAO {
	
//		 * 1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)
		public static String book(Reservation rsv) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				//나중에 KimDBManager 완성하고 실행
				con = KimDBManager.connect(); 
				
				String sql = "insert into jun10_reservation "
							+"values(jun10_reservation_seq.nextval, ?, ?, ?, ?)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, rsv.getName());
				//JDBC에서는 java.sql.Date 사용해야함 - 변환
				pstmt.setDate(2, new Date(rsv.getWhen().getTime()));
				pstmt.setString(3, rsv.getPhone());
				pstmt.setString(4, rsv.getLocation());
				
				if(pstmt.executeUpdate() == 1) {
					return "예약에 성공했습니다";
				}
				//끝부분에도 리턴이 필요함(문법상 필요함...)
				return "";
				
			} catch (Exception e) {
				e.printStackTrace();
				return "예약 실패";
			}
			finally {
				KimDBManager.close(con, pstmt, null);
			}
			
			
		}
		
//		 * 2. 매장등록(지점명, 지점장, 좌석수)
		public static String registerRst(Restaurant rst) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				//나중에 KimDBManager 완성하고 실행
				con = KimDBManager.connect(); 
				
				String sql = "insert into jun10_restaurant "
							+"values(?, ?, ?)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, rst.getLocation());
				pstmt.setString(2, rst.getOwner());
				pstmt.setInt(3, rst.getSeat());
					
				if(pstmt.executeUpdate() == 1) {
					return "등록에 성공했습니다";
				}
				//끝부분에도 리턴이 필요함(문법상 필요함...)
				return "";
				
			} catch (Exception e) {
				e.printStackTrace();
				return "등록 실패";
			}
			finally {
				KimDBManager.close(con, pstmt, null);
			}
			
		}
//		 * 3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분)/예약번호 오름차순 정렬
		public static ArrayList<Reservation> getAllReserve() {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			//쿼리 결과를 담을 때 사용할 ResultSet
			ResultSet rs = null;
			
			try {
				//나중에 KimDBManager 완성하고 실행
				con = KimDBManager.connect(); 
				
				String sql = "select * from jun10_reservation "
							+"order by rsv_num";
				//sql 문 수행
				pstmt = con.prepareStatement(sql);
				
				//Sql Query 결과 저장
				rs = pstmt.executeQuery();
				
				Reservation r = null;
				ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
				while(rs.next()){
					//출력을 여기서 하면 파일 역할을 나눠놓은 이유가 없음
					r= new Reservation();
					r.setNo(rs.getInt("rsv_num"));
					r.setName(rs.getString("rsv_name"));
					r.setWhen(rs.getDate("rsv_when"));
					r.setPhone(rs.getString("rsv_phoneNum"));
					r.setLocation(rs.getString("rsv_location"));
					rsvs.add(r);
				}
				
				//근데 이 전체 데이터를 넘겨줘야함
				return rsvs;
				
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				KimDBManager.close(con, pstmt, rs);
			}
			
		}
		
//		 * 4. 전체 매장 조회(지점명 기준 오름차순) (위치(좌석 수) - 사장님 이름의 형식)
		public static ArrayList<Restaurant> getAllRestaurant() {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			//쿼리 결과를 담을 때 사용할 ResultSet
			ResultSet rs = null;
			
			try {
				//나중에 KimDBManager 완성하고 실행
				con = KimDBManager.connect(); 
				
				String sql = "select * from jun10_restaurant order by rst_location";
							
				//sql 문 수행
				pstmt = con.prepareStatement(sql);
				
				//Sql Query 결과 저장
				rs = pstmt.executeQuery();
				
				Restaurant r = null;
				ArrayList<Restaurant> rsvs = new ArrayList<Restaurant>();
				while(rs.next()){
					//출력을 여기서 하면 파일 역할을 나눠놓은 이유가 없음
					r= new Restaurant();
					r.setLocation(rs.getString("rst_location"));
					r.setOwner(rs.getString("rst_owner"));
					r.setSeat(rs.getInt("rst_seat"));
					rsvs.add(r);
				}
				
				//근데 이 전체 데이터를 넘겨줘야함
				return rsvs;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				KimDBManager.close(con, pstmt, rs);
			}
			
		}
//		 * 5. 매장 찾기(최소 좌석 수 입력) => 좌석 수 이상의 매장의 정보를 출력
		public static ArrayList<Restaurant> searchRstBySeat(int inputSeat){
			
			Connection con = null;
			PreparedStatement pstmt = null;
			//쿼리 결과를 담을 때 사용할 ResultSet
			ResultSet rs = null;
			
			try {
				//나중에 KimDBManager 완성하고 실행
				con = KimDBManager.connect(); 
				
	
				String sql = "select * from jun10_restaurant where rst_seat>=?";
				
				//sql 문 수행
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, inputSeat);
				
				//Sql Query 결과 저장
				rs = pstmt.executeQuery();
				
				Restaurant r = null;
				ArrayList<Restaurant> rsvs = new ArrayList<Restaurant>();
//				while(rs.next()){
//					//출력을 여기서 하면 파일 역할을 나눠놓은 이유가 없음
//					r= new Restaurant();
//					r.setLocation(rs.getString("rst_location"));
//					r.setOwner(rs.getString("rst_owner"));
//					r.setSeat(rs.getInt("rst_seat"));
//					rsvs.add(r);
//				}
				//좀 더 짧게?
				while(rs.next()) {
					rsvs.add(new Restaurant(rs.getString("rst_location"),
						rs.getString("rst_owner"), rs.getInt("rst_seat")
						)
							);
				}
				
				//근데 이 전체 데이터를 넘겨줘야함
				return rsvs;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				KimDBManager.close(con, pstmt, rs);
			}
			
		}
		
//		 * 6. 예약 찾기(예약자 이름)(예약번호로 오름차순 정렬)
		public static ArrayList<Reservation> searchRsvBytRsvName(String input_name){
			
			Connection con = null;
			PreparedStatement pstmt = null;
			//쿼리 결과를 담을 때 사용할 ResultSet
			ResultSet rs = null;
			
			try {
				//나중에 KimDBManager 완성하고 실행
				con = KimDBManager.connect(); 
				
				String sql = "select * from jun10_reservation where rsv_name like '%'||?||'%' "
							+"order by rsv_num asc";
				
				//sql 문 수행
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, input_name);
				
				//Sql Query 결과 저장
				rs = pstmt.executeQuery();
				
				Reservation r = null;
				ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
				while(rs.next()){
					//출력을 여기서 하면 파일 역할을 나눠놓은 이유가 없음
					r= new Reservation();
					r.setNo(rs.getInt("rsv_num"));
					r.setName(rs.getString("rsv_name"));
					r.setWhen(rs.getDate("rsv_when"));
					r.setPhone(rs.getString("rsv_phoneNum"));
					r.setLocation(rs.getString("rsv_location"));
					rsvs.add(r);
				}			
				//근데 이 전체 데이터를 넘겨줘야함
				return rsvs;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				KimDBManager.close(con, pstmt, rs);
			}
			
		}
		
//		 * 7. 예약 정보 수정(예약번호를 입력하면, 연락처를 변경)
		public static String updateReserve(Reservation rsv) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = KimDBManager.connect();
				String sql = "update jun10_reservation set rsv_phoneNum = ? where rsv_num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, rsv.getPhone());
				pstmt.setInt(2, rsv.getNo());
				
				if(pstmt.executeUpdate() == 1) {
					return "예약수정 성공";
				}
				return "예약정보 없음";
			} catch (Exception e) {
				e.printStackTrace();
				return "예약 수정 실패";
			}
			finally {
				KimDBManager.close(con, pstmt, null);
			}
		}
//		 * 8. 예약 취소(예약 번호로 취소)
		public static String deleteReserve(Reservation rsv) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = KimDBManager.connect();
				String sql = "delete from jun10_reservation where rsv_num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, rsv.getNo());
				
				if(pstmt.executeUpdate() == 1) {
					
					return "예약 취소 성공";
				}
				return "예약정보 없음";
			} catch (Exception e) {
				e.printStackTrace();
				return "예약 수정 실패";
			}
			finally {
				KimDBManager.close(con, pstmt, null);
			}
		}
//		 * 9. 종료
		 
		
	
}

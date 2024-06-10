package com.kim.db.last;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	//MVC 패턴의 C - 코드의 실행과 흐름을 관리
	public static void main(String[] args) {
		/*
		 * 1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)
		 * 2. 매장등록(지점명, 지점장, 좌석수)
		 * 3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분
		 * 4. 전체 매장 조회 (위치(좌석 수) - 사장님 이름의 형식)
		 * 5. 매장 찾기(최소 좌석 수 입력) => 좌석 수 이상의 매장의 정보를 출력
		 * 6. 예약 찾기(예약자 이름)
		 * 7. 예약 정보 수정(예약번호를 입력하면, 연락처를 변경)
		 * 8. 예약 취소(예약 번호로 취소)
		 * 9. 종료
		 */
		int menu = 0;
		String result = null;
		Reservation rsv = null;
		Restaurant rst = null;
		ArrayList<Reservation> rsvResult = null;
		ArrayList<Restaurant> rstResult = null;
		
		System.out.println("<<예약 프로그램>>");
		//종료 버튼 누를때까지 계속 루프
		while(true) {
			try {
				
				menu = ConsoleScreen.showMainMenu();
				if(menu==9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}	
				else if (menu ==1) {
					// 1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)
					rsv = ConsoleScreen.showRsvMenu();
					result = DAO.book(rsv);
					ConsoleScreen.printResult(result);
				}
				else if (menu == 2) {
					//  2. 매장등록(지점명, 지점장, 좌석수) 
					rst = ConsoleScreen.showRstMenu();
					result = DAO.registerRst(rst);
					ConsoleScreen.printResult(result);
				}
				else if (menu == 3) {
					//  3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분 
					rsvResult = DAO.getAllReserve();
					ConsoleScreen.showRsvResultMenu(rsvResult);
				}
				else if (menu == 4) {
					//  4. 전체 매장 조회 (위치(좌석 수) - 사장님 이름의 형식)
					rstResult = DAO.getAllRestaurant();
					ConsoleScreen.showRstResultMenu(rstResult);
				}
				else if (menu == 5) {
					//  5. 매장 찾기(최소 좌석 수 입력) => 좌석 수 이상의 매장의 정보를 출력
					Scanner k = new Scanner(System.in);
					System.out.println("원하는 최소 좌석 수 : ");
					int wanted_seat=k.nextInt();
					rstResult = DAO.searchRstBySeat(wanted_seat);
					ConsoleScreen.showRstSearchBySeat(rstResult);
				}
				else if (menu == 6) {
					//  6. 예약 찾기(예약자 이름)
					Scanner k = new Scanner(System.in);
					System.out.println("매장 찾기 | 예약자 이름 : ");
					String rsv_name=k.next();
					rsvResult = DAO.searchRsvBytRsvName(rsv_name);
					ConsoleScreen.showRsvResultMenu(rsvResult);
				}
				else if (menu == 7) {
					//  7. 예약 정보 수정(예약번호를 입력하면, 연락처를 변경)
					
					rsvResult = DAO.getAllReserve();
					ConsoleScreen.showRsvResultMenu(rsvResult);
					
					rsv = ConsoleScreen.showUpdateRsvMenu();
					result = DAO.updateReserve(rsv);
					ConsoleScreen.printResult(result);					
				}
				else if (menu == 8) {
					//	8. 예약 취소(예약 번호로 취소)
					rsv = ConsoleScreen.showDeleteRsvMenu();
					result = DAO.deleteReserve(rsv);
					ConsoleScreen.printResult(result);	
				}
				
				
			} catch (Exception e) {
				//thorw로 던져놓은거 처리
				e.printStackTrace();
			}
			
			
		}
	}
}

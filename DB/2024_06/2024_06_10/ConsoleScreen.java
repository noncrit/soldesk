package com.kim.db.last;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
//	사용자가 콘솔을 볼 수 있거나, 콘솔에 입력 할 수 있게 (MVC의 V(View) )
public class ConsoleScreen {
	/*
	 * 1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)
	 * 2. 매장등록(지점명, 지점장, 좌석수)
	 * 3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분)(예약번호 오름차순 정렬)
	 * 4. 전체 매장 조회 (위치(좌석 수) - 사장님 이름의 형식)
	 * 5. 매장 찾기(최소 좌석 수 입력) => 좌석 수 이상의 매장의 정보를 출력
	 * 6. 예약 찾기(예약자 이름)
	 * 7. 예약 정보 수정(예약번호를 입력하면, 연락처를 변경)
	 * 8. 예약 취소(예약 번호로 취소)
	 * 9. 종료
	 */
	
	public static int showMainMenu() {
		Scanner k = new Scanner(System.in);
		System.out.println("=======================");
		System.out.println("1. 예약하기");
		System.out.println("2. 매장등록");
		System.out.println("3. 전체 예약 확인");
		System.out.println("4. 전체매장조회");
		System.out.println("5. 매장찾기");
		System.out.println("6. 예약찾기");
		System.out.println("7. 예약정보 수정");
		System.out.println("8. 예약 취소");
		System.out.println("9. 종료");
		System.out.println("=======================");
		
		System.out.print("번호 입력 : ");
		return k.nextInt();
	}
	
	//예약을 성공했는지, 실패했는지 판단
	public static void printResult(String result) {
		System.out.println(result);
	}
	
	//1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)
	public static Reservation showRsvMenu() throws ParseException {
		Scanner k = new Scanner(System.in);
		
		System.out.print("예약자 : ");
		String name = k.next();
		
		System.out.print("예약날짜(YYYY-MM-DD/HH:mm) : ");
		String when = k.next();
		//날짜 형태로 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
		//java.util 사용, exception은 throw 처리
		Date when2 = sdf.parse(when);
		
		System.out.print("연락처 : ");
		String phonNum = k.next();
		
		System.out.print("예약 지점명 : ");
		String location = k.next();
		
		//이제 이놈들을 MVC 패턴의 M(Model) - DAO(Data Access Object) 에서 처리 할 예정
		//근데 리턴값 필요한데 다중 리턴은 불가능함
		//그래서 객체를 리턴할 예정
		
		Reservation r = new Reservation(0,name,when2,phonNum,location);
		
		return r;
		
	}
	
	// 2. 매장등록(지점명, 지점장, 좌석수)
	public static Restaurant showRstMenu() {
		
		Scanner k  = new Scanner(System.in);
		
		System.out.print("지점명 : ");
		String location =k.next();
		
		System.out.print("지점장 : ");
		String owner = k.next();
		
		System.out.print("좌석 수 : ");
		int seat = k.nextInt();
		
		return new Restaurant(location, owner, seat);
	}
	//	3. 전체 예약 확인(날짜는 연-월-일 요일 오전/오후 시:분)(예약번호 오름차순 정렬)
	public static void showRsvResultMenu(ArrayList<Reservation> rsvs) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a hh:mm");
		for (Reservation r : rsvs) {
			System.out.printf("%d) ", r.getNo());
			System.out.printf("[%s - ", r.getName());
			System.out.printf(" %s] ", r.getPhone());
			System.out.printf(r.getLocation() + " - ");
			System.out.println(sdf.format(r.getWhen()));
		}
	}
	//	4. 전체 매장 조회 (위치(좌석 수) - 사장님 이름의 형식)
	public static void showRstResultMenu(ArrayList<Restaurant> rsts) {
		
		for(Restaurant r : rsts) {
			System.out.printf("지점 : %s", r.getLocation());
			System.out.printf("(좌석 수 : %d) - ", r.getSeat());
			System.out.printf("[사장 : %s ] ", r.getOwner());
			System.out.println();
		}
		
	}
	//	5. 매장 찾기(최소 좌석 수 입력) => 좌석 수 이상의 매장의 정보를 출력
	//	사실 4번이랑 별 기능 차이 없어서 그냥 가져다 써도 상관 없음
	public static void showRstSearchBySeat(ArrayList<Restaurant> rsts) {
		
		for(Restaurant r : rsts) {
			System.out.printf("지점 : %s", r.getLocation());
			System.out.printf("(좌석 수 : %d) - ", r.getSeat());
			System.out.printf("[사장 : %s ] ", r.getOwner());
			System.out.println();
		}
		
	}
	//6. 예약 찾기(예약자 이름)
	// 3번과 기능이 동일하므로, 같이 사용
	
	//7. 예약 정보 수정(예약번호를 입력하면, 연락처를 변경)
	public static Reservation showUpdateRsvMenu() {
		
		Scanner k = new Scanner(System.in);
		System.out.print("예약 변호 : ");
		int no = k.nextInt();
		System.out.println("변경할 연락처 : ");
		String phoneNum = k.next();
		return new Reservation(no,null,null,phoneNum,null);
		
	}
	
//	8. 예약 취소(예약 번호로 취소)
	public static Reservation showDeleteRsvMenu() {
		
		Scanner k = new Scanner(System.in);
		System.out.print("취소할 예약 변호 : ");
		int no = k.nextInt();
		return new Reservation(no,null,null,null,null);
	}
	
	
}

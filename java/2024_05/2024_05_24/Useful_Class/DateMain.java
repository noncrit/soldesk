package com.kim.may_24_2.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/*날짜와 시간
 *	Date.java -> 1900년대 만들어진 Class
 *	Y2K에 큰 관심이 없던 시기(Year 2000 problem)
 *	1900년대는 컴퓨터 용량이 매우 작았음->연도 맨 끝 두자리만 사용
 *	1970년 이전 컴퓨터들은 속도가 느리고, 장치 자체의 용량도 매우 작았다.
 *	데이터 양을 줄이기 위해 연도 처리를 할때 4byte(4자리) 대신 2byte(자리)를 할당해 사용했음
 *	근데? 2000년대가 다가오고 있음
 *	근데 1900년, 2000년 둘 다 00으로 인식해서 문제가 생김 ->컴퓨터 입장에서는 구분을 못함
 *	->컴퓨터의 오작동 가능성이 컸음!
 * 
 */

//	Date : 날짜 / 시간 클래스
//	Deprecated : 더 이상 유효하지 않음을 표시함, 다음 버전에 없어질 수 도 있다...
public class DateMain {
	
	public static void main(String[] args) {
		System.out.println(LocalDate.now());	//날짜
		System.out.println(LocalTime.now());	//시간
		System.out.println(LocalDateTime.now());//날짜+시간
		System.out.println(Calendar.DATE);
		System.out.println(Calendar.MONTH);
		
		//	Java: java.util.Date
		//	SQL	: java.sql.Date 이 둘이 연동 가능함
		
		//기본 생성 -> 현재 시간/날짜
		Date now = new Date();
		
		//현재 시간과 날짜 출력
		System.out.println(now);
		
		//연도 추출
		System.out.println(now.getYear()+1900);	//1900년대 기준이라 ㅋㅋㅋ.....
		
		//월 추출
		System.out.println(now.getMonth()+1);	//1월이 0부터 시작함
		
		//일 추출
		System.out.println(now.getDate()); 		//얘는 1부터 시작함
		
		// 요일
		System.out.println(now.getDay()); 		//0(Sunday) - 6(Saturday)
		String[] day = {"일","월","화","수","목","금","토"};
		
		// Date - 형식 지정 -> String
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd E a hh:mm");
		
		String s1 = sdf.format(now);
		System.out.println(s1);
		
		//특정 시간 날짜
		Date d2 = new Date(2024, 5, 24, 18, 0, 1);
		System.out.println(d2);
		
		//String - 형식 지정 -> Date
		try {
			
			String s2 = "2000/05/12";
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
			Date d3 = sdf2.parse(s2);
			System.out.println(d3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//10 년전 크리스마스?
		String xmas = "2014/12/25";
		SimpleDateFormat x = new SimpleDateFormat("yyyy/MM/dd");
		Date xd;
		try {
			xd = x.parse(xmas);
			System.out.println(xd);
			
			SimpleDateFormat sdf3 = new SimpleDateFormat("E");
			String what_day=sdf3.format(xd);
			System.out.println(what_day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Calendar - Calendar를 객체로 선언하고 사용해야 본인 컴퓨터에 맞는 정보가 들어감
		Calendar c = Calendar.getInstance();
		
		
	}//end of main
}

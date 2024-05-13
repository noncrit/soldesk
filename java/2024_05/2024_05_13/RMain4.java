//반복문 이름 붙이기

/* 수업 파트 설명
 * Part 1. 절차지향 프로그래밍(순서대로 잘 써서 결과를 잘 내자~)
 * Part 2. 객체지향 프로그래밍 - 문과스러운 느낌?
 * Part 3. 기타 등등(외부 라이브러리 가져다 쓰기 등등)
 */

import java.util.Scanner;

public class RMain4 {
	
	public static void main(String[] args) {
		prac2();
	}
	
	// '누구' 에 해당하는 값을 입력했을 떄, (매니저, 강사, 학생) 이하의 내용을 출력하도록
	//	프로그램이 계속 동작하다가 끝 을 입력받으면 프로그램 종료
	//	매니저 : 시스템 관리, 학생 관리, 수업 관련 업무
	//	강사	: 학생 관리, 수업 관련 업무
	//	학생	: 수업 관련 업무
	
	//강사님은 switch문 안에 break 붙인 예제로 break scope 예시 들어주심 - 무조건 가까운거부터 종료시킴
	//반복문에 이름 붙이기 a : while ~~ -> 반복문 이름을 불러와서 break 시키면 멀리 있는놈도 종료시키기 가능
	public static void prac1() {
		Scanner sc=new Scanner(System.in);
		String input=null;
	a :	while(true) {
			System.out.println("누구세요?");
			input=sc.next();
			if(input.equals("끝")) {
				System.out.println("프로그램 종료");
				break a;
			}
			if(input.equals("매니저")) {
				manager();
			}
			if(input.equals("강사")) {
				teacher();
			}
			if(input.equals("학생")) {
				student();
			}
			else continue;
		}
		
	}
	public static void manager() {
		System.out.println("시스템 관리, 학생 관리, 수업 관련 업무");
	}
	public static void teacher() {
		System.out.println("학생 관리, 수업 관련 업무");
	}
	public static void student() {
		System.out.println("수업 관련 업무");
	}
	
	//2
	
	public static void prac2() {
		
		bb : for (int i=0; i<3; i ++) {
			aa : for(int j=0; j<3; j++) {
					for (int j2 = 0; j2 < 3; j2++) {
					System.out.printf("%d, %d, %d\n",i,j,j2);
					if(i==1) {
						System.out.println("중단!");
						
						break;		//	1,0,0 ->break가 j2 부분을 종료시킴
					//	break aa;	//	1,0,0 -> i=1 일때 aa루프를 깨버림->바로 i++한뒤 다음루프 진행->j 증감이 생략됨
					//	break bb;	//	1,1,0 (x) 1,0,0 종료
					}
					
					
				}
			}
		}
	}
	
}

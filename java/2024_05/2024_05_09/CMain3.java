/*
 * 조건문 : if, switch
 * switch문 : 비교하는 조건이 특정한 값이나 문자열인 경우 사용함
 * break; 를 이용해 조건문이 만족되면 switch문을 탈출함
 *예시
 *switch (변수 or 식){
 *case 값 A:
 * 	변수 or 식의 값이 A일때 이 부분을 실행
 * 	break;
 *case 값 B:
 *	변수 or 식의 값이 B일때 이 부분을 실행
 *	break;
 *default :
 *	아무것도 해당안하면 이거 실행
 *	break;
 *}
 *
 */
import java.util.Scanner;

public class CMain3 {
static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		
		print_text(scan_int());
		
	}
	//x가 1일때 "ㅋㅋ", 2일때 "ㅎㅎ"/3일때 "ㅠㅠ"/ 모두 아니면 "배고파..."
	public static void print_text(int x) {
		switch (x) {
		case 1:	System.out.println("ㅋㅋ");
				break;
		case 2:	System.out.println("ㅎㅎ");
				break;
		case 3:	System.out.println("ㅠㅠ");
				break;
		default:	System.out.println("배고파...");
		}
	}
	
	
	public static int scan_int() {
		System.out.println("정수를 입력해주세요.");
		int a=sc.nextInt();
		return a;
	}
}

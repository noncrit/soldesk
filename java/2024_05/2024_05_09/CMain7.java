import java.util.Scanner;

public class CMain7 {
static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		plus_or_minus();
		mul_of_3or4();
	}
	public static int scan_int() {
		System.out.println("정수를 입력해주세요.");
		int a=sc.nextInt();
		return a;
	}
	//1. 정수를 하나 입력받아서 - 양수면 "양",0이면 0,음이면 "음"
	public static void plus_or_minus() {
		int x=scan_int();
		if(x==0) { 
			System.out.println("0");
		}
		else if(x>0) {
			System.out.println("양");
		}
		else System.out.println("음");
		}

	//2. 정수를 하나 입력받아서 - 3의 배수면 "3의 배수",4의 배수면 "4의 배수", 둘 다 아니면 "몰라"
	public static void mul_of_3or4() {
		int x=scan_int();
		if(x%3==0 && x%4!=0) {
			System.out.println("3의 배수");	
		}
		if(x%4==0 && x%3!=0) {
			System.out.println("4의 배수");	
		}
		if(x%12==0) {
			System.out.println("12의 배수");	
		}
		else {
			System.out.println("몰라");
		}
	}
}

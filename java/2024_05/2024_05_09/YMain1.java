import java.util.Scanner;
public class YMain1 {
static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		in_less_thatn_3();
		only_oddnum();
		get_1to100();
	}
	
	//3보다 작은 정수를 입력받는 함수 - 정수가 3보다 크거나 같을 때 정수를 다시 입력받기
	public static void in_less_thatn_3() {
		System.out.println("3보다 작은 정수를 입력하세요.");
		int user_input=sc.nextInt();
		
		if(user_input>=3) {	
			System.out.println("입력 범위 오류입니다.");
			in_less_thatn_3();
		}
		else {
			System.out.println("입력값 : "+user_input);
		}
	}
	
	//홀수만 입력받을 수 있는 함수 - 짝수를 입력받으면 다시 입력받을수 있도록
	public static void only_oddnum() {
		System.out.println("홀수를 입력하세요.");
		int user_input=sc.nextInt();
		
		if((user_input%2)==0){	
			System.out.println("입력 범위 오류입니다."); 
			only_oddnum();
		}
		else {
			System.out.println("입력값 : "+user_input);
		}
	}
	
	//정수를 입려받는 함수 - 조건)정수의 범위가 0~100사이/ 범위 외의 정수는 다시 입력받기
	public static void get_1to100() {
		System.out.println("1~100 사이의 정수를 입력하세요.");
		int user_input=sc.nextInt();
		
		if(user_input<0||user_input>100){	
			System.out.println("입력 범위 오류입니다."); 
			get_1to100();
		}
		else {
			System.out.println("입력값 : "+user_input);
		}
	}
}

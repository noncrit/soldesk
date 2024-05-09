import java.util.Scanner;
public class CMain2 {
static Scanner sc=new Scanner(System.in);	
	
	public static void main(String[] args) {
		int a=scan_int();
		int y=0;
		//if 문 안쪽에 변수선언하면 if문이 돌아가면서 y를 계속 생성함->낭비 - 변수 생성은 루프 안돌게 바깥쪽으로 빼주자
		if(a>5) {
					y=10;
					System.out.println(y);
		}
		else if(a>3) {
						y=20;
						System.out.println(y);
		}
		
	}
	//숫자 하나 입력
	//입력받은 정수 값이 5보다 크면 새로운 변수 y에 정수 10담아서 출력
	//입력받은 정수 값이 3보다 크면 새로우 변수 y에 정수 20을 담아서 출력
	
	public static int scan_int() {
		System.out.println("정수를 입력해주세요.");
		int a=sc.nextInt();
		return a;
	}
}

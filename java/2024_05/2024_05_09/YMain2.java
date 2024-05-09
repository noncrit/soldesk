//무한 루프 예제있었음 getResult(x,y)에 계속 홀수 출력나와서 루프도는 상황
import java.util.Scanner;

public class YMain2 {
	
static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(adder_int());
	}
	//정수 2개를 입력받아서 정수 2개를 더했을때 짝수면 그 결과 리턴, 아니며 값을 다시 입력받기
	public static int adder_int() {
		int a=scan();
		int b=scan();
		//int sum=((a+b)%2==0)?(a+b):adder_int();
		if((a+b)%2==0) {
							int sum=a+b;
							return sum;
		}
		else {
				int sum=adder_int();
				return sum;
		}
	}
	
	//스캐너로 입력받는 함수
	public static int scan() {
		System.out.println("정수를 입력해주세요");
		int a=sc.nextInt();
		return a;
	}
}

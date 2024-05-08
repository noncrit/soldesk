/*함수의 형태
 * public static A(리턴 타입) B(함수명) (C : 파라미터){내용 return(리턴값 자료형 명시하는 경우만)}
 * void : 리턴할것이 없다는 자료형
 */
import java.util.Random;
public class FMain1 {
	public static void main(String[] args) {
		
		add_printer(random_int(), random_int());
		System.out.println();
		compare(random_int(), random_int());
		compare(3.56,2.87);
		
	}
	//랜덤한 정수 하나를 뽑는 함수
	public static int random_int() {
		Random r=new Random();
		int i =r.nextInt();
		return i;
	}
	//두 정수를 더한 값을 출력하는 함수
	public static void add_printer(int a, int b) {
		System.out.println("a+b = " + (a+b));
	}
	//정수 두 개를 넣으면 둘 중 큰것을 출력하는 함수
	public static void compare(int a,int b) {
		int tmp=a-b;
		if(tmp>0) {System.out.println(a+" is bigger");}
		else if(tmp<0) {System.out.println(b+" is bigger");}
		else {System.out.println("a,b is equal");}
	}
	
	//실수 두 개를 넣으면 둘 중 큰 숫자를 구해주는 함수
	public static void compare(double a, double b) {
		double tmp = a-b;
		if(tmp>0) {System.out.println(a+" is bigger");}
		else if(tmp<0) {System.out.println(b+" is bigger");}
		else {System.out.println("a,b is equal");}
		
	}

}
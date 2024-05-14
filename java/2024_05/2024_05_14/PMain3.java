//정수 2개를 넣으면 그 합을 출력해주는 함수
//정수 3개를 넣으면 그 합을 출력해주는 함수
//오버로딩 복습

//정수를 n개 넣으면 그 곱을 출력하는 함수
// public static void printMul(int ... n) { } (파라미터 무제한으로 쓸 때 ... 사용)
// 함수 내에서는 배열처럼 사용하면 됨
import java.util.Scanner;

public class PMain3 {
	public static void main(String[] args) {
		
	}
	
	public static int sum(int a, int b) {	
		System.out.printf("%d + %d = %d",a,b,a+b);
		return (a+b);
	}
	
	public static int sum(int a, int b, int c) {
		System.out.printf("%d + %d +%d = %d",a,b,c,a+b+c);
		return (a+b+c);
	}
/*	
	public static int product_of_n() {
		int product=1;
		Scanner sc=new Scanner(System.in);
		int[] x = null;
		int i=0;
		
		while(true) {
			System.out.println("정수를 입력해주세요");
			System.out.println("입력을 마치려면 0을 입력해주세요.");
			x[i]=sc.nextInt();
			if(x[i]==0) { 
				break;
			}
		}
		
		
	}
*/
	public static void printMul(int ... n) {
		int mul=1;
		
		for (int i = 0; i < n.length; i++) {
			mul*=n[i];
			
		}
	}
	
}

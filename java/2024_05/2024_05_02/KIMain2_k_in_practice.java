import java.util.Scanner;

public class KIMain2 {
	public static void main(String[] args) {
		//메뉴판 만들기 피자집
		//메뉴의 가격을 입력 받아서 메뉴판 모양으로 예쁘게 출력하기
		
		Scanner key_in=new Scanner(System.in);
		
		System.out.println("----------");
		System.out.println("메뉴 별 가격 입력");
		
		System.out.println("콤비네이션 피자 : ");
		int combination_pizza = key_in.nextInt();
		
		System.out.println("파인애플 피자 : ");
		int pinapple_pizza = key_in.nextInt();
		
		System.out.println("고구마 피자 : ");
		int sweet_potato_pizza = key_in.nextInt();
		
		System.out.println("갈릭마요 피자 : ");
		int garlic_mayo_pizza = key_in.nextInt();
		
		System.out.println("치즈 피자 : ");
		int cheese_pizza = key_in.nextInt();
		
		System.out.println("페페로니 피자 : ");
		int pepe_pizza = key_in.nextInt();
		
		System.out.println();
		System.out.println("--------메뉴판--------");
		
		System.out.println("콤비네이션 피자 : " + combination_pizza+"원");
		System.out.println("파인애플 피자 : " + pinapple_pizza +"원");	
		System.out.println("고구마 피자 : " + sweet_potato_pizza+"원");	
		System.out.println("갈릭마요 피자 : " + garlic_mayo_pizza+"원");	
		System.out.println("치즈 피자 : " + cheese_pizza+"원");	
		System.out.println("페페로니 피자 : " + pepe_pizza+"원");
		
		System.out.println("--------------------");
		
	}
}
// %,7d -> , 3자리 마다 , 찍기 | 7d 7자리에 맞춰서 숫자 표기

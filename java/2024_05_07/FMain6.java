//1.랜덤한 정수하나 출력하는 함수, 
//2. 랜덤한 정수를 하나  생성하는 함수
//3. 정수를 하나 넣으면 홀수인지 짝수인지 출력하는 함수
//4. 정수를 두 개 넣었을 때 앞 숫자가 크면 앞, 뒤 숫자가 크거나 같으면 뒤를 생성하는 함수
//import java.util.Scanner;
import java.util.Random;
public class FMain6 {
	
	public static void main(String[] args) {
		
		rand_int();
		System.out.println(rand_gen_int());
		decide_odd_even(3);
		System.out.println(which_is_bigger(3, 5));
		System.out.println(which_is_bigger(30, 5));
		System.out.println(which_is_bigger(3, 3));
		dinner_choice();

	}
	
	//random integer printer
	public static void rand_int() {
		Random r = new Random();
		int i = r.nextInt(100);
		System.out.println(i);
	}
	
	public static int rand_gen_int() {
		Random r = new Random();
		int i = r.nextInt();
		return i;
	}
	
	public static void decide_odd_even(int input) {
		int decider=input%2;
		if(decider==0) {System.out.println("짝수!");}
		else{System.out.println("홀수!");}
	}
	
	public static String which_is_bigger(int n1, int n2) {
		int subtraction=n1-n2;
		String result = null;
		if(subtraction>0){ result="앞";}
		else if(subtraction<0){ result="뒤";}
		else if(subtraction==0){ result="같음";}
		return result;
	}
	//오늘의 저녁메뉴 고르기 2가지중 하나, 랜덤한 숫자 2개 뽑아서 먼저 뽑힌놈이 크면 1번메뉴 아니면 2번메뉴
	public static void dinner_choice() {
		String menu1="고등어 조림";
		String menu2="김밥";
		int num1=rand_gen_int();
		int num2=rand_gen_int();
		String result=which_is_bigger(num1, num2);
		if(result.equals("앞")){System.out.println(menu1);}
		else if(result.equals("뒤")){System.out.println(menu2);}
		else System.out.println("둘 다\n");
	}
}
	


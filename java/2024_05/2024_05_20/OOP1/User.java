import java.util.Scanner;

public class User {
	
	int user_picked_coin;
	String odd_even;
	Scanner sc=new Scanner(System.in);
	
	public int scan_user_int() {
		
		int input=sc.nextInt();
		return input;
		
	}
	
	public String odd_even_user_choice(int user_picked_coin) {
		
		System.out.println("동전의 갯수가 짝수일까요, 홀수일까요? 홀/짝으로 입력해주세요.");
		
		String user_choice=sc.next();
		
		if(user_choice.equals("홀") || user_choice.equals("짝")) {
			return user_choice;
		}
		else return odd_even_user_choice(user_picked_coin);
	}
	
	
}

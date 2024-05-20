import java.util.Random;
import java.util.Scanner;

public class Dealer {
	
	int initial_coin=20;
	int user_coin;
	int remaining_coin;
	String odd_even_result;
	int odd_even;
	Scanner sc=new Scanner(System.in);

	public int scan_dealer_int() {
			
		int input=sc.nextInt();
		return input;
		
	}
	
	public int ask_user_coinpicking() {
		System.out.println("몇 개의 동전으로 게임을 시작할지 입력해주세요.(최소 2, 최대 20)");
		this.user_coin=scan_dealer_int();
		if(user_coin<2 || user_coin>20 ) {
			System.out.println("잘못된 입력입니다.");
			ask_user_coinpicking();
		}
		this.remaining_coin=this.initial_coin-this.user_coin;
		
		return user_coin;
	}

	
	public String odd_even_result(int user_coin) {
		
		Random r= new Random();
		
		int result=r.nextInt(user_coin)+1;
		this.odd_even=result;
		int dedcier=result%2;
		if(dedcier==0) {
			return "짝";
		}
		else {
			return "홀";
		}	
	}
	
	public void odd_even_decier(String dealer_result, String user_input) {
		
		if(dealer_result.equals(user_input)) {
			System.out.printf("딜러의 짤짤이 결과 : %d개\n",this.odd_even);
			System.out.println("승리하셨습니다!");
		}
		else {
			System.out.printf("딜러의 짤짤이 결과 : %d개\n",this.odd_even);
			System.out.println("패배하셨습니다.");
		}
		
	}
	
	public void start() {
		
		Dealer d=new Dealer();
		User u = new User();
		
		d.user_coin=d.ask_user_coinpicking();
		
		u.user_picked_coin=d.user_coin;
		
		u.odd_even=u.odd_even_user_choice(u.user_picked_coin);
		
		d.odd_even_result=d.odd_even_result(d.user_coin);
		
		d.odd_even_decier(d.odd_even_result, u.odd_even);
		
	}
	
	
	
}

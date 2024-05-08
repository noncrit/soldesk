//동전 맞추기 게임
//최대 동전 10개, 컴퓨터가 동전 몇개나 손에 쥐고 있는지 맞추기
import java.util.Random;
import java.util.Scanner;

public class FMain4 {
	public static void main(String[] args) {
		start_game();
	}	
	//컴퓨터가 동전 손에 뽑기
	public static int computer_picking_coin() {	
		return new Random().nextInt(9)+1;
	}
	
	//유저가 동전 몇개인지 선언하기-선언한 갯수 리턴
	@SuppressWarnings("resource")
	public static int user_choice() {
		System.out.println("컴퓨터가 선택한 동전의 갯수는?(1~10)");
		return new Scanner(System.in).nextInt();
	}
	
	//유저와 컴퓨터 동전 개수 비교 
	public static void comapre_phase(int user_choice,int computer_pick) {
		System.out.println("유저의 추측 : "+user_choice+"개");
		System.out.println("컴퓨터가 선택한 동전의 갯수 : "+computer_pick+"개");
		if(user_choice==computer_pick) {System.out.println("정답입니다!");}
		else if (user_choice!=computer_pick) {System.out.println("오답입니다!");
		}
	}
	
	//함수 종합&실행 부분
	public static void start_game() {
		int computer_coin=computer_picking_coin();
		int user_coin=user_choice();
		comapre_phase(user_coin, computer_coin);
	}
}

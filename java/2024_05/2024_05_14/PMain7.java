//거스름돈 환전 프로그램
//함수 사용
//입력
//구매한 물건 가격
//낸 돈
//--------
//거스름돈을 우리나라 화폐를 기준으로 거슬러주기
//0개짜리는 출력하지 않음
import java.util.Scanner;

public class PMain7 {
static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		start();
	}
	//물건 가격 입력받는 함수
	public static int get_input_price() {
		System.out.println("구매한 물건의 가격을 입력해주세요.");
		int input=sc.nextInt();
		return input;
	}
	//지불한 금액 입력받는 함수
	public static int get_input_money_payed() {
		System.out.println("지불한 금액을 입력해주세요.");
		int input=sc.nextInt();
		return input;
	}
	//거스름돈 계산 함수
	public static void change_calc(int price, int money_taken) {
		//여기 배열로 선언해도 상관은 없음/변수명 보이는쪽이 편해서 이쪽으로함
		//다른 방법으로는 %5,%2,%5,%2... 반복을 이용해도 상관은 없음
		int won_50000=0;
		int won_10000=0;
		int won_5000=0;
		int won_1000=0;
		int won_500=0;
		int won_100=0;
		int won_50=0;
		int won_10=0;
		int tmp=0;
		
		int change=money_taken-price;
		int change_inital=change;
		if(change<0) {	//돈 모자르면 입력 다시받음
			System.out.println("지불한 금액이 부족합니다. 돈 더 내십쇼.");
			change_calc(price, get_input_money_payed());
		}
		else { //거스름돈 계산 루틴
			won_50000=(change/50000);
			change=(change%50000);
			
			won_10000=(change/10000);
			change=(change%10000);
			
			won_5000=(change/5000);
			change=(change%5000);
			
			won_1000=(change/1000);
			change=(change%1000);
			
			won_500=(change/500);
			change=(change%500);
			
			won_100=(change/100);
			change=(change%100);
			
			won_50=(change/50);
			change=(change%50);
			
			won_10=(change/10);
			change=(change%10);
		}
		if(change_inital>=0) //거스름돈 음수면 아래 판단작업 모두 생략
		{
			System.out.println("구매한 물건 가격 : "+price);
			System.out.println("지불한 금액 : "+money_taken);
			System.out.println("--------------------");
			System.out.println("거스름돈 : "+change_inital);
		
			if(print_calc_change(won_50000)==true) {
				System.out.printf("50000원 : %d장\n",won_50000);		
			}
			if(print_calc_change(won_10000)==true) {
				System.out.printf("10000원 : %d장\n",won_10000);		
			}
			if(print_calc_change(won_1000)==true) {
				System.out.printf("1000원 : %d장\n",won_1000);
			}
			if(print_calc_change(won_5000)==true) {
			System.out.printf("5000원 : %d장\n",won_5000);		
			}
			if(print_calc_change(won_50000)==true) {
				System.out.printf("1000원 : %d장\n",won_1000);		
			}
			if(print_calc_change(won_500)==true) {
				System.out.printf("500원 : %d개\n",won_500);		
			}
			if(print_calc_change(won_100)==true) {
				System.out.printf("100원 : %d개\n",won_100);		
			}
			if(print_calc_change(won_50)==true) {
				System.out.printf("50원 : %d개\n",won_50);		
			}
			if(print_calc_change(won_10)==true) {
				System.out.printf("10원 : %d개\n",won_10);		
			}
			System.out.println("-------------------");
		}
	}
	//거스름돈 0일때는 표기 생략을 위한 함수
	public static boolean print_calc_change(int won) {
		if(won>0) {
			return true;
		}
		else return false;
	}
	//프로그램 시작 함수
	public static void start() {
		int price=get_input_price();
		int money_spend=get_input_money_payed();
		change_calc(price, money_spend);
	}
}

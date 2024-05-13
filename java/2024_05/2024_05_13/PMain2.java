//ATM 기능을 하는 프로그램
//1 - 입금 / 2- 출금 /3-잔액 확인/4-프로그램 종료
//입금 출금 돈 입력받기
import java.util.Scanner;

public class PMain2 {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int deposit=0;
		int user_input=0;
		int money=0;
		while(user_input!=4) {
			
			System.out.println("원하시는 거래를 선택해주세요.");
			System.out.println("1 - 입금 / 2 - 출금 / 3 - 잔액 확인 / 4 - 프로그램 종료");
			user_input=sc.nextInt();
			//거래 종료 - 대부분 사람들이 거래1~2회 종료1 한다는 가정하에 제일 앞에 놓는게 기대 연산량이 가장 적음
			if(user_input==4) {
				break;
			}
			//입금작업
			else if(user_input==1) {
				System.out.println("입금할 액수를 입력해주세요.");
				money=sc.nextInt();
				if(money<0) {
					continue;
				}
				deposit=deposit+money;
				System.out.printf("입금한 금액 : %d 원\n",money);
				System.out.printf("계좌 잔액: %d 원\n",deposit);
			}
			//출금작업 (잔액부족시 메인화면으로)
			else if(user_input==2) {
				System.out.println("출금할 액수를 입력해주세요.");
				money=sc.nextInt();
				//음수 입력 검사
				if(money<0) {
					continue;
				}// 잔액 부족 검사
				if(deposit<money) {
					System.out.println("계좌 잔액이 부족합니다.");
					continue;
				}
				deposit=deposit-money;
				System.out.printf("출금한 금액 : %d 원\n",money);
				System.out.printf("계좌 잔액: %d 원\n",deposit);
			}
			else if(user_input==3) {
				System.out.println("계좌 잔액을 표시합니다.");
				System.out.printf(deposit+"원\n");
			}
			else continue;
			
		}
		
		
		
	}
}

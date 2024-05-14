//주사위 게임(메인함수만 사용)
//유저와 컴퓨터가 각각 주사위를 3개씩 굴려서 그 합이 높은쪽이 이기는 게임
//1번 입력:	유저와 컴퓨터가 각각 주사위 3개 굴리기, 유저는 주사위의 눈을 확인한후 돈을 베팅, 이기면 돈을 얻고 지면 잃음
//베팅:가지고 있는 돈 보다는 많이 베팅 불가. 기본 소지금 1만원
//매 판이 끝날때마다 다시 이 게임을 할건지 재도전 의사를 묻기
//소지금 모두 잃으면 메뉴로 돌아감
//2번 입력 
//전적확인 (승/무/패/소지금)
//3번 입력
//대출 기능
//4번 입력
//채무 상환 기능
//5번 입력
//프로그램 종료
import java.util.Scanner;
import java.util.Random;

public class PMain8 {
static Scanner sc=new Scanner(System.in);
static Random r=new Random();
	
	public static void main(String[] args) {
		
		int input=0;
		int[] user_dice=null;
		int[] computer_dice=null;
		int user_sum=0;
		int computer_sum=0;
		int user_betting=0;
		
		int win=0;
		int lose=0;
		int tie=0;
		int wallet=10000;
		
		int loan=0;
		int how_much=0;
		
		int exit_counter=0;
		int game_exit_counter=0;
		
		user_dice=new int[3];
		computer_dice=new int[3];
		
		while(exit_counter==0) {
			
			if( (wallet<loan)&&(wallet-loan)<=-100000) {
				System.out.println("잔고 : "+wallet);
				System.out.println("대출금 : "+loan);
				System.out.println("파산하셨습니다. 게임 플레이가 불가능합니다.");
				break;
			}
			
			
			System.out.println("----------------------");
			System.out.println("실행할 기능을 선택해주세요.");
			System.out.println("1	: 주사위 게임 시작하기");
			System.out.println("2	: 전적/재정상태 확인하기");
			System.out.println("3	: 대출하기");
			System.out.println("4	: 채무 상환하기");
			System.out.println("5	: 프로그램 종료");
			System.out.println("----------------------");
			
			input=sc.nextInt();
			
			if(input==5) {
				exit_counter=1;
				break;
			}
			//주사위 게임 시작
			else if(input==1) {
				
				while(game_exit_counter==0) {
				
				user_sum=0;
				computer_sum=0;
				user_betting=0;
				
				
				for (int i = 0; i < user_dice.length; i++) {
					user_dice[i]=r.nextInt(6)+1;
				}
				
				for (int j = 0; j < computer_dice.length; j++) {
					computer_dice[j]=r.nextInt(6)+1;
					computer_sum+=computer_dice[j];
				}
				
				System.out.println("주사위 굴림 3회 결과");
				
				for (int i = 0; i < user_dice.length; i++) {
					System.out.printf(" %d ",user_dice[i]);
					user_sum+=user_dice[i];
				}
				System.out.println();
				System.out.println("주사위 눈의 합 : "+user_sum);
				System.out.printf("당신의 잔고 : %d\n",wallet);
				
				System.out.println("배팅할 금액을 입력해주세요.");
				user_betting=sc.nextInt();
				
				System.out.println("배팅 금액 : "+user_betting);
				System.out.println("----------------------");
				
				System.out.println("당신의 주사위 값");
				for (int i = 0; i < user_dice.length; i++) {
					System.out.printf(" %d ",user_dice[i]);
				}
				System.out.println("당신의 주사위 값의 합 : "+user_sum);
				System.out.println("----------------------");
				
				System.out.println("딜러의 주사위 값");
				for (int i = 0; i < computer_dice.length; i++) {
					System.out.printf(" %d ",computer_dice[i]);
				}
				System.out.println("딜러 주사위 값의 합 : "+computer_sum);
				System.out.println("----------------------");
				
				if(user_sum>computer_sum) {
					System.out.println("***축하합니다! 승리하셨습니다.***");
					wallet+=user_betting;
					win++;
					System.out.println("이번에 건 금액 : +"+user_betting);
					System.out.println("잔고 : "+wallet);
					user_sum=0;
					computer_sum=0;
					user_betting=0;
				}
				else if(user_sum<computer_sum) {
					System.out.println("***안타깝습니다. 패배하셨습니다.***");
					wallet-=user_betting;
					lose++;
					System.out.println("이번에 건 금액 : -"+user_betting);
					System.out.println("잔고 : "+wallet);
					user_sum=0;
					computer_sum=0;
					user_betting=0;
				}
				else if(user_sum==computer_sum) {
					System.out.println("무승부!");
					tie++;
					user_betting=0;
					continue;
				}
				
				if(wallet<=0) {
					System.out.println("지갑에 돈이 없습니다. 메뉴로 돌아갑니다.");
					break;
				}
				
				System.out.println("게임을 계속하려면 1번을, 메뉴로 나가려면 2번을 입력해주세요.");
				input=sc.nextInt();
				if(input==2) {
					input=0;
					break;
				}
				else {
					input=0;
					continue;
				}
				
				}//end of inner while
				
			
				
			}//end of outer while
			
			//전적/재정상태 확인하기
			else if(input==2) {
				System.out.println("전적/재정상태");
				System.out.printf("%d승 %d무 %d패\n",win,tie,lose);
				System.out.println("잔고 : "+wallet);
				System.out.println("대출금 : "+loan);
				System.out.println("메뉴로 돌아가려면 1번을 입력해주세요.");
				input=sc.nextInt();
				if(input==1) {
					input=0;
					continue;
				}
			}
			//대출 기능
			else if(input==3) {
				System.out.println("대출 기능입니다.");
				System.out.println("대출 할 금액을 입력해주세요. ");
				how_much=sc.nextInt();
				System.out.printf("입력된 금액 : %d원",how_much);
				System.out.println();
				loan+=how_much;
				wallet+=how_much;
				how_much=0;
				System.out.printf("총 대출금 : %d원\n",loan);
				System.out.printf("잔고 : %d원\n",wallet);
				System.out.println("메뉴로 돌아가려면 1번을 입력해주세요.");
				input=sc.nextInt();
				if(input==1) {
					input=0;
					continue;
				}
				
			}
			//채무 상환기능
			else if(input==4) {
				System.out.println("채무 상환기능입니다.");
				System.out.printf("당신의 대출금 : %d원\n",loan);
				System.out.printf("지갑 잔고 : %d원\n",wallet);
				System.out.println("상환할 액수를 입력해주세요.");
				input=sc.nextInt();
				
				if((input<=wallet)&&(input<=loan)) {
					wallet=wallet-input;
					loan=loan-input;
					System.out.printf("남은 대출금 : %d원\n",loan);
					System.out.printf("잔고 : %d원\n",wallet);
					input=0;
				}
				else {
					
					continue;
				} 
			}

			
		}
		
		
	}//end of main
}//end of class

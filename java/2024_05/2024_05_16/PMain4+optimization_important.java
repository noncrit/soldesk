//코드 간단한 최적화 단순하지만 중요한 예시! 
import java.util.Random;
import java.util.Scanner;
//


//가위바위보 게임(함수 기반)
//컴퓨터와 유저 대결
//1. 가위(Scissors), 2.바위 3. 보 (입력값)
//유저가 한번 질 동안 몇 승하는지 기록
//지면 기록 출력하고 프로그램 종료
public class PMain4 {
	
static Scanner sc = new Scanner(System.in);
static Random r=new Random();


	public static void main(String[] args) {
		
		int win = 0,lose = 0,tie=0;
		
		rps_game_logic(win, lose, tie);
	}
	
	public static int get_user_input() {
		System.out.println("가위 바위 보 중 하나를 입력해주세요");
		System.out.println("1. 가위	2. 바위	3. 보");
		int user_input=sc.nextInt();
		while(user_input<1 || user_input>3) {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			user_input=sc.nextInt();
		} 
		return user_input; //삼항연산자로 처리해도 상관없음
	}
	
	public static int get_computer_input() {
		int computer_input=r.nextInt(3)+1;
		return computer_input;
	}
	public static void print_win_lose(int win, int lose, int tie) {
		System.out.printf("승 : %d | 무 : %d | 패 : %d\n",win,tie,lose);
	}
	//하이픈 출력 함수
	public static void print_hyphen(){
		System.out.println("-----------------------");
	}
	
	//숫자를 가위 바위 보로 바꿔주는 함수
	public static String converter(int a) {
		if (a==1) {
			return "가위";
		}
		else if (a==2) {
			return "바위";
		}
		else if (a==3) {
			return "보";
		}
		else return "잘못된 입력"; 
	}
	
	public static void rps_game_logic(int win,int lose,int tie) {
		
		int user_input=get_user_input();
		int computer_input=get_computer_input();
		
		int outcome=user_input-computer_input+2;
		// 0 - 무승부 2
		// -1 or 2 - 패배 1 4
		// 1 or -2 - 승리 3 0
		
		// tie case
		if(outcome==2) {
			System.out.printf("유저 입력 : %s\n",converter(user_input));
			System.out.printf("컴퓨터 입력 : %s\n",converter(computer_input));
			print_hyphen();
			System.out.println("무승부입니다.");
			print_hyphen();
			tie++;
			print_win_lose(win, lose, tie);
			print_hyphen();
			rps_game_logic(win, lose, tie);	
		}
		//lose case
		else if(outcome%3==1) {
			System.out.printf("유저 입력 : %s\n",converter(user_input));
			System.out.printf("컴퓨터 입력 : %s\n",converter(computer_input));
			print_hyphen();
			System.out.println("패배하셨습니다...");
			print_hyphen();
			lose++;
			print_win_lose(win, lose, tie);
		}
		//win case
		else if(outcome%3==0) {
			System.out.printf("유저 입력 : %s\n",converter(user_input));
			System.out.printf("컴퓨터 입력 : %s\n",converter(computer_input));
			print_hyphen();
			System.out.println("승리하셨습니다!");
			print_hyphen();
			win++;
			print_win_lose(win, lose, tie);
			print_hyphen();
			rps_game_logic(win, lose, tie);	
		}

/* 빼는거 떠올리기 전 무식한 코드
		//유저 :가위
			if(user_input==1) {
			System.out.println("유저 입력 : 가위");

			if(computer_input==1) {
				System.out.println("컴퓨터 입력 : 가위");
				System.out.println("무승부입니다.");
				tie++;
				rps_game_logic(win, lose, tie);
			}
			else if(computer_input==2) {
				System.out.println("컴퓨터 입력 : 바위");
				System.out.println("패배하였습니다..");
				lose++;
				System.out.printf("승 : %d, 무 : %d, 패 : %d",win,lose,tie);
			}
			else if(computer_input==3) {
				System.out.println("컴퓨터 입력 : 보");
				System.out.println("승리하셨습니다.");
				win++;
				rps_game_logic(win, lose, tie);
				
				}
			}
			//유저 : 바위
			if(user_input==2) {
				System.out.println("유저 입력 : 바위");

				if(computer_input==1) {
					System.out.println("컴퓨터 입력 : 가위");
					System.out.println("승리하셨습니다.");
					win++;
					rps_game_logic(win, lose, tie);
				}
				else if(computer_input==2) {
					System.out.println("컴퓨터 입력 : 바위");
					System.out.println("무승부입니다.");
					tie++;
					rps_game_logic(win, lose, tie);
				}
				else if(computer_input==3) {
					System.out.println("컴퓨터 입력 : 보");
					System.out.println("패배하셨습니다.");
					win++;
					System.out.printf("승 : %d, 무 : %d, 패 : %d",win,lose,tie);
				}
			}//end of rock
				
				//유저 : 보
			if(user_input==3) {
					System.out.println("유저 입력 : 보");

					if(computer_input==1) {
						System.out.println("컴퓨터 입력 : 가위");
						System.out.println("패배하셨습니다.");
						lose++;
						System.out.printf("승 : %d, 무 : %d, 패 : %d",win,lose,tie);
					}
					else if(computer_input==2) {
						System.out.println("컴퓨터 입력 : 바위");
						System.out.println("승리하셨습니다.");
						win++;
						rps_game_logic(win, lose, tie);
					}
					else if(computer_input==3) {
						System.out.println("컴퓨터 입력 : 보");
						System.out.println("무승부입니다.");
						tie++;
						rps_game_logic(win, lose, tie);
						
					}
					
			}//end of paper
*/		
		}//end of rps logic
	


	
}

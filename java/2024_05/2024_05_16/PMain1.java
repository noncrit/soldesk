//베스킨라빈스 31게임
//유저 먼저 시작 (1~3사이 정수)
import java.util.Random;
import java.util.Scanner;

public class PMain1 {
	
	public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	Random r=new Random();
	
	int current_num=0;
	int key_in=0;
	int input_user=0;
	int input_com=0;
	int win=0;
	int lose=0;
	
a:	while(current_num<=31) {
	
		System.out.println("<<Game start>>)");
		System.out.println("1. Game start");
		System.out.println("2. Game score");
		System.out.println("3. Exit");
		
		key_in=sc.nextInt();
		
		if(key_in==3){
			break;
		}
		else if(key_in==1) {
		
		b:	while(current_num<=31) {
			if( current_num>=30) {
				System.out.println("패배하셨습니다.");
				lose++;
				break;
			}
			System.out.println("베스킨 라빈스 31!");
			System.out.println("1~3사이의 숫자를 선언해주세요!");
			input_user=sc.nextInt();
			if(input_user<1 || input_user>3) {
				System.out.println("잘못된 입력입니다. 숫자를 다시 입력해주세요!");
				continue;
			}
			else {
				current_num+=input_user;
				System.out.println("현재 숫자 : "+current_num);
				System.out.println("------------------------");
			}
				if( current_num==30 ) {
					System.out.println("승리하셨습니다!");
					win++;
					break;
				}
				//무조건 지는 경우 구현
				if( current_num==27 ) {
					input_com=3;
				}
				else if( current_num==28 ) {
					input_com=2;
				}
				else if( current_num==29 ) {
					input_com=1;
				}
				else {
					input_com=r.nextInt(3)+1;
				}
				current_num+=input_com;
				System.out.println("상대가 부른 숫자 : "+input_com);
				System.out.println("현재 숫자 : "+current_num);
				System.out.println("------------------------");
			}//end of menu1
		}
		
		else if(key_in==2) {
			System.out.println("<<Game score>>");
			System.out.println("Win : "+win);
			System.out.println("Lose : "+lose);
		}//end of menu 2
		//default case
		else {
			System.out.println("Wrong input");
			continue;
		}
		
		
	}//end of outer while
		
	}//end of main
	
}//end of class

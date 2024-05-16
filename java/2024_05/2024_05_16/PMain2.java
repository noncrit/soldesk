//업다운게임 함수 써서 만들기
//범위 1~100
//유저 입력값 기반으로 업 다운 판단해서 출력
//트라이 횟수 저장&출력, 정답 맞추면 트라이 횟수 출력후 종료
//return (number==answer) ->number==answer 결과에따라 true,false가 리턴됨
import java.util.Scanner;
import java.util.Random;

public class PMain2 {

static Scanner sc=new Scanner(System.in);
static Random r=new Random();
	
	public static void main(String[] args) {
		
		int how_many_try=0;
		start(how_many_try);
		
	}
	//랜덤숫자 뽑는 함수
	public static int random_num() {
		System.out.println("컴퓨터가 숫자를 선택했습니다.");
		int num_out=r.nextInt(100)+1;
		return num_out;
	}
	//유저 입력
	public static int get_user_input() {
		System.out.println("1~100 사이의 숫자 중 컴퓨터가 고른 숫자는 무엇일까요?");
		int user_input=sc.nextInt();
		if(user_input<1 || user_input>100) {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			get_user_input();
		}
		return user_input;
	}
	//업 다운 판단 알고리즘
	public static void up_down(int user_input, int computer_num,int tries) {
		
		if(user_input>computer_num) {
			System.out.printf("%d트\n",tries+1);
			System.out.println("DOWN!!");
			System.out.println("-------");
			tries++;
			user_input=get_user_input();
			up_down(user_input,computer_num,tries);
		}
		else if(user_input<computer_num) {
			System.out.printf("%d트\n",tries+1);
			System.out.println("UP!!!");
			System.out.println("-------");
			tries++;
			user_input=get_user_input();
			up_down(user_input,computer_num,tries);
		}
		else {
			System.out.println("Correct!!");
			System.out.println("With "+(tries+1)+" tries");
		}
	}

	public static void start(int trials) {
		System.out.println("Up Down Game");
		
		int picked_num=random_num();
		int user_num=get_user_input();
		
		up_down(user_num, picked_num, trials);	
	}	
}
	
	


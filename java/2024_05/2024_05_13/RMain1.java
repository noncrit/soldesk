//반복문 이어서
//UP&Down게임
// 1~100 사이의 숫자를 맞추는 게임 - 컴퓨터가 생각한 숫자를 내가 맞추기
//컴퓨터가 뽑아낸 숫자가 내가 입력한 숫자보다 낮으면 Down!
//컴퓨터가 뽑아낸 숫자보다 내가 입력한 숫자가 높으면 Up!
//몇 턴만에 정답을 찾았는지 출력하기
import java.util.Scanner;
import java.util.Random;

public class RMain1 {
	
static Scanner sc=new Scanner(System.in);
static Random r=new Random();
static int glob_counter=0;

	public static void main(String[] args) {
		glob_counter=0;
		start();
	}
	//업다운 게임 숫자 생성
	public static int random() {
		System.out.println("1~100사이의 숫자 하나를 고르는 중입니다.");
		int pikced_num=r.nextInt(100)+1;
		return pikced_num;
	}
	//업다운 게임 유저 추측 입력
	public static int user_guess() {
		System.out.println("컴퓨터가 뽑은 1~100사이의 숫자는 무엇일까요?");
		int user_input=sc.nextInt();
		return user_input;
	}
	//업다운 게임 판정 알고리즘
	public static void decider(int computer_pick, int user_guess_num) {
		if(computer_pick==user_guess_num) {
											glob_counter+=1;
											System.out.println("유저입력 : "+user_guess_num+"\n 정답입니다!");
											
		}
		else if(computer_pick>user_guess_num) {
											glob_counter+=1;
											System.out.println("Up!");
											int new_input=user_guess();
											decider(computer_pick, new_input);				
		}
		else if(computer_pick<user_guess_num) {
											glob_counter+=1;
											System.out.println("Down!");
											int new_input=user_guess();
											decider(computer_pick, new_input);								
		}
		
	}
	//업다운 게임 카운터 출력
	public static void print_count(int counter) {
		System.out.printf("%d 번만에 정답을 찾으셨습니다.",counter);
	}
	public static void start() {
		int computer_num=random();
		int user_num=user_guess();
		decider(computer_num, user_num);
		print_count(glob_counter);
	}
	//for 문 쓴 반복문 only version으로 짜보기
	public static void loop_ver() {
		
	}
	
}

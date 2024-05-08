import java.util.Random;
import java.util.Scanner;
//코드 줄이기 return new Random().nextInt(10) +1; - 요런식으로
public class FMain3 {

Random r=new Random();
	//홀 짝 게임 함수버전
	public static void main(String[] args) {		
		start_game();	
	}
	
	//홀짝게임 진행 함수
	public static void start_game() {		
		String user_input=get_input();
		int outcome_array[]=randomize();
		String result=decide_even_odd(outcome_array);
		cointoss_outcome(outcome_array);
		endgame(result, user_input);		
	}
	
	//동전 10개 던지고 결과 배열을 반환하는 함수
	public static int[] randomize(){
		int outarray[] = new int[10];
		Random r = new Random();
		int token=0; // 나머지가 1인 경우 앞면, 0이면 뒷면
			for (int i=0;i<10;i++) {
				token=(r.nextInt(4)+1)%2;
				outarray[i]=token;
							}
		return outarray;
	}
	
	//동전 던진 결과를 출력하는 함수
	public static void cointoss_outcome(int input[]) {
		System.out.println("동전 던지기 결과(1: 앞면, 0: 뒷면)");
		for(int i=0;i<10;i++) { System.out.printf("%d",input[i]);}
		System.out.println();
		int num_of_odd=0;
		for(int j=0;j<10;j++) {num_of_odd+=input[j];}
		System.out.printf("앞면인 동전  : %d개, 뒷면인 동전 : %d개",num_of_odd,10-num_of_odd);
		System.out.println();
	}
	
	//동전 10개중 앞면인 동전이 홀수/짝수 중 어느것인지 판단하는 함수
	public static String decide_even_odd(int input_array[]) {
		int num_of_odd=0; //앞면
			for(int j=0;j<10;j++){
				num_of_odd=num_of_odd+(input_array[j]%2);
			}
		String result=(num_of_odd)%2!=0?"odd":"even";
		return result;		
	}
	
	//유저의 홀 짝 선택을 입력받고 리턴하는 함수
	public static String get_input() {
		System.out.println("동전 10개를 던졌을 때 앞면이 나온 동전 갯수가 홀수/짝수 중 어디에  해당할까요?");
		System.out.println("홀수는 odd, 짝수는 even을 입력해주세요.");
		//Scanner sc=new Scanner(System.in);
		return new Scanner(System.in).next();
	}
	
	//유저 입력값, 동전 던진 결과값을 받아 홀,짝 중 하나를 출력하는 함수
	public static void endgame(String result, String user_input) {
		System.out.println("유저의 입력 : "+user_input);
		System.out.println("결과값 : "+result);
		if(result.equals(user_input)) {System.out.println("정답!");}
		else {System.out.println("오답!");}
	}
	
}

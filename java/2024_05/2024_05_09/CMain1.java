//5월9일 - 조건문
/*조건문 : 작성한 코드를 조건에 따라 코드의 실행 흐름을 다르게 동작하도록 제어하는 문법
 * 대표적 조건문
 * if : 조건식의 결과가 true/false 로 나눠지고, 그에따라 실행할 문장을 결정함
 * 예시----------------
 * if (조건 A){
 * 				조건 A 만족시 중괄호{}안의 내용 실행, 거짓인 경우 실행하지 않고 뒤쪽 내용 실행
 * }
 * else if (조건 B){
 * 				조건 A 만족시 중괄호{}안의 내용 실행, 거짓인 경우 실행하지 않고 뒤쪽 내용 실행
 * }
 * 
 * else {
 * 			맞는 조건이 하나도 없는 경우 이 부분이 실행됨
 * }
 * --------------------
 * if - if 와 if else의 차이점 
 * if - if : if 문 2개를 각각 다른 조건문으로 인식해서 한번씩은 실행하게됨(비효율)
 * else if : 하나의 조건이 만족되면 나머지 부분은 실행을 생략해버림(조금 더 효율적)
 *
 */
import java.util.Scanner;

public class CMain1 {
static java.util.Scanner sc= new Scanner(System.in); 

	public static void main(String[] args) {
		
		//score_evaluate_better(get_score_korean());
		score_warn(get_score_korean());
		
	}
	
	public static int scan_int() {
		int a=sc.nextInt();
		return a;
	}
	
	//국어 시험 점수를 입력해서 받아오는 함수
	public static int get_score_korean() {
		System.out.println("국어 시험 점수를 입력해주세요");
		int korean_score=scan_int();
		return ((korean_score>=0)&&(korean_score<=100)) ? korean_score : get_score_korean();
	}
	
	//국어 점수가 
	//60점 미만 : 가
	//60점 이상 : 양
	//70점 이상 : 미
	//80점 이상 : 우
	//90점 이상 : 수
	//높은 숫자부터 작성하면 if문 처리순서 때문에 조건문 아낄수 있음 매우 중요!!
	public static void score_evaluate(int score) {
		if(score<60) {
						System.out.println("가");
		}
		else if(60<=score&&score<70) {
								System.out.println("양");
		}
		else if(70<=score&&score<80) {
								System.out.println("미");
		}
		else if(80<=score&&score<90) {
								System.out.println("우");
		}
		else if(90<=score) {
								System.out.println("수");
		}
		else {
				System.out.println("?????");
		}
	}
	public static void score_evaluate_better(int score) {
		if(90<=score) {
						System.out.println("수");
		}
		else if(80<=score) {
								System.out.println("우");
		}
		else if(70<=score) {
								System.out.println("미");
		}
		else if(60<=score) {
								System.out.println("양");
		}
		else if(60>score) {
								System.out.println("가");
		}
		else {
				System.out.println("?????");
		}
	}
	//국어 점수가 50점이 안되면 욕, 아니면 칭찬 + 
	//점수가 50점 이상,60점 미만이면 아쉬운 소리
	//점수가 30점 미만이면 퇴학처리
	public static void score_warn(int score) {
		if(score<50) {
						System.out.println("공부를 안하셨군요?");
						if(score<30) {
							System.out.println("당신은 퇴학입니다.");
						}
		}
		else {
								System.out.println("공부를 하셨군요!");	
								if(score<60) {
									System.out.println("조금만 더했으면...");
								}
		}
		
		
		
	}
}

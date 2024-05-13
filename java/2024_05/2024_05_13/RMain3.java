//반복문 건너뛰기 예시 - continue : 해당 반복턴을 종료하고 다음 턴  수행
import java.util.Scanner;

public class RMain3 {
	public static void main(String[] args) {
		prac3();
	}
	
	//반복문을 10번 돌릴건데 1번 돌릴때마다 안녕하세요 를 3번씩 출력
	public static void prac1() {
		int i=0;
		int j=0;
		while(i<10) {
			System.out.println(i+"번째 출력");
			while(j<3) {
				System.out.println("안녕하세요");
				j++;
			}
			
			i++;
			j=0;
		}
	}
	
	//
	public static void prac2() {
		for(int i=0;i<10;i++) {
			if(i % 2 == 0) {
				System.out.println("와!");
			}
			else {
				//continue;	// 홀수일때는 무시하고 다음 턴 진행한다는 의미
				//break;	// 반복문을 종료하는 가장 공식적인 방법
				//return;	// c언어식 종료법, 어쨌든 반복문 종료는 시킴	
			}
		}
	}
	
	// 어떤 코멘트 내용을 계속 입력받을건데, 내용을 계속 받아올 것 + 출력
	// 만약 ㅎㅇ가 입력이면 반복문 깨버리기
	public static void prac3() {
		Scanner sc=new Scanner(System.in);
		String in=null;
		while(true) {
			System.out.println("---");
			System.out.println("입력 대기중");
			in=sc.next();
			System.out.println(in);
			if(in.equals("ㅎㅇ")) {
				System.out.println("반복문 끝!");
				break;
			}
		}
		
	}
}

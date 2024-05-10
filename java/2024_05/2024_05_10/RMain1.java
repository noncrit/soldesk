import java.util.Random;
//반복문 - 수학적으로 생각 좀 해야함
//어떤 작업을 특정 횟수 or 특정 시점까지 반복할때 사용
//for문 실행 루틴
//변수 초기화 -> 조건식 판단 ->조건식 true 이면 중괄호 내용 실행, false라면 for문 종료후 다음줄 코드 실행 -> 변수의 증감 ->조건식 판단 ....
//반복문 실행부쪽에 변수 선언하는건 매우 비효율적 ->변수 생성을 위한 메모리 할당작업을 루프마다 하게 됨 

public class RMain1 {
	// ㅎ 출력
	public static void main(String[] args) {
		
		Random r=new Random();
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("%s","ㅎ");
		}
		
		System.out.println();
		//5부터 내림차순 출력
		for (int i = 5; i > 0; i--) {
			System.out.printf("%d",i);
		}
		
		System.out.println();
		
		//1~21까지의 자연수중 홀수만 출력하기
		for (int i = 1; i < 12; i++) {
			System.out.printf(" %d ",2*i-1);
		}
		
		System.out.println();
		
		//반복문이 5번 도는 동안 1~10사이의 정수를 랜덤하게 뽑고 싶을때
		for (int i = 0; i < 5; i++) {
			System.out.printf(" %s",r.nextInt(10)+1);	
		}
		System.out.println();
		
		//1+2+3+....+10 더한거 출력
		int sum=0;
		for (int i = 1; i < 11; i++) {
										sum+=i;	
		}
		System.out.println("1to10 sum ="+sum);
		
		//!(팩토리얼 출력)
		int fac=1;
			for (int i = 7; i >0; i--) {
										fac=fac*i;
			
			}
		System.out.println("7! ="+fac);
		
		
		//1~50 사이의 정수 중에서 3의 배수이거나 5의 배수인 수를 모두 더한 값
		int cd_sum=0;
			for (int i = 1; i<51; i++) {
										if(i%3==0) {
													cd_sum+=i;
										}
										else if(i%5==0) {
													cd_sum+=i;
										}
			}
		
		System.out.println("cd_sum ="+cd_sum);
		
		
	}
}

/*함수 (메서드)
*관련있는 작업을 묶어놓은 객체(캡슐화)
*내가 필요로 할 때마다 호출해서 사용이 가능
*JDK 부가 설명
*JDK안에 JRE(Java Running Environment)가 기본으로 내장되어있음
*JRE는 운영체제에 맞춰서 JVM을 구동시킴
*JVM은 운영체제에 상관없이 동일한 코드 구동을 위해 일종의 가상머신으로 기능함->그래서 좀 무거움
*이 장점을 WORA(Write Once Read Anywhere) 라고 표현함 -> 호환성이 매우 좋은편
*그래서 OS별로 따로 코드를 짤 필요가 없어짐
*코드 실행시 JVM은 main 함수를 자동으로 호출함
*main 자체도 함수임
*/
import java.util.Scanner;
public class FMain{

/*함수의 형태
*  public static 리턴타입 함수명(파라미터 ..., 파라미터 ...){
*					내용... 
						return		}
*return : 함수가 호출 되었을 때 반환되는 최종 결과값의 자료형
*
*함수명 : 함수의 이름/ 변수명과 마찬가지로 몇가지 조건을 만족해야함
*	1. 숫자로 시작 불가->에러발생
*	2. 특수문자, 띄어쓰기 불가능-> 에러발생
*	3. 자바 예약어 사용불가->에러 발생( _ 사용으로 회피가능)
*	4. 다른 사람이 함수명을 봐도 기능을 파악 가능하게 작명하는게 좋음
*	5. 함수명 첫글자는 소문자
*	6. 띄어쓰기는 뱀체(_), 낙타체(AppleJuice)
*	7. 자바의 공용어는 영어
*변수명 - 명사 처럼 // 함수명 - 동사처럼	
*
*파라미터(parameter, 인자) : 함수를 실행할 때 필요한 재료를 명시한 것
*함수에서 필요한 만큼 끌어다 쓰면 된다 / 대신 자료형을 맞춰줘야함
*/	

// 자기소개하는 함수 (이름, 핸드폰 번호, 사는 곳 출력)
	public static void introduce_myself() {
		System.out.println("이름 : 김석진");
		System.out.println("핸드폰 번호 : 000-0000-0000");
		System.out.println("사는 곳 : 평택");
		
	}

// 정수 2개를 넣으면 그 두개의 사칙연산 결과를 출력하는 함수
	public static void calc(){
		Scanner key_in=new Scanner(System.in);
		int in_a=0;
		int in_b=0;
		
		System.out.println("정수 a를 입력하세요.");
		in_a=key_in.nextInt();
		
		System.out.println("정수 b를 입력하세요.");
		in_b=key_in.nextInt();
		
		System.out.printf("a+b = %d\n",in_a+in_b);
		System.out.printf("a-b = %d\n",in_a-in_b);
		System.out.printf("axb = %d\n",in_a*in_b);
		System.out.printf("a/b = 몫 :%d, 나머지 : %d\n",(in_a/in_b),(in_a%in_b));
		System.out.printf("a/b = 몫 :%.2f\n",(double)((double)in_a/(double)in_b));
	}
	
	
	public static void printMyThink() {
		System.out.println("집에 가고 싶다");
		System.out.println("점심 뭐 먹지");
		System.out.println("비 와서 지각 할 뻔");
		System.out.println("신논현역은 급행열차 우선 정차역");
	}
	
	public static void main(String[] args) {
		//지금 당장 생각하고 있는 내용을 출력
		//printMyThink();
		//introduce_myself();
		calc();
	}

}
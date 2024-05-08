//variable class
public class VMain {
	public static void main(String[] args) {
		
		/* 컴퓨터의 장치
		 * CPU, RAM, HDD, GPU 등등
		 * CPU : 사람의 뇌에 해당하는 연산장치
		 * HDD(SSD) : 영구적 주기억장치, 파일의 형태로 저장
		 * RAM : 휘발성 주기억장치, 변수의 형태로 저장
		 * GPU : 그래픽 연산 처리장치, 연산 보조 역할도 수행함
		 * ex) syso로 글자나 숫자를 출력할 경우->수행된 작업은 휘발성 연산(저장되지 않음)
		 * 결과값이 저장될 필요가 있는 경우 변수에 할당해서 사용
		 * 변수(Variable) : 데이터를 저장하는 공간
		 * 변수 문법
		 * 1. 변수 선언	- RAM에 공간 할당 선언 (자료형 변수명;)
		 * 2. 변수 초기화	- 선언된 변수에 값을 넣는 작업 (변수명=값;)
		 * 자료형 - 변수가 저장될 형태를 지정(문자, 숫자(정수인지 실수인지), 등등)
		 * 변수명 - 변수의 이름
		 * ex) string s; , int i;
		 * 변수 선언과 초기화 동시에 가능 ex) int i = 1;
		 * 
		 * 변수명 설정시 규칙(?) 
		 * 1. 변수의 이름은 숫자로 시작 할 수 없음
		 * 2. 변수명에 특수문자, 띄어쓰기 사용 불가능
		 * 3. 변수명에 자바 문법(예약어) 사용불가능
		 * Java 관습
		 * 4. 변수명은 변수 역할이 무엇인지 알아먹을 수 있게 설정하기
		 * 5. 가독성을 위해 띄어쓰기 필요한 경우 _ 사용	ex) int price_of_computer=100000;
		 * 아니면 볼드체 방식(낙타체) 					ex) int priceOfComputer=100000;
		 * 6. 코드 부분에 한글 안씀
		 *
		 * '=' 의 기능 : 대입연산자 - 오른쪽 값을 왼쪽에 할당(대입)
		 * 
		 * 자료형 
		 * 컴퓨터의 단위 크기 
		 * Bit : 데이터를 나타내는 최소 크기(Binary Digit 0,1) - 2가지 표현가능
		 * ex) 8-bit -> 01010101 
		 * 1 Byte == 8 Bit
		 * 
		 * 자료형 세부사항
		 * 기본형
		 * 	정수 : 	byte(8bit)	-2^7~2^7 
		 * 			short(16bit)	-2^15~2^15 
		 * 			int(32bit)	-2^31~2^31
		 * 			long(64bit)	-2^63~2^63
		 * 가장 왼쪽 비트 (MSB : Most Significant Bit) : 부호비트 0이면 양수, 1이면 음수
		 * 
		 * 	실수	:	float(32bit)
		 * 			double(64bit) -> java에서 주로쓰는 자료형
		 * 	문자	:	char(16bit)
		 * 	논리	:	boolean(8bit) - true/false
		 * 	void:	리턴 타입이 없음을 나타냄
		 * 
		 * 참조형 : 기본형외의 모든 자료형
		 * 	문자열 : String - 여러 글자를 저장, 반드시 맨앞에 대문자 S
		 * 	char과 String 의 차이점
		 * 	char - 한 글자를 저장, 할당시 작은 따옴표 사용 ex) char s = 'z';
		 * 	String - 문자열을 저장, 큰 따옴표 사용
		 */
		
		//변수 실습 현재 층수 6, 손가락 10개 선언해보기 (선언과 초기화 따로)
		int current_floor, num_of_fingers;
		current_floor=6;	num_of_fingers=10;
		
		int num=10; //(선언, 초기화 동시에)
		int subway=9;
		double subway2=9;
		System.out.println(subway);
		System.out.println(subway2);
		
		//변수값 수정 -> a=10; 이런식
		
		//나중에 배울 파이썬 -> 상대적으로 고급언어 - 변수 자료형 할당을 상당부분 알아서 처리해줌
		//변수끼리도 계산가능
		System.out.println(subway+subway2);
		
		/*RAM 메모리 영역 저장방식 설명
		 * Text, Data 
		 * Stack :	프로그램이 종료되면 자동으로 정리
		 * 			아래부터 쌓이는 방식(push & pop)
		 * Heap	 :	프로그램이 종료되어도 남아있음, 컴퓨터가 임의로 판단해서 공간 할당(동적 할당 영역)
		 * 자바의 경우 Garbage Collecter 가 알아서 Heap 정리함
		 */
		
		int price = 7000;
		String menu = "짜장면";
	}
}

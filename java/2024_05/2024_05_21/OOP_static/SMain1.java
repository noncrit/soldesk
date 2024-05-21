//static 에 관한 내용

//static method -> 객체를 선언하지 않고도 메소드 사용가능, 단 static 이 아닌 멤버 변수에는 접근 불가능(객체를 만들어야 간접적으로 참조가능)
//메모리 영역 할당 순서
//1. 기계어 상태의 소스가 static 영역에 할당
//2. static 멤버 변수들이 static 영역에 배치
//3. JVM이 main 을 호출
//4. 실행
public class SMain1 {
	
	public static void main(String[] args) {
		//과자 객체를 만들어보자 + 출력 기능
		//과자 이름 중량 가격
		
		//static 이라 접근 가능
		System.out.println(Snack.MANUFACTUERER);
		System.out.println("---------------------");
		
		//객체를 이렇게 끌어오지 않는한, main에는 과자의 이름, 무게, 가격 모름 / 단 생산자는 static이라 알고있음
		//
		Snack s1 = new Snack("허니버터칩", 100, 2000);
		
		s1.print();
		
		System.out.println("------------------------");
		
		Snack s2 = new Snack("이구동성", 60, 1500);
		//static 변수를 건드리면? -> static으로 선언된 변수라 건드는대로 바뀜
		//수정 불가 제약을 걸어주려면 final ->최초 초기화 값으로 상수화시킴(보통 대문자로 표현해줌)
		
		s2.print();
		
		Snack.print_taste();
		
	}
}

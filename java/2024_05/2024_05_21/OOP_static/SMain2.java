//계산기
// 정수 2개를 넣으면 그 합을 출력하는 기능

public class SMain2 {
	
	public static void main(String[] args) {
		
		Calc c= new Calc();
		c.sum(3,4); 		//static
		c.sum(1,2,3);		// non static
		
		Calc.sum(30, 30);	//static -> 굳이 객체 선언 안하고 static 메소드 그냥 끌어왔음 -> 메모리 좀 아꼈음
		
		//같은 맥락으로 자바 기본 내장 클래스 Math 라이브러리 또한 객체를 만들지 않고도 사용가능(메소드가 대부분 static으로 선언되어있음)
		System.out.println(Math.PI);
	}
	
}

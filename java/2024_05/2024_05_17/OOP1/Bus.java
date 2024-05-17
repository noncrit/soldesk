//자바에서 함수는 method임
//function -> 클래스 블록 외부에 만든 것 : 자바에서는 원칙적으로 클래스 블록 안에서만 코드 작성가능
//그래서 function 자체는 java에 존재하지 않음
//method -> Class 안에 속한 함수(class에 종속적인 함수)
//지금까지 쓴 것은 다 메소드임
//method - class에서 필요한 액션, 프로그램 상 필요한 기능 구현 => 객체의 동작에 해당하는 실행 블록

public class Bus{
		
		String bus_num;
		String type_of_car;
		String enterprise;
		String name_of_driver;
		String start_location;
	
	public void printInfo() {
		//this -> 자기 자신을 말함 : 생략도 가능함
		System.out.println(this.bus_num);
		System.out.println(this.enterprise);
		System.out.println(this.name_of_driver);
		System.out.println(this.start_location);
		System.out.println(this.type_of_car);
	}
	
		
	
	public void go() {
		System.out.println("부릉부릉");
	}
	
	
}



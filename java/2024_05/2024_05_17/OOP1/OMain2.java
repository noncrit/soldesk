//Java: 완벽한 객체지향 언어(구조상)
//c++,Python : Hybrid 객체지향언어

//실생활 묘사->보기쉽고, 유지보수 쉬워짐

//*** 무언가를 표현하고 싶을때는 항상 클래스를 새로 만들자!!!
//클래스-> 굳이 주석을 안달아도 직관적으로 보임

public class OMain2 {
	
	public static void main(String[] args) {
	//버스를 Java 로 표현하기
	//버스 번호/ 차종 / 버스 회사/ 기사님 이름/ 시작점 을 출력하기
		
		Bus b=new Bus(); // b : 객체, 인스턴스 - 선언된 클래스를 참조하는 참조변수(?)
		
		b.bus_num="19가 7892";
		b.enterprise="동양고속";
		b.name_of_driver="철수";
		b.type_of_car="대형 버스";
		b.start_location="고속 버스 터미널";
		
		b.printInfo();
		/*
			System.out.println(b.bus_num);
			System.out.println(b.enterprise);
			System.out.println(b.name_of_driver);
			System.out.println(b.start_location);
			System.out.println(b.type_of_car);
		*/
		
		System.out.println("----------");
		
		Cellphone c= new Cellphone();
		
		c.maker="LG";
		c.model="V40";
		c.price=200000;
		c.print_info();
		c.ringing();
		System.out.println("=======");
		
		Cellphone c2=c;
		
		System.out.println(c);	// 위 아래가 주소가 같음 c2 메모리를 따로 선언한게 아니라 그냥 c를 참조하는 참조변 c2수가 선언됨
		System.out.println(c2); // c2 값 바꾼게 그대로 반영이 되어버림
								// = 연산자로는 완전한 복사가 불가능
								// 무조건 new 어쩌구로 생생해야 복사랄 수 있음
		
		c2.price=85000;
		c2.print_info();
		c.print_info(); // c도 price가 같이 바뀌어 버림
		
		
	}
	
}

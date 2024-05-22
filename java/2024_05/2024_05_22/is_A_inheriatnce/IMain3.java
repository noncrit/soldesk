//홍길동, 17살, 논현고등학교, 1학년 => 출력
//김길동, 21살, 서울대학교, 2학년 => 출력
//고길동, 22살, 육군, 상병 => 출력

//constructor
//클래스에 생성자가 하나도 없으면 컴파일러가 기본 생성자를 하나 알아서 만들어줌
//하위 클래스 객체를 만들면(Pen) 상위 클래스(Product2) 기본 생성자를 기본으로 호출함

//****************************************************************************

public class IMain3 {
	
	public static void main(String[] args) {
		
		Student hong = new Student("홍길동",17,"논현고등학교",1);
		Student kim = new Student("김길동", 21, "서울대학교", 2);
		Soldier go = new Soldier("고길동", 22, "육군", "상병");
		
		hong.print_Person();
		
		kim.print_Person();
		
		go.print_Person();
		
		Pen p = new Pen();					//제품 가격 null
		System.out.println("---");
		Pen p2 = new Pen("빨강");				//제품 가격 빨강
		System.out.println("---");
		Pen p3 = new Pen("모나미",300,"검정");	//아무것도 안나옴
		////super(name, price)의 경우 super의 파라미터에 값을 입력했기에, 오버 로딩된 생성자를 참조하게 되고,
		//따라서 기본 생성자가 자동으로 생성되지 않음
		
		Mask mask= new Mask("패션마스크", 1000);
		mask.print_Product();
		
	}
}

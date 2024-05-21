//신발 객체 만들기
//나이키 홈페이지
//이름, 사이즈, 가격, 브랜드
//정보 출력까지

//생성자(Constructor)
//객체가 만들어질때 뭔가 작업을 해야 하는데... 그게 바로 생성자 만들기
//생성자 특징 : 리턴 없음, 메소드명이 클래스 이름과 동일함
//생성자를 만들지 않으면 자바의 컴파일러가 기본 생성자를 그냥 알아서 생성해버림
//생성자를 조금 건드리면? -> 컴파일러가 디폴트 생성자를 안 만들어줌 ->기본 생성자 조차 안 만들어짐

public class CMain1 {

	public static void main(String[] args) {
		
		
		
		Shoes Airzoom = new Shoes("에어줌", 260, 1300000);
		Shoes Challange_pro= new Shoes("챌린지 프로",260, 1390000);
		
		Airzoom.print_info();
		/*
		System.out.println("----------------------");
		
		
		Challange_pro.name="챌린지 프로";
		Challange_pro.price=139000;
		Challange_pro.size=260;
		Challange_pro.print_info();
		
		/*
		Coffee c= new Coffee("루왁",20000);
		c.print();
		*/
	
	}
	
	
}


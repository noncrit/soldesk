//멤버 변수 : 객체의 속성(객체.attribute 형태로 지정해서 사용함), this는 인접한 객체를 뜻함(생략가능)
//이 세상 모든 과자를 김비버가 만든다고 하면??? -> static 멤버변수
//객체가 없어도 사용 가능한 정보 -> 클래스명.xxx으로 사용
//객체들의 공통된 속성을 정보로 넣어줄 수 있음, 객체를 여러 개 찍어내도 static 멤버변수는 하나만 만들어 놓으면 모든 객체에 적용됨->메모리 절약
//static 영역의 데이터(메모리 체계에서 데이터 영역) -> 프로그램이 종료되야 메모리가 회수됨 -> 남용하면 메모리 관리에 매우 안좋음

public class Snack {
	
	String name;
	double weight;
	int price;
	
	static final String MANUFACTUERER="김비버";
	
	public Snack(String name, double weight, int price) {
		this.name=name;
		this.weight=weight;
		this.price=price;
	}
	
	public void print() {
		
		System.out.println("제품명 : "+this.name);
		System.out.println("가격 : "+this.price);
		System.out.println("용량 : "+this.weight);
		System.out.println("생산자 : "+this.MANUFACTUERER);
	}
	
	public static void print_taste() {
		
		System.out.println("맛있다");
		
	}
}

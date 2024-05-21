
public class Shoes {

	String name;
	int size;
	int price;
	static final String brand="나이키";
	
	//우클릭으로 생성한 오버로딩된 생성자
	public Shoes(String name, int size, int price) {
		//super();	//shoes의 상위 객체, OBJECT의 기본 생성자를 불러옴
		this.name = name;	//생성자에서는 this 생략하면 큰일남, this 안 붙이면 
		this.size = size;	
		this.price = price;
	}
	
	//생성자 오버로딩
	//Shoes s3 = new Shoes("신발",250,30000);


	public void print_info() {
		
		System.out.printf("제품명	: %s\n",name);
		System.out.printf("사이즈	: %d\n",size);
		System.out.printf("가격	: %d\n",price);
		System.out.printf("브랜드	: %s\n",brand);
		
	}
	/*
	public void test(String name) {
		//멤버 변수와 파라미터명이 같다면?
		System.out.println(name);
		System.out.println(this.name);	//***this가 붙으면 주조건 멤버 변수***
										//안붙이면 제일 가까운 것
	}
	*/
}

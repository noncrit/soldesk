//모든 클래스는 Object를 상속하고 있음(표기 생략) - 즉, Product는 기본적으로 Java의 객체임
public class Product {
	String name;
	int price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void print_Product() {
		
		System.out.println("--=-=-=-=-=-=-=-=-=-");
		System.out.printf("제품명	:	%s\n",this.name);
		System.out.printf("가격	:	%d\n",this.price);
	}
	
}

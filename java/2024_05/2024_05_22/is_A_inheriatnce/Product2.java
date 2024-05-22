public class Product2 {
	String name;
	int price;
	
	public Product2() {
		// TODO Auto-generated constructor stub
		System.out.println("Product (2)!!");
	}

	public Product2(String name, int price) {
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


public class Coffee {

	String name;
	int price;
	
	public Coffee(String name, int price) {
		
		this.name = name;
		this.price = price;
	}

	public void print() {
		
		System.out.printf("제품명 : %s\n",name);
		
		System.out.printf("가격 : %d\n",price);
		System.out.println("-------------------");
	}
	
}

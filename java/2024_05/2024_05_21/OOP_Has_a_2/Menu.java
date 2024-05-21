
public class Menu {
	String name;
	int price;
	Store selling_place;
	
	
	public Menu(String name, int price, Store selling_place) {
		super();
		this.name = name;
		this.price = price;
		this.selling_place = selling_place;
	}
	
	public void print_Menu_info() {
		
		System.out.printf("이름	: %s\n",this.name);
		System.out.printf("가격	: %d\n",this.price);
		System.out.printf("판매처	: %s\n",this.selling_place.name);
		System.out.println("▼연관된 정보▼");
		selling_place.print_Store_info();
		System.out.println("---");
	}
	
	
}

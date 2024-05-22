
public class Shoes extends Product{
	int size;
	
	public Shoes() {
		// TODO Auto-generated constructor stub
	}

	public Shoes(String name, int price, int size) {
		super(name, price);
		this.size = size;
	}
	
	@Override
	public void print_Product() {
		// TODO Auto-generated method stub
		super.print_Product();
		System.out.printf("사이즈	:	%d\n", this.size);
	}
	
	
}

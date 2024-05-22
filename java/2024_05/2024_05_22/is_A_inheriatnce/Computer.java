
public class Computer extends Product {
	String cpu;
	int ram;
	int hdd;
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}

	public Computer(String name, int price, String cpu, int ram, int hdd) {
		super(name, price);
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
	
	@Override
	public void print_Product() {
		// TODO Auto-generated method stub
		super.print_Product();
		System.out.printf("CPU	:	%s\n", this.cpu);
		System.out.printf("RAM	:	%d GB\n", this.ram);
		System.out.printf("HDD	:	%d GB\n", this.hdd);
	}
	
	
	public void print_Product_Com() {
		// TODO Auto-generated method stub
		super.print_Product();
		System.out.printf("CPU	:	%s\n", this.cpu);
		System.out.printf("RAM	:	%d GB\n", this.ram);
		System.out.printf("HDD	:	%d GB\n", this.hdd);
	}
	
}

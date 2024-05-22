
public class Laptop extends Computer{
	int weight;
	int battery_duration;
	
	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(String name, int price, String cpu, int ram, int hdd, int weight, int battery_time) {
		super(name, price, cpu, ram, hdd);
		this.weight = weight;
		this.battery_duration = battery_time;
	}
	
	@Override
	public void print_Product() {
		// TODO Auto-generated method stub
		super.print_Product_Com();

		System.out.printf("무게	:	%d g\n", this.weight);
		System.out.printf("배터리 지속시간:	%d hour\n", this.battery_duration);
		
	}
	
}

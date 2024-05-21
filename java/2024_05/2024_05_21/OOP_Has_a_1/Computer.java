
public class Computer {
	
	String cpu;
	int ram;
	int hdd;
	Company brand;
	
	public Computer(String cpu, int ram, int hdd, Company brand) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
		this.brand = brand;
	}




	public void print() {
		
		System.out.printf("CPU : %s\n",this.cpu);
		System.out.printf("RAM : %sGB\n",this.ram);
		System.out.printf("HDD : %sGB\n",this.hdd);
	}	
	
	

}

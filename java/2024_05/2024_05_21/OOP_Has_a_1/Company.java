
public class Company {
	
	String name;
	String location;
	int num_of_worker;
	
	public Company(String name, String location, int num_of_worker) {
		super();
		this.name = name;
		this.location = location;
		this.num_of_worker = num_of_worker;
	}
	
	public void print() {
		
		System.out.printf("회사명 : %s\n",this.name);
		System.out.printf("위치 : %s\n",this.location);
		System.out.printf("직원수 : %d\n",this.num_of_worker);
	}
	
	

}

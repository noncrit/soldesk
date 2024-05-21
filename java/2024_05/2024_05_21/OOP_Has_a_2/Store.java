
public class Store {
	String name;
	String location;
	String p_num;
	Person owner;
	
	
	public Store(String name, String location, String p_num, Person owner) {
		super();
		this.name = name;
		this.location = location;
		this.p_num = p_num;
		this.owner = owner;
	}




	public void print_Store_info() {
		
		System.out.printf("이름	: %s\n",this.name);
		System.out.printf("전화번호	: %s\n",this.p_num);
		System.out.printf("소유자	: %s\n",this.owner.name);
		System.out.println("▼연관된 정보▼");
		owner.print_Person_info();
		System.out.println("---");
	}
	
	
	
}

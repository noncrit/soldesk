
public class Person {
	String name;
	String sex;
	String p_num;
	Market favorite;
	
	
	public Person(String name, String sex, String p_num) {
		super();
		this.name = name;
		this.sex = sex;
		this.p_num = p_num;
	}
	
	public void print_Person_info() {
		
		System.out.printf("이름	: %s\n",this.name);
		System.out.printf("성별	: %s\n",this.sex);
		System.out.printf("연락처	: %s\n",this.p_num);
		System.out.println("---");
	}
	
	
}

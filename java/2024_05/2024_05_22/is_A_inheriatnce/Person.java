
public class Person {
	String name;
	int age;
	String affiliation;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}


	
	public Person(String name, int age, String affiliation) {
		super();
		this.name = name;
		this.age = age;
		this.affiliation = affiliation;
	}



	public void print_Person() {
		
		System.out.println("-=-=-=-=-=-=-=-=-=-");
		System.out.printf("이름 :	%s\n",this.name);
		System.out.printf("나이 :	%d\n",this.age);
		System.out.printf("소속 :	%s\n",this.affiliation);
	}
}

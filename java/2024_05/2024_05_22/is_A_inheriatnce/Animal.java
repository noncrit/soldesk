
public class Animal {

	String species;
	int age;
	
	//기본 생성자
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	//오버로딩
	public Animal(String species, int age) {
		super();
		this.species = species;
		this.age = age;
	}

	public void print_info_Animal() {
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-");
		System.out.printf("종 : %s\n",this.species);
		System.out.printf("나이 : %d\n",this.age);

	}
}


public class Dog extends Animal {
	
	String inhabit;
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(String species, int age, String inhabit) {
		super(species, age);
		this.inhabit = inhabit;
	}
	
	@Override	//주의점 : 상속받은 Class 에서의 메소드 이름과 같아야 사용가능
	public void print_info_Animal() {
		// TODO Auto-generated method stub
		super.print_info_Animal();	//강아지의 상위클래스(Animal)의 print_info_Animal을 실행한다는 뜻
		System.out.printf("서식지 : %s",inhabit);
	}
	
}

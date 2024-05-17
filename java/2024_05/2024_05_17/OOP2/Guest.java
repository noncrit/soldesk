import java.util.Scanner;

public class Guest {

	String name;
	int age;
	Scanner mouth=new Scanner(System.in);
	double height;
	double weight;
	double bmi;
	String bmi_result;
	
	public void print_guest() {
		
		System.out.println("손님 이름 : "+this.name);
		System.out.println("나이 : "+this.age);
		
	}
	
	public int guest_get_in(String called_name,String guest_name) {
		
		if(called_name.equals(guest_name)) {
			System.out.println("안녕하세요");
			return 0;
		}
		else return 1;
	}
	
	public double guest_provide_height() {
		
		System.out.println("저의 키는 [  ]cm입니다.");
		this.height=mouth.nextDouble();
		while(this.height<1 || this.height>300) {
			System.out.println("제대로 된 수치를 말씀해주세요.");
			this.height=mouth.nextDouble();
		}
		return this.height;
	}
	
	public double guest_provide_weight() {
		
		System.out.println("저의 몸무게는 [  ]kg입니다.");
		this.weight=mouth.nextDouble();
		while(this.weight<1 || this.weight>200) {
			System.out.println("정확한 수치를 말씀해주세요.");
			this.weight=mouth.nextDouble();
		}
		return this.weight;
	}
}

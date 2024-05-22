
public class Student extends Person{
	
	int grade;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, String affiliation, int grade) {
		super(name, age, affiliation);
		this.grade = grade;
	}
	
	@Override
	public void print_Person() {
		// TODO Auto-generated method stub
		super.print_Person();
		System.out.printf("학년 :	%d\n",this.grade);
		
	}

}

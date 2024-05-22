
public class Soldier extends Person {
	
	
	String	rank;
	
	public Soldier() {
		// TODO Auto-generated constructor stub
	}

	public Soldier(String name, int age, String affiliation, String rank) {
		super(name, age, affiliation);
		this.rank = rank;
	}

	@Override
	public void print_Person() {
		// TODO Auto-generated method stub
		super.print_Person();
		System.out.printf("계급 :	%s\n",this.rank);
	}
}

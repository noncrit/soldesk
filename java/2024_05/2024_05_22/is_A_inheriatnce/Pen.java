
public class Pen extends Product2 {
	String color;
	
	
	public Pen() {
		// TODO Auto-generated constructor stub
	}


	
	
	public Pen(String color) {
		super();
		this.color = color;
	}
	
	//****************************************************************************
	//super(name, price)의 경우 super의 파라미터에 값을 입력했기에, 오버 로딩된 생성자를 참조하게 되고,
	//따라서 기본 생성자가 자동으로 생성되지 않음
	public Pen(String name, int price, String color) {
		super(name, price);
		this.color = color;
	}
	
	
	
}

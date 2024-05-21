//Candy has a Company : 사탕의 속성에 제조사가 있다
//Company has a Candy : 회사에 속하는 사탕 제품이 있다
//주어를 기준으로
public class Candy {
	String name;
	String flavour;
	Company brand;	//중요!!
	
	//컨 쉬프트 스페이스 - 생성자 오버로딩

	public Candy(String name, String flavour) {
		super();
		this.name = name;
		this.flavour = flavour;
	}

	public void print() {
		
		System.out.printf("제품명 : %s\n",this.name);
		System.out.printf("맛 : %s\n",this.flavour);
	}
	
}

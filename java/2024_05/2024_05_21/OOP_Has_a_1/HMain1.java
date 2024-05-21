//OOP
//static - 메모리 영역에 대한 지식이 꽤 필요함
//생성자
//객체들간의 관계
//A has a B : 사람 has a 핸드폰
//A is a B	: 개 is a 동물	

public class HMain1 {
	
	public static void main(String[] args) {
		//이름이 청포도, 맛 청포도 맛인 사탕
		//출력
		
		Candy c=new Candy("청포도","청포도맛");
		c.print();
		
		System.out.println("----------------------");
		
		//이름이 롯데, 위치는 잠실, 직원수 100명인 회사
		//출력
		
		Company co= new Company("롯데", "잠실", 100);
		co.print();
		System.out.println("----------------------");
		
		//청포도 사탕을 롯데에서 만들었다? 
		c.brand=co;
		
		//청포도 사탕 제조사의 정보를 출력
		c.brand.print();
		
		System.out.println("========");
		//회사 이름은 삼성 위치는 수원 직원수 300명
		//출력
		Company s= new Company("삼성", "수원", 300);
		s.print();
		
		System.out.println("========");
		//CPU가 i-12345, RAM 32 GB, HDD 500GB 인 컴퓨터
		//컴퓨터와 / 회사 정보를 출력
		Computer com=new Computer("i-12345",32,500,s);
		
		com.print();
		System.out.println("========");
		com.brand.print();
		
	}
	
}

// A is B 상속 관계
// 쇼핑몰 - '상품' 에 대한 정보를 게시하고 싶음
// 신발 (이름, 가격, 사이즈)
// 출력

// 컴퓨터 ( 이름, 가격, cpu, ram, hdd)
// 출력

// 노트북 (이름, 가격, cpu, ram, hdd, 무게, 배터릴 지속시간)
public class IMain2 {
	
	public static void main(String[] args) {
		
		Shoes s = new Shoes("슬리퍼",3000,260);
		Computer c = new Computer("컴퓨터",510000,"i7-12345",16,500);
		Laptop l= new Laptop("노트북",810000,"i7-12345",16,500,600,8);
		
		s.print_Product();
		
		c.print_Product();
		
		l.print_Product();
		
		
	}

}

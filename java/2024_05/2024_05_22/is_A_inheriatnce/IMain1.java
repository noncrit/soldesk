// 동물에 대한 객체를 찍어낼수 있는 틀
// 동물의 종류, 나이 -> 출력 할 수있는 기능
//이번에는 A is a B 관계 : 상속 (참고 : A has a B - 포함)
//extends (상속)
//@Override (annotaion => 어떤 기능을 자동으로 연결 할 때 사용) - override ->상속받은 것의 내용을 바꾸거나 기능을 추가하겠다.
//주의점 : 상속받은 Class 에서의 메소드 이름과 같아야 사용가능

//상속받은 클래스의 속성에 더해 자식 클래스 고유의 속성도 따로 선언 할 수 있음 - 그래서 inheritance 가 아니라 extends로 표현함

//	Override	:
//	Overloading	: 여러 개의 메소드가 같은 기능을 한다면 메소드 이름을 같게해서 일관성을 높이자. 
//	1. 파라미터의 자료형이 다르거나, 2. 요구하는 갯수가 다른경우
public class IMain1 {
	
	public static void main(String[] args) {
		
		Cat c = new Cat();		//Animal을 상속받았기 때문에 Cat에 따로 뭐 선언 안했음
		c.print_info_Animal();	//Animal - 부모(상위) 클래스 / Cat - Animal을 상속받은 자식(하위) 클래스
		
		Dog d = new Dog("포메", 4, "집");
		d.print_info_Animal();
	}
	
}

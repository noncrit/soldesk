	//초기값이 설정되지 않은 멤버 변수는 객체 생성시 자동으로 기본초기값으로 설정됨
	//멤버 변수(필드): 객체의 데이터가 저장되는 공간 - 변수와 비슷하지만 변수는 아님
	//변수	:	생성자, 메소드 내부에서만 사용, 실행이 끝나면 자동으로 할당된 자원이 회수됨
	//필드	:	생성자, 메소드 전체에서 사용이 가능, 객체가 소멸되지 않는 한 객체와 함께 공존
//지금 만든 클래스를 라이브러리용 클래스(or API : Application Program interface)라고 부름
//다른 Class에서 이용할 목적으로 만든 Class
//프로그램에서 실행되는 Class가 여러개라면, 그 중 단 하나를 빼고는 전부 라이브러리 용도임
//단 하나 => 실행용 클래스(보통은 main 들어간 클래스)
public class Student {

	String name;
	String address;
	
	//객체 출력 메소드(객체의 동작을 구현하는 실행 블록)-동사처럼 이름짓기
	//메소드를 호출시 해당 메소드 영역안의 모든 코드를 일괄적으로 실행함
	//메소드는 객체간의 데이터 전달수단으로도 이용됨
	public void print_student() {
		
		System.out.println("이름 : "+name);
		System.out.println("주소 : "+address);
		
	}
	
}

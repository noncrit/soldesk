//이름, 사는곳, 속성을 가진 학생 객체
// 속성을 출력하는 기능까지
//main 이 들어가있는 class => 프로그램 실행을 위한 main() method를 제공하는 역할
public class OMain4 {
	
	public static void main(String[] args) {
	
		Student k=new Student();	//k가 Student 객체를 참조
		Student n=new Student();
		k.address="경기도";
		k.name="민수";
		n.name="철수";
		n.address="서울";
		
		k.print_student();
		System.out.println(k);
		System.out.println("------");
		n.print_student();
		System.out.println(n);
		//결과를 보면 k,n은 서로 독립적인 주소를 할당받은 것을 볼 수 있음
	}
}

/* 지역변수/전역변수
 * 지역변수 : 함수 내에서 만든 변수, 그 함수 안에서만 사용가능
 * 즉, 같은 공간(scope)안에서는 같은 변수명을 선언 할 수 없다.
 *
 */
public class FMain2 {
	
	//파라미터의 값을 먼저 불러온 뒤, 함수 내부 처리를 시작함 ->파라미터 b가 스택에 먼저 할당됨
	public static void test(int b) {
		int a=123;
		System.out.println(b); //30
		System.out.println(a+b); //153
	}
	
	
	public static void main(String[] args) {
		int a=10;
		int b=20;
		int c=30;
		test(c); 
		System.out.println(b);
	}
}
//30
//153
//20
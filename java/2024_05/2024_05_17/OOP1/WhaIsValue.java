//자료형들의 기본값을 멤버 변수로 만들어서 그것들을 출력하는 메소드 생성
public class WhaIsValue {

	String stringfield;
	int [] array;
	int int_field;
	double double_field;
	float float_field;
	boolean bool_field;
	long long_field;
	byte byte_field;
	char char_field; //기본형이 공백 1칸임 (유니코드라서 \u0000)
	
	public void printer_value() {
		
		System.out.println("String : "+stringfield);
		System.out.println("int : "+int_field);
		System.out.println("int array : "+array);
		System.out.println("double : "+double_field);
		System.out.println("float : "+float_field);
		System.out.println("boolean : "+byte_field);
		System.out.println("long : "+long_field);
		System.out.println("byte : "+byte_field);
		System.out.println("char : "+char_field);
	}
}

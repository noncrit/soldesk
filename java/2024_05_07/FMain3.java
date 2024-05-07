
public class FMain3 {
	
	public static void test(int q) {
		System.out.println(q); //10(blue/q)
		q=20; //blue_q=20;
		System.out.println(q); //20
	}
	
	
	public static void main(String[] args) {
		int q=10; //지역변수 q(red/q)
		System.out.println(q); //10(red/q)
		test(q);	//파라미터에 q=10 값을 복사해 함수 호출(blue/q)
		System.out.println(q); // 10 (red_q)
	}
}

//10,10,20,10
//shift 연산자 3<<1
//bitwise 연산 - 빈칸에는 0 채움
// 11<1 == 110 -> 6
//조건설정같은거 할 때 써먹을 수 있음 (index로 써먹을수있음)
// 1<<0
// 1<<1 1<<2
public class PMain2 {
	
	public static void main(String[] args) {
		
		int button1 =10;
		if(button1>= (1<<3) ) {
			System.out.println("흡연실");
			button1 -= ( 1<<3 );
		}
		if(button1>= (1<<2) ) {
			System.out.println("WIFI");
			button1 -= ( 1<<3 );
		}
		if(button1>= (1<<1) ) {
			System.out.println("주차장");
			button1 -= ( 1<<3 );
		}
		if(button1>= (1<<0) ) {
			System.out.println("24시간");
			button1 -= ( 1<<3 );
		}
		System.out.println("--------------");
		
		int button2=13;
		String option[]= {"24시간", "주차장", "WIFI", "흡연실"};
		for (int i = option.length-1; i >= 0; i--) {
			if(button2>= (1<<i)) {
				System.out.println(option[i]);
				button2-=(1<<1);
			}
		System.out.println(button2);	
			
		}
	}
}

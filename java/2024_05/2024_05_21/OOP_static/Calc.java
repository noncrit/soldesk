//변수를 만드는 이유 -> 데이터 저장하려고
//변수 -> 데이터를 저장하는 그릇

//객체를 왜 만들까? -> OOP로 이해하기 쉬운 코드 구현을 위해
//추가적으로 static 키워드가 없는 메소드를 사용하기 위해

public class Calc {
	//사실 멤버변수 없어도 계산 기능자체는 그냥 구현 할 수 있음
	//굳이 객체가 필요가 없음 그냥 static method 사용하면 ㅇㅋ
	int a;
	int b;
	int sum;
	
	public void sum(int a, int b,int c) {
		
		this.sum=a+b;
		System.out.printf("%d+%d+%d=%d\n",a,b,c,sum);
		
	}
	
	public static void sum(int a, int b) {
		
		System.out.printf("%d+%d=%d\n",a,b,a+b);
		
	}
	
}

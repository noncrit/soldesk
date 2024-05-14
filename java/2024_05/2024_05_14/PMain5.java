//call by value - 변수의 값을 복사해서 함수의 파라미터 값으로 사용하는 것
//call by reference - 변수를 참조하는 주소값을 파라미터로 전달하는 것
//함수에서 파라미터로 끌어와서 써도 배열의 주소값을 그대로 쓰니까 함수에서 수정된 사항이 원래 배열에도 영향을 줌
//중요!!!
//근데 java는 파라미터를 넘기는 과정에서 call by value 방식으로 값만 넘김(즉 파라미터 넘어가는게 call by value 방식임)
//결국 call by reference인척하는 call by value 방식임
public class PMain5 {
	public static void main(String[] args) {
		int a=10;
		int[] b= {10,20};
		int[] c= {10,20};
		System.out.println("b "+b);	//b ??
		System.out.println("c "+c);	//c ??
		System.out.println("--------------------");
		test(a,b,c);	//b ?? 
						//c ??
						//10 a
						//10 b
						//10 c
						//-----
						//b ??
						//c ??
						//100 a
						//100 b
						//100 c
		System.out.println("--------------------");
		System.out.println(a + "a");	//10 a 		//함수에서 call by value로 호출->원래 a에는 영향 없음
		System.out.println(b[0] + "b");	//100 b (!!)//함수에서 call by reference로 호출됨
													//-> 원래 배열 주소값을 참조해 수정했으니 메인에 있는 배열도 영향받음
		System.out.println(c[0]+ "c");	//10 c		//함수가 새로 배열을 선언함 - 원래 c의 주소와 다름 - 함수 끝나면 회수됨
													//그래서 메인쪽에 처음 선언된 c의 주소를 참조하게됨
													//call by value 방식이라 c가 수정되지 않았음
		
	}
	public static void test(int a, int b[], int c[]) {
		System.out.println("b "+b);
		System.out.println("c "+c);
		System.out.println(a + "a");
		System.out.println(b[0] + "b");
		System.out.println(c[0]+ "c");
		System.out.println("-------------------");
		
		a=100;
		b[0]=100;
		c = new int[] {100,200};	//새로운 배열 할당
									//new를 명시 안했을 경우 이미 할당된 c를 덮어쓰는식이라 컴파일러가 막음 -> 그래서 new int[] 가 정규식
									//값 변경은 각각의 요소에 접근을 해야함
		
		System.out.println();
		System.out.println("b "+b);
		System.out.println("c "+c);
		System.out.println(a + "a");
		System.out.println(b[0] + "b");
		System.out.println(c[0]+ "c");
		
	}
	
}

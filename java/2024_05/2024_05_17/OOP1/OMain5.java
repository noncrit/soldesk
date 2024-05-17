//Garbage Collector 예시
//과자 : 이름, 구매처, 가격
//과자의 정보를 출력하는 기능까지

// ???
// 		???
//stack : push&pop, 프로그램이 종료되면 스택에 있는 할당된 자원은 회수됨
//Heap	: 컴퓨터가 적당하다고 판단한 위치에 변수의 공간 할당 / 자동 정리 X ->지금은 Garbage collection이 알아서 자원 정리함
//예전 C,C++은 가비지 컬렉터 없어서 설계 단계에서 메모리 회수까지 신경써야했음
//Java는 JVM에 탑재되어있는 Garbage Collector가 메모리 관리를 알아서 해줌 -> 개발자가 신경써야할게 하나 줄어듬
//GC 작동시점 : 할당되어있던 메모리 주소값에 접근할 방법이 없어지면 GC가 작동함
//단점 : GC가 실제로 작동하는 것을 확인할 수 없음
//System.gc() 이걸로 수동으로 정리할 수는 있지만, System.gc();를 호출하는 것 자체가 부하가 큰 작업임(메모리 영역을 high level에서 직접 호출하는 작업임...)
public class OMain5 {
	
	public static void main(String[] args) {
		
		Snack k=new Snack();
		
		k.name="새우깡";
		k.distributor="농심";
		k.price=1200;
		
		k.print();
		System.out.println("================");
		
		Snack k2=k;	//Snack을 참조하는 변수 k2가 추가됨
		k=null;
		System.out.println(k);	//k의 주소값이 null
		System.out.println(k2);	//k2는 아직 주소값이 살아있음
		k2=null;				//k2의 주소값이 null ->k,k2 모두 Snack을 참조하지 않음 ->GC 작동
					
		System.out.println(k2);
		
		k2.print();	//null pointer access
		//만약 GC가 프로그램 수행중 작동 안했다면, 실행이 끝난뒤 알아서 작동함
		//실행이 끝난 뒤엔 stack 영역이 회수됨->Heap에 접근할 주소값을 잃어버리기 때문에 GC 실행조건이 만족됨
	}
}

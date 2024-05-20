import java.util.Random;

public class Person2 {

	Random r=new Random();
	int p2_rps;
	int p2_win;
	int p2_lose;
	int p2_tie;
	
	public int rps_p2() {
		
		p2_rps=r.nextInt(3)+1;
		while(p2_rps<1 || p2_rps>3) {
			System.err.println("P2 입력값 오류/코드 확인 요망");
			p2_rps=r.nextInt(3)+1;
		}
		return p2_rps;
	}
	//메소드 파라미터로 객체 참조하는거 가능 -> 오버로딩 사용가능	
	public void print_stat(Person2 p) {
		
		System.out.printf("Player 2 : %d 승 | %d 무 | %d패\n",p2_win ,p2_tie ,p2_lose);
		
	}
}

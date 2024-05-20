import java.util.Scanner;

public class Person1 {
	
	Scanner sc=new Scanner(System.in);
	int p1_rps;
	int p1_win;
	int p1_lose;
	int p1_tie;
	
	public int rps_p1() {
		
		p1_rps=sc.nextInt();
		while(p1_rps<1 || p1_rps>3) {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			p1_rps=sc.nextInt();
		}
		return p1_rps;
	}
	//메소드 파라미터로 객체 참조하는거 가능 -> 오버로딩 사용가능
	public void print_stat(Person1 p) {
		
		System.out.printf("Player 1 : %d 승 | %d 무 | %d패\n",p1_win ,p1_tie ,p1_lose);
		
	}
}

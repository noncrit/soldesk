
public class Judge {
	//String[] rulebook = new String[] {" ", "가위", "바위", "보"}; <-이런식으로도 가능
	Person1 p1=new Person1();
	Person2 p2=new Person2();
	int tmp_a=0;
	int tmp_b=0;
	
	public void rps(int a, int b) {
		
		//가위 1, 바위 2 , 보 3
		//무승부 0 -> 2 -> %3=2
		//p1 패 -1,2 -> 1 4 -> %3 =1
		//p1 승 1,-2 ->3 0  -> %3 =0
		
		int decider=(a-b+2);
		
		System.out.printf("Player 1 : %s | Player 2 : %s\n",converter(a),converter(b));
		
		if(decider%3==2) {
			System.out.println("무승부!");
			print_dash();
			p1.p1_tie++;
			p2.p2_tie++;
			rps( p1.rps_p1(), p2.rps_p2() );
		}
		else if(decider%3==0) {
			System.out.println("P1 승리!!");
			print_dash();
			p1.p1_win++;
			p2.p2_lose++;
			rps( p1.rps_p1(), p2.rps_p2() );
		}
		else if(decider%3==1) {
			System.out.println("P2 승리!! 게임 종료!");
			print_dash();
			p1.p1_lose++;
			p2.p2_win++;
			p1.print_stat(p1);
			p2.print_stat(p2);
		}
	
	}
	
	public void print_dash() {
		System.out.println("====================");
	}

	public String converter(int a) {
		String what;
		if(a==1) {
			return what="가위";
		}
		else if(a==2) {
			return what="바위";
		}
		else if(a==3) {
			return what="보";
		}
		else return "잘못된 값";
	}
	
	public void start_ment() {
		System.out.println("게임을 시작합니다!");
		System.out.println("Player 1이 질 때까지 가위 바위 보를 진행합니다.");
	}
	public void begin_phase() {
		System.out.println("Player 1, 가위(1), 바위(2), 보(3) 중 하나를 입력하세요.(숫자 입력)");
	}
	
	public void start() {
		start_ment();
		begin_phase();
		p1.p1_rps=p1.rps_p1();
		p2.p2_rps=p2.rps_p2();
		rps(p1.p1_rps, p2.p2_rps);
	}
}

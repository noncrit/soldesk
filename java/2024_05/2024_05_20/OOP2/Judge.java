import java.util.Random;

public class Judge {
	
	Random r= new Random();
	int judge_picked_num;
	int counter;
	int given_my_num;
	int given_f_num;
	
	Me m=new Me();
	Friend f=new Friend(); 
	
	public int judge_picking_num() {
		
		System.out.println("심판이 숫자를 뽑았습니다.(1~100)");
		this.judge_picked_num=r.nextInt(100)+1;
		this.counter=0;
		return judge_picked_num;
		
	}
	
	public void get_input(int a) {
		
		if(a==0) {
			System.out.println("나의 턴 : 심판이 고른 번호를 추측해 입력해주세요.");
		}
		else {
			System.out.println("친구의 턴 : 심판이 고른 번호를 추측해 입력해주세요.");
		}
	}
	
	public void up_down_me(int input) {
		
		System.out.println("판정 중 입니다.");
		if(input==judge_picked_num) {
			this.counter++;
			System.out.println("정답!");
			m.my_counter=this.counter;
			System.out.printf("나 : %d 번 만에 정답을 맞추셨습니다.\n",m.my_counter);
			this.counter=0;
		}
		else if(input>judge_picked_num) {
			this.counter++;
			System.out.println("DOWN!");
			up_down_me(m.my_choice());
		}
		else {
			this.counter++;
			System.out.println("UP!");
			up_down_me(m.my_choice());
		}
		
	}
	
	public void up_down_f(int input) {
		
		System.out.println("판정 중 입니다.");
		if(input==judge_picked_num) {
			this.counter++;
			System.out.println("정답!");
			f.f_counter=this.counter;
			System.out.printf("친구 : %d 번 만에 정답을 맞추셨습니다.\n",f.f_counter);
			this.counter=0;
		}
		else if(input>judge_picked_num) {
			this.counter++;
			System.out.println("DOWN!");
			up_down_f(f.f_choice());
		}
		else {
			this.counter++;
			System.out.println("UP!");
			up_down_f(f.f_choice());
		}
	}
	
	public void winner() {
		
		System.out.printf("내가 소모한 기회 : %d\n",m.my_counter);
		System.out.printf("친구가 소모한 기회 : %d\n",f.f_counter);
		
		if(m.my_counter>f.f_counter) {
			System.out.println("친구분이 승리하셨습니다.");
		}
		else if(m.my_counter<f.f_counter) {
			System.out.println("본인이 승리하셨습니다.");
		}
		else {
			System.out.println("무승부!");
		}
	}
	
	public void start() {
		
		judge_picked_num=judge_picking_num();
		get_input(0);
		up_down_me(m.my_choice());
		get_input(1);
		up_down_f(f.f_choice());
		winner();

	}
	
	

	
}

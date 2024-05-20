import java.util.Scanner;

public class Friend {
	
	Scanner f_mouth=new Scanner(System.in);
	int f_num;
	int f_counter;
	
	public int f_choice() {
		
		
		this.f_num=f_mouth.nextInt();
		while(f_num<1 || f_num>100 ) {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			this.f_num=f_mouth.nextInt();
		}
		return this.f_num;
	}
}

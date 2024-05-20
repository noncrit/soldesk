import java.util.Scanner;

public class Me {

	Scanner my_mouth=new Scanner(System.in);
	int my_num;
	int my_counter;
	
	public int my_choice() {
		
		
		this.my_num=my_mouth.nextInt();
		while(my_num<1 || my_num>100 ) {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			this.my_num=my_mouth.nextInt();
		}
		return this.my_num;
	}
}

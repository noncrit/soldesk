/* 함수의 형태 설명
 * 스토리 텔링(?)
 * Q.함수를 대체 왜 쓰는걸까요?
 * A. C 처럼 메인에 다 때려박는 순차적 코드보다는
 * 기능별 함수로 나눠놓는 것이 가독성이 좋음
 * 기능별로 함수를 나눠놨기에 오류 수정이 용이함 
 * 짜놓은 함수를 지속적으로 재사용
 * 무엇보다 main 함수를 최대한 짧게 하기위해 함수로 구현함
 * ->캡슐화! -> 하나의 함수가 하나의 기능만 하도록 구현하자!
 */
import java.util.Scanner;
public class FMain5 {
	
	public static void main(String[] args) {
	
		int my_money =getMoney();
		planning(my_money);
		int restMoney=calculate(my_money);
		System.out.println("거스름돈 : "+restMoney);		
	}
	
	public static void makeErrand() { //기능만 있는 함수(리턴 없음)
		System.out.println("아들");
		System.out.println("돈 줄테니까");
		System.out.println("슈퍼가서");
		System.out.println("라면, 참치캔사와");
		System.out.println("거스름돈 그대로 가져오고");
	}
	//엄마가 돈 주심 return 타입 있는 함수
	public static int getMoney() {
		Scanner k_in= new Scanner(System.in);
		System.out.print("엄마가 주신 돈 : ");
		int money=+k_in.nextInt();
		System.out.printf("%d 원을 받았다.\n",money);
		return money; //money를 이 함수를 호출한 main에다가 반환함
	}
	
	//주머니에 돈 넣고 심부름하러 슈퍼옴(라면 3200, 참치 2170, 과자 1500)
	//돈이 얼마나 남을지 고민함
	// 
	public static void planning(int my_money){
		int ramen=3200;
		int can_tuna=2170;
		int snack=1500;
		int budget=my_money;
		budget=budget-(ramen+can_tuna+snack);
		System.out.println("잔액 : "+budget);
	}
	
	//마트에서 계산 마치고 잔돈 돌려받기 파라미터 받고 리턴도 있는 함수
	public static int calculate(int money) {
		int ramen=3200;
		int can_tuna=2170;
		int snack=1500;
		int my_tip=2000;
		int restmoney=money-(ramen+can_tuna+snack+my_tip);
		return restmoney;
	}
}

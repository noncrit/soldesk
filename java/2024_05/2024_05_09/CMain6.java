import java.util.Scanner;

public class CMain6 {
	
static Scanner sc= new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("월을 입력해주세요.");
		int x=scan_int();
		//31 : 1,3,5,7,8,10,12
		//30 : 4,6,9,11
		//29 : 2
		switch (x) {
		case 2:
			System.out.println("29일까지 있습니다.");
			break;
		
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일까지 있습니다.");
			break;
				
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31일까지 있습니다.");
			break;
			
		default:
			System.err.println("없는 달입니다.");
			break;
		}
		
	}
	public static int scan_int() {
		System.out.println("(정수입력)");
		int a=sc.nextInt();
		return a;
	}
	//1년은 12달 각 달마다 며칠인지는 다 다름 몇 월인지 입력 받아서 31일/30일/28일 인지 출력
	//없는 달을 입력하면 없는 달입니다라고 출력
}

import java.util.Scanner;

public class CMain8 {
static Scanner sc=new Scanner(System.in); 

	public static void main(String[] args) {
		start_bmi();
	}
	public static int scan_int() {	
		int a=sc.nextInt();
		return a;
	}
	public static double scan_double() {
		double a=sc.nextDouble();
		return a;
	}
	
	//BMI 검사 프로그램
	//이름, 키(cm), 몸무게(kg) 입력
	//BMI 계산법	:몸무게 / (키*키) (키는 m 단위)
	// 18.5 미만	:저체중
	// 18.5 이상	:정상
	// 25 이상	:과체중
	// 30이상		:경도비만
	// 35이상		:중증도비만
	// 40이상		:고도비만
	//결과를 출력( 각 결과에 따른 코멘트 작성)하고,
	//Y를 입력하면 프로그램이 종료
	
	//BMI 계산
	public static double calc_BMI(double height, double weight) {
		
		
		double converted_height=0;
		if(height<=0) {
			System.err.println("에러가 발생했습니다.");
			exit();
			return -1;
		}
		else if(height>0 && height<100) {
				
				converted_height=height;
		}
		else {	
			converted_height=(height-100)/100+1;
		}
		
		divider_printer();
		System.out.printf("입력된 키 : %.2fcm, 입력된 몸무게 : %.2fkg",height,weight);
		double bmi=weight/(converted_height*converted_height);
		return bmi;
	}
	
	//BMI 판정
	public static String decider_BMI(double bmi) {
		String result;
		if(bmi<0) {
			result="에러입니다. 관리자에게 문의하십시오";
			return result;
		}
		if(bmi>=40) {	
			result="고도비만";
			return result;
		}
		if(bmi>=35) {	
			result="중증도비만";
			return result;
		}
		if(bmi>=30) {	
			result="경도비만";
			return result;
		}
		if(bmi>=25) {	
			result="과체중";
			return result;
		}
		if(bmi>=18.5) {	
			result="정상";
			return result;
		}
		if(bmi<18.5) {	
			result="저체중";
			return result;
		}
		
		else {
			result="에러입니다. 관리자에게 문의하십시오";
			return result;
		}
	}
	//프로그램 종료 신호 함수
	public static int exit() {
		System.out.println("Y를 눌러 프로그램을 종료합니다.");
		String signal=sc.next();
		
		if(signal.equals("y")){ 
								return 0;
		}
		else if(signal.equals("Y")){ 
								return 0;
		}
		else {
			exit();
			return -1;
		}
			
	}
	//줄 꾸미기 함수
	public static void divider_printer() {
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
	}
	
	//이름을 입력받는 함수
	public static String get_name() {
		System.out.println("이름을 입력해주세요.");
		String name=sc.next();
		divider_printer();
		return name;
	}
	//BMI 지수에 따른 코멘트 함수
	public static void comment(String x) {
		switch (x) {
		case("고도비만"):
			System.out.println("운동하세요!");
			break;
			
		case "중증도비만":
			System.out.println("운동하세요!");
			break;
			
		case "경도비만":
			System.out.println("운동하세요!");
			break;
			
		case "과제충":
			System.out.println("운동하세요!");
			break;
			
		case "저제충":
			System.out.println("밥 좀 더 드세요!");
			break;

		default:
			System.out.println(x);
			break;
		}
	}

	//BMI 프로그램 메인 루틴함수
	public static int start_bmi() {
		
		String user_name=get_name();
		System.out.println("키와 몸무게를 입력해주세요");
		double bmi_result=calc_BMI(scan_double(), scan_double());
		System.out.println();
		System.out.printf("이름 : %s",user_name);
		
		System.out.println();
		divider_printer();
		System.out.printf("BMI 지수 : %.2f\n",bmi_result);
		
		String result=decider_BMI(bmi_result);
		
		divider_printer();
		System.out.printf("BMI 판정 결과입니다: %s\n",result);
		divider_printer();
		
		comment(result);
		return exit();
	}
}

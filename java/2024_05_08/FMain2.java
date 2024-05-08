import java.util.Scanner;
public class FMain2 {

	public static void main(String[] args) {	
		obesity_meter();	
	}
	//비만도 검사 프로그램
	//키, 몸무게는 입력받음
	// 표준체중 =(키-100)*0.9
	// 비만도 =(실제 체중/표준체중)*100
	// 비만도 120 넘으면 비만, 아니면 정상 체중
	// main함수가 간결하면서도 무슨 작업을 하는지 알아볼수 있어야함!->함수 쓰는 이유
	// 코드 유지보수시 기능별로 나눠져 있는 편이 작업하기에 훨씬 편함
	
	//비만도 검사 함수
	public static void obesity_meter() {
		System.out.println("비만도 검사를 시작합니다.");
		
		double my_height=height_scanner();
		
		double my_weight=weight_scanner();
		
		double standard_weight=standard_weight(my_height, my_weight);
		System.out.println("표준 체중 : "+standard_weight);
		double obesity_meter=obesity_calc(my_weight, standard_weight);
		System.out.println("비만도 : "+obesity_meter);
		
		obesity_decider(obesity_meter);
	}
	//신장 입력받는 함수
	public static double height_scanner() {
		Scanner sc=new Scanner(System.in);
		System.out.println("신장을 입력해주세요.");
		double my_height=sc.nextDouble();
		return my_height;
	}
	
	//몸무게 입력받는 함수
	public static double weight_scanner() {
		System.out.println("몸무게를 입력해주세요.");
		Scanner sc=new Scanner(System.in);
		double my_weight=sc.nextDouble();
		return my_weight;
	}
	
	//표준 체중 계산 함수
	public static double standard_weight(double height, double weight) {
		double standard_weight = (height-100)*0.9;
		return standard_weight;
	}
	
	//비만도 계산 함수
	public static double obesity_calc(double real_weight,double standard_weight) {
		double obesity_meter=Math.round((real_weight/standard_weight)*100);
		return obesity_meter;
	}
	
	//비만 판정 - 출력 함수
	public static void obesity_decider(double obesity_meter) {		
		if(obesity_meter>120) {System.out.println("비만입니다!");}
		else {System.out.println("정상 체중입니다!");}
	}
	
}

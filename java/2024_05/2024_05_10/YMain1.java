import java.util.Scanner;

public class YMain1 {
static Scanner sc=new Scanner(System.in);


	public static void main(String[] args) {
		start_program();
	}
	//평일 스케줄 출력해주는 프로그램
	//시간을 입력받아서(24시간 단위) 해당 시간대에 속하는 할 일을 출력 -> 시간 범위가 올바르지 않으면 다시 입력
	// 오전 9~18 : 학원에서 공부`
	// 오전 9시, 14시, 18시 : QR찍기`
	// 13시~14시전까지 : 점심시간`
	// 18시넘어서~20시 : 집에 가는 시간`
	// 06시~오전9시전까지 : 기상+씻기+학원가기`
	// 20시~06시전까지	: 여가시간 +취침`
	
	//시간 입력받는 함수
	public static int get_time() {
		System.out.println("시간을 입력해주세요.");
		int time_in=sc.nextInt();
		if(time_in<0||time_in>=24) {
									System.err.println("잘못된 입력입니다.");
									get_time();
		}
		return time_in;
	}
	//시간 테이블 함수
	public static String time_table(int time) {
		String result="";
		String tmp;
		
		if(9<time && time<18) {
								result =" 학원에서 공부";		
		}
		if(time==9 || time==14 || time==18) {	
												tmp = " + QR찍기";
												result += tmp;
												return result;
		}
		if(13<=time && time<14) {
										tmp=" + 점심시간";
										result += tmp;
										return result;
		}
		else if(18<time && time<=20) {
										return "집에 가는 시간";
		}
		else if(time>=6 && time<9) {
										return "기상+씻기+학원가기";
		}
		else if(time<6 || time>=20) {
										return "여가시간+취침";
		}
		else {
				return "모르겠음";
		}
			
	}
	
	//테이블 시작 함수
	public static void start_program() {
		int input_time=get_time();
		String result=time_table(input_time);
		System.out.println("해당 시간대에 하는 일 : "+result);
	}
}

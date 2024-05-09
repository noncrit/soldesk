
/*switch - case 문은 그래서 권한설정같은곳에서 자주 씀
 * 
 */


import java.util.Scanner;

public class CMain4 {
static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		army(scan_String());
	}
	
//	Scanner로 입력받음
//	이병 입력 => 눈치, 관등성명, 훈련, 잠
//	일병	입력 => 관등성명, 훈련, 잠
//	상병 입력	=> 훈련, 잠
//	병장 입력	=> 잠
//	break 없으면 나올때까지 해당 case 부터 다음 break 까지 쭉 실행함
	public static void army(String x) {
		switch (x){
			case "이병" : System.out.println("눈치");
				
			case "일병" : System.out.println("관등성명");
			
			case "상병" : System.out.println("훈련");
			
			case "병장" : System.out.println("잠");
			break;
			
			default : System.out.println("민간인");
			break;
		}	
	}

	public static String scan_String() {
		System.out.println("문자열을 입력해주세요.");
		String a=sc.next();
		return a;
	}
}

import java.util.Scanner;

public class CMain5 {
static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		db_hierarchy(scan_String());
	}
	/*직업 :
	 * DBA(상위 데이터베이스 관리자)
	 * :전원관리, 백업/복구, 명령어로 CRUD, 서비스 활용
	 * DBP(데이터베이스 프로그래머)
	 * :명령어로 CRUD, 서비스 활용
	 * DBU(데이터베이스 이용자)
	 * :서비스 활용 
	 * 이거를 스위치 케이스로 나타내라
	 */
	public static void db_hierarchy(String x) {
		switch (x) {
		
		case "DBA":
		case "dba":
			System.out.println("전원관리");
			System.out.println("백업/복구");
			
		case "DBP":
		case "dbp":
			System.out.println("명령어로 CRUD");
		
		case "DBU":
		case "dbu":
			System.out.println("서비스 활용");
			
			break;

		default:
			System.out.println("???");
			break;
		}
	}
	
	public static String scan_String() {
		System.out.println("문자열을 입력해주세요.");
		String a=sc.next();
		return a;
	}
	
}

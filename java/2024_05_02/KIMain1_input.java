import java.util.Scanner;

public class KIMain1 {
	public static void main(String[] args) throws InterruptedException {
		
		Scanner keyboard = new Scanner(System.in);
		/*Scanner -> Java 내장기능 
		*java.util 패키지에 들어있음
		*Scanner 사용을 위한 조건 - 객체가 필요 ( new ~)
		*Scanner -> 이클립스 콘솔로부터 데이터를 입력받을 수 있는 기능
		*이름 콘솔창에 입력받아서 출력까지
		*/
		//System.out.println("이름을 입력하세요.");
		//String name= keyboard.next();
		//System.out.printf("이름 : %s\n", name);
		//System.err.println("-------------");
		
		//키, 몸무게, 신발사이즈, 여행 가고 싶은 곳, 좋아하는 숫자, 퇴근하고싶은지 유무
		
		System.out.println("키를 입력하세요");
		double height= keyboard.nextDouble();
		
		System.out.println("몸무게를 입력하세요.");
		double weight= keyboard.nextDouble();
		
		System.out.println("신발사이즈를 입력하세요.");
		int shoes_size = keyboard.nextInt();
		
		System.out.println("여행가고 싶은 곳을 입력하세요.");
		String wt_travel = keyboard.next();
		
		System.out.println("좋아하는 숫자를 입력하세요.");
		int fav_num = keyboard.nextInt();
		
		System.out.println("퇴근하고 싶으신가요?.");
		Boolean must_yes= keyboard.nextBoolean();
		
		System.out.println("--------------------");
		
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("신발 사이즈 : "+shoes_size);
		System.out.println("가고 싶은 여행지 : "+ wt_travel);
		System.out.println("좋아하는 숫자 : "+fav_num);
		System.out.println("퇴근하고 싶으신가요???  "+ must_yes);
		//끄고싶으면 아무거나 입력하세요 출력 -> 뭔가를 입력해서 엔터 입력하면 1초마다 ... 3번 반복 후 프로그램 종료 메시지 출력 -> 0.5초 후 종료
		//bat 파일 생성
		  
		System.out.println("--------------------");  
		 
		System.out.println("프로그램 종료를 원하면 아무키나 입력해주세요.");
		String end_signal  = keyboard.next();
		keyboard.close();
		System.out.println("| "+end_signal+" |"+ " 입력을 감지하였습니다. 종료합니다.");
		int counter =0;
			while (counter<3) {
				System.out.println("....");
				Thread.sleep(1000);
				counter++;
			}
		Thread.sleep(500);
		return;
		
		
		
		}
}

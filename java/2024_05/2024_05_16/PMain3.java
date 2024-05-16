//현재 시간을 밀리초로 나타내주는 함수 : System.currentTimeMillis();
// long 타입으로 현재 시간을 밀리초 단위로 나타냄
// 절대값 구하기 : Math.abs();

//nextLine() : Enter를 치기 전까지 입력한 문자열 모두를 반환함
//next() : 공백(Space)전까지 입력받은 문자열을 반환함
//next()는 개행문자(Enter)를 무시하고 입력받음
//nextLine() 은 한줄단위로 입력을 받음 -> Enter도 포함됨

//Q. long 타입 같은것들 정수형으로 바꿔서 계산하려면 어떻게 해야하나(소수 연산 오류 방지)

import java.util.Scanner;

public class PMain3 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("첫번째 도전자님 이름을 입력해주세요.");
		String user1=sc.next();
		
		System.out.println(user1+"님 시작하려면 <Enter>를 입력해주세요.");
		sc.nextLine(); //엔터 누르기 전까지 입력값 받고
		sc.nextLine(); //여기서 엔터가 스캐너로 입력됨
		
		long a=System.currentTimeMillis();
		
		System.out.println("10초가 된 것 같으면 <Enter>를 누르세요");
		sc.nextLine();
		long b=System.currentTimeMillis();
		
		double result1= ((double) (b-a) * 0.001);
		System.out.printf("종료시간 : %.3f초\n", result1);
		///
		System.out.println("두번째 도전자님 이름을 입력해주세요.");
		String user2=sc.next();
		
		System.out.println(user2+"님 시작하려면 <Enter>를 입력해주세요.");
		sc.nextLine();
		sc.nextLine();
		
		long c=System.currentTimeMillis();
		
		System.out.println("10초가 된 것 같으면 <Enter>를 누르세요");
		sc.nextLine();
		long d=System.currentTimeMillis();
		
		double result2= ((double) (d-c) * 0.001);
		System.out.printf("종료시간 : %.3f초\n", result2);
		
		if(Math.abs(result1 - 10) < Math.abs(result2 - 10)) {
			System.out.printf("%s님이 %.3f초 차이로 승리하셨습니다!",
								user1,Math.abs(result1-result2));
		}
		else if(Math.abs(result1 - 10) > Math.abs(result2 - 10)) {
			System.out.printf("%s님이 %.3f초 차이로 승리하셨습니다!",
								user2,Math.abs(result1-result2));
		}
		else System.out.println("무승부");
	
		
		
	}
}

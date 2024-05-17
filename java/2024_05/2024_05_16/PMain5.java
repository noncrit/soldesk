import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//배열에서 중복 뽑아내는거 생각 더 해보기... 느렸음
//return (num>=1 && num<45) ? num :getNum(); ->삼항연산자 형태로 재귀표현하는거 익숙해지기
//이중 for문(i,j)에서 중복 값이 나온경우 바깥쪽 카운터(i--)를 감소시켜서 
//중북된 수가 나온를 루프를 다시 뽑는식으로 중복처리 구현 가능


//로또 맞추기-로또는 순서 안따짐
//컴퓨터가 1~45사이의 정수중 6개의 숫자를 선택
//유저가 숫자 6개를 입력
//6개가 일치 : 1등
//5개가 일치 : 2등
//4개가 일치 : 3등
//나머지 꽝
public class PMain5 {
	
static Scanner sc =new Scanner(System.in);
static Random r= new Random();

	public static void main(String[] args) {
		start();
	}
	
	//컴퓨터가 뽑은 로또의 중복판별함수(랜덤으로 다시 입력함)
	public static int[] is_duplicate(int[] a) {
		
		int index=0;
		int marker=0;
		
			for (int i = 0; i < a.length; i++) {
				index = a[i];
			
				for (int j = i+1; j < a.length; j++) {
				
						if(index==a[j]) {
						a[j]=r.nextInt(45)+1;
						marker=1;
						}
				}
			}
		
		//Arrays.sort(a);
		
		if(marker!=0) {
			a=is_duplicate(a);
		}
	
		return a;
	} //end of is_duplicate
	
	// 유저가 뽑은 로또 중복판별(스캐너로 다시 입력받음)
	public static int[] is_duplicate_user(int[] a) {
		
		int index=0;
		int marker=0;
		
			for (int i = 0; i < a.length; i++) {
				index = a[i];
				
				for (int j = i+1; j < a.length; j++) {
				
						if(index==a[j]) {
						System.out.printf("중복된 수 %d 새로운 값을 입력해주세요.",a[j]);
						marker++;
						a[j]=sc.nextInt();
						}
				}
			}
		
		//Arrays.sort(a);
		
		if(marker!=0) {
			a=is_duplicate_user(a);
		}
		
		System.out.println();
		
		return a;
	}
	//컴퓨터측 로또 생성 함수
	public static int[] lotto_generator() {
		
		int[] a=new int[6];
		
		for (int i = 0; i < a.length; i++) {
			a[i]=r.nextInt(45)+1;
		}
		
		//Arrays.sort(a);
		
		a=is_duplicate(a);
		
		return a;	
	}
	//유저의 로또 번호 선택 함수
	public static int[] user_pick() {
		
		int[] user_pick=new int[6];
		for (int i = 0; i < user_pick.length; i++) {
				
				System.out.println("당첨번호를 골라주세요(1~45)");
				
				user_pick[i]=sc.nextInt();
				
					while(user_pick[i]>45 || user_pick[i]<1) {
						System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
						user_pick[i]=sc.nextInt();
					}	
		}//end of for
			
		//Arrays.sort(user_pick);

		user_pick=is_duplicate_user(user_pick);
		
		printArray(user_pick);
		
		System.out.println();
		System.out.println("==================");
		return user_pick;
	}
	
	//배열프린트 함수
	public static  void printArray(int[] a) {
		System.out.println("선택된 번호");
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%d ",a[i]);	
		}
	}
	
	
	//추첨 결과 분석함수
	public static int comparison(int[] lotto, int[] user_pick) {
		
		int decider=0;
		int total_coincidence=0;
		
		System.out.println("당신이 고른 번호");
		for (int i = 0; i < user_pick.length; i++) {
			System.out.printf("|	%d	|",user_pick[i]);	
		}
		System.out.println();
		System.out.println("==================");
		
		System.out.println("로또 추첨 결과");
		for (int j = 0; j < lotto.length; j++) {
			System.out.printf("|	%d	|",lotto[j]);	
		}
		System.out.println();
		System.out.println("==================");
		
		System.out.println("일치하는 숫자 리스트");
		
		for (int i = 0; i < user_pick.length; i++) {
			
			for (int j = 0; j < user_pick.length; j++) {
				
				decider=lotto[i]-user_pick[j];
			
				if(decider==0) {
					System.err.printf(" %d ",lotto[i]);
					total_coincidence++;
				}
			}
		}
		System.out.println();
		return total_coincidence;
		
	}
	
	public static void grade_dedicer(int total) {
		System.out.printf("총 : %d개\n",total);
		
		if(total==6) {
			System.out.println("1등입니다!!! 축하합니다!!!");
		}
		else if(total==5) {
			System.out.println("2등입니다!!! 축하합니다!!");
		}
		else if(total==4) {
			System.out.println("3등입니다!!! 축하합니다!");
		}
		else {
			System.out.println("꽝!!");
		}	
	}
	//로또 추첨 시작함수
	public static void start() {
		int[] user=new int[6];
		user=user_pick();
		int[] lotto=new int[6];
		lotto=lotto_generator();
		
		int total_coincidence=comparison(lotto, user);
		
		grade_dedicer(total_coincidence);
		
	}
	
	
		
	
	
}//end of PMain

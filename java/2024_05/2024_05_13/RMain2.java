/*for(변수초기화; 조건식; 변수값 변화){내용;}
*
*반복에 조건이 필요한 경우(if 문의 반복버전?)
*while : 조건을 먼저 검사하고, True 인 경우 계속해서 내용 실행 / 조건이 false로 판정되거나 break로 반복 종료 가능
*조건 부분에 True 넣으면 무한루프
*while : 반복  횟수를 정확히 알 수 없을 때, 특별한 조건에서만 멈춰야 할 경우 사용하는 반복문
*while(조건식){ 내용; }
*
*do-while문 : 일단 실행부터 한 다음 조건을 나중에 검사하는 문장(거의 안씀)->적어도 한번의 실행은 보장이 됨
*/
import java.util.Random;
public class RMain2 {
	
	public static void main(String[] args) {
		//sum_of_6_multiple();
		//equation();
		prac_while_2();
	}
	
	//1~100까지 정수 중 6의 배수인 놈들만 다 더한 값 출력하기
	public static void sum_of_6_multiple() {
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%6==0) {
				sum=sum+i;
			}
		}
		System.out.println("1~100 중 6의 배수의 총합 = "+sum);
	}
	
	// 4x +5y =60 이 되는 해를 모두 구해서 (x,y)의 형태로 출력하기 /이때 x,y는 10 이하의 정수
	public static void equation() {
		for(int x=0;x<11;x++) {
			for(int y=0;y<11;y++) {
				if( (4*x)+(5*y) ==60) {
					System.out.printf("(%d, %d)\n",x,y);
				}
			}
		}
	}
	
	public static void ex_while() {
		Random r=new Random();
		int z=r.nextInt()+1;
		while(z!=9) {
			System.out.println(z);
			z=r.nextInt()+1;
			//실행 내용이 끝난 뒤 while로 가서 다시 조건체크 수행
		}
	}
	
	public static void ex_do_while() {
		Random r=new Random();
		int z=r.nextInt()+1;
		do {
			System.out.println(z);
			z=r.nextInt()+1;}while(z!=3);
			//실행 내용이 끝난 뒤 while로 가서 다시 조건체크 수행
		}
	
	//1~n번째 숫자까지 다 더했을때 더한 총합이 100이 넘어가면 반복문 종료, n값이 몇인지 출력
	public static void prac_while() {
		int counter=0;
		int sum=0;
		while(sum<=100) {
			counter++;
			sum=sum+counter;
		}
		System.out.println("총합 : "+sum);
		System.out.println("n : "+counter);
	}
	
	//1000 이하의 숫자 중에서 가장 큰 15의 배수는? - 수정사항 *1000부터 거꾸로 내려오면 훨씬 효율적*
	public static void prac_while_2() {
		int counter=1000;
		int hit=0;
		
		while(counter>0) {
			counter--;
			if( (counter%15) == 0) {
				hit=counter;
				break;
			}
		}
		System.out.println("n : "+hit);
	}
	
	
}

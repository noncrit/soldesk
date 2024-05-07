//5_7 Function 복습
//홀짝 게임 만들기 -> 컴퓨터가 동전 10개 던지고 시작 -> 섞기 메소드 1개
// 내가 홀/짝 중 둘중 하나 선언함현 홀짝 판단해서 결과 출력
//int i=r.nextInt();// int 범위안에 있는 랜덤한 숫자
//int i2 =r.nextInt(); / 0~4 중 랜덤한 정수
import java.util.Random;
import java.util.Scanner;
public class YMain {
	public static void main(String[] args) {
		
		int array_in[]= randomize();
		
		System.out.println();
		dedice(array_in);
		for(int i=0;i<10;i++) { System.out.printf("%d",array_in[i]);}
		
		
		
	}

public static int[] randomize(){
	int outarray[] = new int[10];
	Random r = new Random();
	int token=0; // 나머지가 1인 경우 앞면, 0이면 뒷면
		for (int i=0;i<10;i++) {
			token=(r.nextInt(4)+1)%2;
			outarray[i]=token;
						}
	return outarray;
										}


public static void dedice(int input_array[]){	

	int num_of_odd=0; //앞면
	//int num_of_even=(10-num_of_odd); //뒷면
		for(int j=0;j<10;j++){
			num_of_odd=num_of_odd+(input_array[j]%2);
			}
	int result=(num_of_odd%2);
	Scanner key_in=new Scanner(System.in);
		
	System.out.println("동전 10개 중 앞면인 동전의 개수가 홀수/짝수 중 어디에 속할까요? odd/even 중 하나를 입력해주세요");
	String expectation=key_in.next();
	String odd="odd";
	String even="even";
	
	if(expectation.equals(odd))
	{	if(result!=0) { System.out.println("입력값 : 홀\n정답입니다!");}
		else {System.out.println("입력값 : 홀\n오답입니다!");}	
	}
	
	if(expectation.equals(even))
	{	if(result==0) { System.out.println("입력값 : 짝\n정답입니다!");}
		else {System.out.println("입력값 : 짝\n오답입니다!");}
	}
	System.out.println();
	System.out.printf("앞면인 동전의 개수 : %d\n", num_of_odd);	
												}
	
}



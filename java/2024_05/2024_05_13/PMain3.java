//배열의 요소 정렬 bubble sort
// bubble sort : 인접한 두 항목의 값을 비교해서 기준에 만족하면 서로의 값을 교환하는 정렬방식
import java.util.Scanner;

public class PMain3 {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		start();
	}
	//5칸짜리 정수 배열 생성
	public static int[] array() {

		int[] x = new int[5];
		for (int i = 0; i <=4 ;i++) {
			System.out.printf("%d번째숫자를 입력해주세요\n",i+1);
			x[i]=sc.nextInt();
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
		return x;
	}
	//버블 정렬 알고리즘
	public static int[] bubblesort(int tmp, int[] array_in) {
		
		for (int turn = 0; turn < array_in.length-1; turn++) { //-1안하면 5넘어가서 exception 발생함
			
			for(int j=0;j<array_in.length-1;j++) {
									if(array_in[j]>=array_in[j+1]) {
											tmp=array_in[j];
											array_in[j]=array_in[j+1];
											array_in[j+1]=tmp;		
									}
			System.out.println("--------------");
			
			System.out.printf("%d 턴\n", turn+1);						
				
				for(int k=0;k<5;k++) {
					System.out.printf("%d ",array_in[k]);	
				}
	
			System.out.println();
			}
		}
		return array_in;
	}
	
	public static void start() {
		int tmp=0;
		int[] input_array=array();
		int[] result=bubblesort(tmp, input_array);
		System.out.println("-------------");
		System.out.println("정렬된 값");
		for (int i = 0; i < result.length; i++) {
			System.out.printf("%d ",result[i]);
		}
	}
		
}

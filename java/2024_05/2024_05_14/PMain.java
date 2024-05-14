import java.util.Scanner;
import java.util.Random;

public class PMain {
	
	public static void main(String[] args) {
		
		int[] random_array=rand_array();
		int[] scan_aray=scan_array();
		
		print_array(random_array);
		min_max(random_array);
		
		print_array(scan_aray);
		min_max(scan_aray);
		
		
		//10개의 숫자를 직접 입력해서 배열에 담고 출력
		//10개의 숫자를 랜덤으로 뽑아서(1~100) 배열에 담고 출력
		//배열에 랜덤으로 받아온 값들의 최대값 최소값을 구해서 출력
	}
	
	public static int[] rand_array() {
		Random r=new Random();
		int[] rand_array=new int[10];
		System.out.println("랜덤 배열을 생성하였습니다.");
		for (int i = 0; i < 10; i++) {
			rand_array[i]=r.nextInt(100)+1;
		}
		return rand_array;
	}
	public static int[] scan_array() {
		Scanner sc=new Scanner(System.in);
		int[] scan=new int[10];
		System.out.println("배열에 들어갈 값을 입력해주세요.");
		for (int i = 0; i < 10; i++) {
			scan[i]=sc.nextInt();
		}
		return scan;
	}
	//배열 출력
	public static void print_array(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.printf(" %d ",x[i]);
		}
	System.out.println();
	}
	//최대값 최소값 찾기
	public static void min_max(int[] x) {
		int min=x[0];
		int max=x[0];

		for (int i = 0; i < x.length; i++) {
						if(x[i]>max) {
							max=x[i];
						}
						else if(x[i]<min) {
							min=x[i];
						}
		}
		System.out.println("배열의 최대값 : "+max);
		System.out.println("배열의 최소값 : "+min);
	}
	
	
}

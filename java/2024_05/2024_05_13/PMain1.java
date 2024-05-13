//어떤 숫자를 콘솔창에 입력
//해당 숫자의 약수를 구해서 출력해주는 프로그램
//main에서 진행 => 음수값은 무시
//그 이후 숫자를 계속 입력하면 해당 숫자의 약수를 계속 보여줌
//0 입력받으면 프로그램 종료
import java.util.Scanner;

public class PMain1 {
	
	public static void main(String[] args) {
		int num_in=1;
		Scanner sc=new Scanner(System.in);
		while(num_in!=0){
			System.out.println("약수를 구할 숫자를 입력해주세요. 혹은 종료하려면 0을 입력하세요");
			num_in=sc.nextInt();
			if(num_in==0) { 
				break;
			}
			else if (num_in<0) {
				continue;
			}
			else System.out.printf("%d의 약수는\n",num_in);
					for (int i = 1; i <= num_in; i++) {
					if( (num_in%i)==0) {
						System.out.print(i+" ");
					}
				}
			System.out.println();
		}
	}
}

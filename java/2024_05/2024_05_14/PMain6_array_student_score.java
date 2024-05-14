//1을 입력하면 학생 수 값을 입력
//2를 입력하면 학생들의 점수를 입력받음
//3을 입력하면 학생들의 점수 리스트를 출력
//4를 입력하면 학생들의 최고점수와 평균점수를 분석해서 출력
//5번을 입력하면 프로그램 종료
import java.util.Scanner;

public class PMain6 {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		int num_of_students=5;
		int[] score;
		int signal=0;
		int max=0;
		double avg=0;
			System.out.println("학생 수를 입력해주세요");
			num_of_students=sc.nextInt();
			score=new int[num_of_students];
		
		while(signal!=5) {
			System.out.println("동작할 기능을 선택해주세요");
			System.out.println("1 : 학생 수 입력");
			System.out.println("2 : 학생들의 점수 입력");
			System.out.println("3 : 점수 리스트 출력");
			System.out.println("4 : 점수 최고점, 평균 점수 출력");
			System.out.println("5 : 프로그램 종료");
			System.out.println("-----------------------");
			
			signal=sc.nextInt();
	
			if(signal==5) {
				break;
			}
			else if(signal==1) {
				System.out.println("학생 수를 입력해주세요");
				num_of_students=sc.nextInt();
				score=new int[num_of_students];
				if(num_of_students<0) {
					continue;
				}
			}
			else if(signal==2) {
				System.out.println("학생들의 점수를 입력해주세요");
				
				for (int i = 0; i < num_of_students; i++) {
						score[i]=sc.nextInt();	
				}		
			}
			else if(signal==3) {
				System.out.println("학생들의 점수를 출력합니다.");
				for (int k = 0; k < score.length; k++) {
					System.out.printf(" %d ",score[k]);	
				}
			System.out.println();
			}
			else if(signal==4) {
				System.out.println("최고점, 평균을 출력합니다.");
				
				for (int l = 0; l < score.length; l++) {
						if(max<score[l]) {
						max=score[l];
						}
					
				}
				for (int q:score) {
					avg+=q;
				}
				avg=(avg/num_of_students);
				
				System.out.printf("최고점 : %d\n",max);
				System.out.printf("평균 : %s\n",avg);
			}
			else continue;
		}//end of while loop
	
	}	//end of main
}		//end of class

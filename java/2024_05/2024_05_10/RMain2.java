
//이중 반복문(중첩 for 문)

public class RMain2 {
	
	public static void main(String[] args) {
/*
		for (int i = 1; i < 6; i++) {
				System.out.printf("I 값 : %d ----------\n",i);
					for (int j = 1; j < 6; j++) {
							System.out.printf("J 값 : %d ----------\n",j);
					}
			
		}
*/
/*
	//구구단 출력하기	
		for (int i = 2; i < 10; i++) {
			System.out.println();
			System.out.printf("%d단\n",i);
			
			for (int j = 1; j < 10; j++) {
					System.out.printf("%d X %d = %d\n",i ,j ,i*j);	
				}
		
		}	
*/
	//***구구단 가로로 출력하기
		for (int i = 2; i < 10; i++) {
			System.out.printf("  %d단\t\t",i);
		}
		System.out.println();
		for (int j = 1; j < 10; j++) {
				
				for (int k = 2; k < 10 ; k++) {
					System.out.printf("|%d X %d = %d\t",k,j,j*k);
				}
				System.out.println();
		}
	}
}

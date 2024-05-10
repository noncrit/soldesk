//별찍기 예제
public class RMain3 {
	public static void main(String[] args) {
		laugh();
		line();
		laugh2();
		line();
		cross();
		line();
		cross_laugh();
		line();
		star();
		line();
		star_other();
	}
	//줄긋기 함수
	public static void line() {
		System.out.println("---------------------");
	}
	//ㅋ
	//ㅋㅋ
	//ㅋㅋㅋ
	//ㅋㅋㅋㅋ
	public static void laugh() {
		
		for (int i = 1; i < 6; i++) {
			
				for (int j = 0; j < i; j++) {
						System.out.printf("%s","ㅋ");
				}
				System.out.println();
		}
	}
	//ㅋ
	// ㅋ
	//  ㅋ
	public static void laugh2() {
		
		for (int i = 1; i < 6; i++) {
			
				for (int j = 0; j < i; j++) {
					
						if(j==(i-1)) {
								System.out.printf("%s","ㅋ");
						}
						else {
								System.out.printf("  ");
						}
				}
				System.out.println();
		}
	}
	//ㅋㅋㅋㅋㅋ
	//ㅎㅎㅎㅎ
	//ㅋㅋㅋ
	//ㅎㅎ
	//ㅋ
	public static void cross() {
		
		for (int i = 0; i < 5; i++) {
			
				for (int j = 5; j > i; j--) {
					
						if(i%2==0) {
									System.out.printf("%s","ㅋ");
						}
						else {
							System.out.printf("%s","ㅎ");
						}
				}
				System.out.println();
		}
	}
	
	//ㅋ
	//ㅎㅎㅎ
	//ㅋㅋㅋㅋㅋ
	//ㅎㅎㅎㅎㅎㅎㅎ
	//ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	public static void cross_laugh() {
		
		for (int i = 0; i < 5; i++) {
			
				for (int j = 0; j < (2*i)+1; j++) {
					
					if( (i%2)!=0 ) {
						System.out.printf("%s","ㅋ");
					}
					else {
						System.out.printf("%s","ㅎ");
					}
				}
				System.out.println();
		}
	}
	
	//00000*00000  //전체 11칸
	//0000***0000
	//000*****000
	//00*******00
	//0*********0
	public static void star() {
		
		int cursor=6;
		
		for (int i = 0; i <5; i++) {
				
			for (int j = 0; j < 12 ; j++) {
				
					if(j>=cursor-i && j<=cursor+i) {
							System.out.printf("%s","*");
						}
					else {
							System.out.printf("%s"," ");
						}
					}
				System.out.println();
			}
			
		}
	//다른분이 짠 버전
	public static void star_other() {
		
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < (i+6); j++) {
				System.out.print((i+j>=5)?"*":" ");
			}
			System.out.println();
		}
		
	}
}

/*

0 0 0 0 X 0 0 0 0 	cursor=4
0 0 0 X 0 X 0 0 0 	if(cursor-i,cursor+i ==0) (i==1)
0 0 X 0 0 0 X 0 0	if(cursor-i,cursor+i ==0) (i==2)
0 X 0 0 0 0 0 X 0	if(cursor-i,cursor+i ==0) (i==3)
X 0 0 0 0 0 0 0 X



*/
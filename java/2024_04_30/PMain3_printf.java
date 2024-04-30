//printf 설명
/**
 * 
 * @author ksj
 *
 */
public class PMain3 {
	
	public static void main(String[] args) {
		
		System.out.print("1asdf\n");  //println(); 이나 \n 이나 줄바꾸는건 같음
		System.out.print("2asdf\n");
		System.out.println("---");
		
		//printf -> print Formatting (형식 지정 출력)
		//가능한 format %d (10진 정수), %xd (x-빈자리를 의미함, 앞부터 x-1칸 비우기), %0xd (빈자리를 0으로 채워서 총 x자리 숫자로 만듦)
		//%s (문자열), %f (실수)
		System.out.printf("%1d\n",6); 
		System.out.printf("%04d\n",6); 
		System.out.printf("%d\n",6);
		System.out.printf("%d\n",0x6); 
		System.out.println("---");
		// %f (실수) ||소수점 이하 자리수 표기시 %.xf (x는 소수점 아래 몇자리까지 표기할지) [소수점이 잘릴경우 반올림] 빈자리는 0으로 채워짐
		System.out.printf("%.2f\n",Math.PI);
		System.out.printf("%.10f\n",Math.PI);
		System.out.printf("%.10f\n",1.234567);
		System.out.println("---");
		// %s (문자열) => 글자 데이터가 들어올 자리 | " "로 어느 부분이 글자인지 명시해야함
		System.out.printf("%s\n", "헉? 내일 휴일이라고요?");
		System.out.println("---");
		//오늘 날짜 기준 년 월 일 (ex 2024-04-30)표기하고 오늘 기온은 23도 습도는 20.21% 출력해보기
		System.out.printf("%d-%02d-%02d\n",2024,04,30);
		System.out.printf("%s", "오늘 날씨 : 더움\0\n");
		System.out.printf("오늘 기온은 %d도, 습도는 %.2f%% 입니다.\n", 23, 20.21); //printf에서만 %%가 필요함
		System.out.println("---");
		}
}

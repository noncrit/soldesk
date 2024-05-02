
public class YMain {
	
	public static void main(String[] args) throws InterruptedException {
		// 학원 오는 시간 얼마나 걸렸는지(시간) : ??, 어제 저녁메뉴 : , 어제 뭐했는지 : , 취침 시간 :,  첫 수업 소감 :, 수업 성취도 : ??%
		// 마지막에 딜레이 5초 -> 배치파일 실행까지
	
		System.out.printf("등원까지 걸린 시간 : %s\n", "2시간");
		System.out.printf("어제 저녁메뉴 : %s\n","족발");
		System.out.printf("어제 한 일 : %s\n", "독서, 취침");
		System.out.printf("취심 시간 : %s %d시 %d분\n", "PM",11,50);
		System.out.printf("첫 수업 소감 : %s\n", "기초적인 것 부터 세세하게 가르치신다.");
		System.out.printf("수업 성취도 : %.2f%%\n", 98.99);
		
		Thread.sleep(5000);
		return;
		
		 
			
		}
	
}

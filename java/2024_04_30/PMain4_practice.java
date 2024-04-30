//명함 제작
// 이름/나이/성별/키/사는 지역/별명 -모두 printf사용해서
public class PMain4 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(" ----------------");
			System.out.printf("|이름	: %s\t\0|\n","김석진");
			System.out.printf("|나이	: %d살\t\0|\n" , 27);
			System.out.printf("|성별	: %s\t\0|\n", "남");
			System.out.printf("|키	: %dcm\t\0|\n", 165);
			System.out.printf("|사는 지역	: %s\t\0|\n", "평택");
			System.out.printf("|별명	: %s|\n", "군필라이언");
		System.out.println(" ----------------");
		
		Thread.sleep(10000); //단위 ms
		
	}
}

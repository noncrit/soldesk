/*오버로딩(Overloading)* : 함수가 이름이 같아도 받는 파라미터가 다른경우(함수 구별 가능), 중복된 이름 사용 가능
 * 같은 자료형을 쓰더라도, 파라미터의 갯수가 다르면 오버로딩 가능
 * 파라미터의 갯수가 같아도, 자료형이 다르다면 오버로딩 가능
 * 전제 조건 : 함수들이 같은 기능을 하고있다 -> 기능이 다른 함수 오버로딩하면 가독성, 통일성을 모두 해침 
 * 사실 첫날부터 오버로딩 쓰고있었음 ->println 자체가 알아서 오버로딩 인식함
 */
public class FMain4 {
	//1.정수 2개를 넣으면 정수의 합을 출력
	//2. 정수 3개의 합 출력
	//3. 실수 3개 합 출력
	public static void main(String[] args) {
		/*
		sum(1, 2);
		sum(1, 20, 30);
		sum(0.1, 0.2, 30.0);
		*/
		printer(1);
		printer("아아");
		printer(1.5);
		printer();
	}
	
	public static void sum(int in_1,int in_2) {
		
		int sum=in_1+in_2;
		System.out.printf("sum of two integer : %d\n",sum);
	}
	
	public static void sum(int in_1,int in_2,int in_3) {
		int sum=in_1+in_2+in_3;
		System.out.printf("sum of three integer : %d\n",sum);
	}
	
	public static void sum(double in_1,double in_2,double in_3) {
		double sum=in_1+in_2+in_3;
		System.out.printf("sum of three non_integer : %.2f\n",sum);
	}
//--------
	//정수 1개 넣으면 윽! 출력, 문자열 1개 넣으면 악! 출력, 실수 1개 넣으면 으아아악!, 아무것도 안넣으면 ...
	public static void printer(int a){
		System.out.println("윽!");
	}
	public static void printer(String a){
		System.out.println("악!");
	}
	public static void printer(double a){
		System.out.println("으아아악!");
	}
	public static void printer(){
		System.out.println(".....");
	}
}

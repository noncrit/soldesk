/* 변수 : 데이터를 담는 그릇->변수하나에 데이터 1개만 담아짐
 * 배열 Array : [ a ] -> 배열 하나에 데이터 여러개가 들어가짐
 * 배열 : 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
 * 배열 속 각각의 데이터를 '요소' 라고 부름 -> 요소마다 붙여진 일련번호가 인덱스(0부터 시작)
 * 배열의 크기가 선언되면 이후로는 따로 조절하는게 힘들다.

 * 자료형 [] 변수명; //배열 생성
 * 변수명 = new 자료형[배열의 길이]; //배열의 초기화
 * 한줄로도 가능 : 변수명 =new 자료형[배열의 길이];
 * 배열의 단점 -> 지정된 갯수를 벗어나버리면 exception 발생
 */
public class AMain1 {
	
	public static void main(String[] args) {
		prac1();
	}
	
	public static void prac1() {
		int []eng = new int[3];
		eng[0]=100;
		eng[1]=70;
		eng[2]=50;
		for (int i = 0; i < eng.length; i++) {  //.length->배열의 크기가 어디까지인지 알려주는친구(요소가 몇개인지)
			System.out.println(eng[i]);
		}
		int[] math = new int[] {10,30,60}; //배열 생성시 값을 직접 넣는 형태
		
		for (int j = 0; j < math.length; j++) {
			System.out.println(math[j]);
		}
		
		int[] kor = {20, 40, 60}; //약식 배열 ->약식 선언으로 배열 못만드는 경우가 있음!!
		
		int a=10;
		int[] b= {10,20};
		System.out.println(a);
		System.out.println(b); //->배열의 메모리 주소값을 출력하게됨 ( 맨앞 [->배열이라는 뜻)
		//b[2]=200;
		//System.out.println(b[2]); //->배열에 할당되지 않은 값- exception 발생
		
		int[][] score = {	{50,30}, {30,50}, {100,50}	}; // 이차원 배열---엥간하면 안쓰는게 좋다...
		System.out.println(score[0]);	//->배열의 0번째 요소 주소값이 나옴
		System.out.println(score[0][1]);	//배열 1번칸의 두번째 요소
		//배열의 단점	-> 주석처리 or 설명 없으면 값이 무엇을 의미하는지 해석이 불가능함
		//			-> 배열을 생성하는 시점부터 이미 크기를 선언해야함->정확한 데이터 크기 모르면 배열을 선언하기 굉장히 난감함
		//java는 나중에 collection을 주로 쓰게됨
	}

	
}

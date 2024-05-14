//for each 예시
public class PMain4 {
	public static void main(String[] args) {
		String[] ss= {"ㅋㅋ", "ㅎㅎ","ㅇㅇ","ㅠㅠ"};
		//배열 모두 출력
		for (int i = 0; i < ss.length; i++) {
			System.out.printf(" %s ",ss[i]);
		}
		System.out.println();
		System.out.println("----------------------");
		String s=null;
		for (int i = 0; i < ss.length; i++) {
			s=ss[i];
			System.out.printf(" %s ",ss[i]);
		}
		System.out.println();
		System.out.println("----------------------");
		//for each(신형 for 문)
		//배열의 요소를 변경할때는 사용 X
		//원본 데이터를 복사해와서 사용하는 방식이라 원본에는 영향 없음
		//대신 인덱스가 없어서 원하는 값만을 사용할 수 없음->활용도가 좀 떨어짐
		//for(자료형 변수명 : 불러올 배열){ 내용}
		
		for (String s2 : ss) { //배열 ss의 요소를 순차적으로 s2에 복사한다
			System.out.print(s2);
		}
	}
}

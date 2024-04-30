
public class PMain1 {
	
	public static void main(String[] args) {
		System.out.println(); // syso 로 축약
		/*print 의 형태 - print, println(라인단위 출력), printf
		println : 콘솔창에 내용 출력후 줄바꿈(input 비우면 그냥 줄바꿈 역할)
		print	: 콘솔창에 내용 출력(줄을 바꾸지 않음)
		printf	: 콘솔창에 내용 출력(특정 형식 지정 ex-소수점 몇자리까지 표기할까 등등)
		*/
		//syso 자동완성이 println인 이유 - 가장 많이 쓰니까
		System.out.println("println : 글자출력 + 줄바꿈가능");
		System.out.print("print : 글자 출력");
		System.out.println();
		System.out.printf("print : 이거는 이따 자세히 볼게요");
		System.out.println();
		
		//syso 이용해서 사칙연산 결과 출력해보기
		System.out.println(4+2);
		System.out.println(2-4);
		System.out.println(4%3);
		System.out.println(4/2);
		//큰 따옴표는 텍스트 부분 표시(문자로 인식됨)
		
		System
		.out.
		println("AS"+
				"DF");  //어차피 컴퓨터는 ; 기준으로 블록 구분하니 어떻게 쓰든 상관은 없음(예시는 개판으로 짠 코드)(ctrl shift f 활용)
		
		//자바는 문자 1개당 2byte 차지함 - 압축시 공백란, 띄어쓰기, 줄바꿈 등등을 간략화해 용량 경량화 
		//요즘은 기기 성능 좋아져서 그냥 가독성 좋게 코드 짜는게 좋다
		}
	
	}

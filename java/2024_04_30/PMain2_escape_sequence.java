//Escape Sequence 설명
/**
 * 
 * @author ksj
 *
 */
public class PMain2 {
	
	public static void main(String[] args) {
		
		/*Escape sequence -> \ 사용해서 특수한 문자, 기능 표현
		 [여러개 붙은경우 처리순서는 맨 앞부터 순차처리]
		 \t - Tab키(가로 줄 맞춤)
		 \n - new line(세로줄 맞추는 용도)
		 \r - carriage return (커서 맨앞으로 이동)
		 \r\n - 엔터키
		 \b - backspace (문자 지우는 용도)
		 \0 - 빈칸(공백)(Space키)
		*/
		System.out.println("1. For\ttest");
		System.out.println("2. For\ntest");
		System.out.println("3. For\rtest");
		System.out.println("4. For\r\ntest");
		System.out.println("5. For\0\0\0test");
		System.out.println("6. For test\b");	// \b는 1byte 용량만 지움 -> c언어에서는 문자 1당 1byte 할당
												// 자바는 문자 1개당 2byte ->컴파일러가 그냥 ? 처리함 => 자바에서는 \b 안씀
		
		/*	이클립스 콘솔 상에서는 \r, \n 모두 엔터키 처리가 가능함(어차피 결과만 보는 용도라서)
		 	파일 시스템 or 통신시에는 Escape Sequence 지켜줘야함(\r\n 으로 명시해야 올바른 엔터처리 가능) 
		  	이클립스 내부에서는 \r, \n 구분이 매우 어려움 -> $$$이클립스 사용시에는 \n을 엔터로 사용할 예정$$$
		 
		 */
		//이모티콘 출력 \(^ _ ^)/ -> \\로 써야 backslash가 문자로 인식됨
		System.out.println("\\(^ _ ^)/");
		
		//이모티콘 출력 (".") -> . 뒤쪽으로 Backslash \ 붙이면 문자로 인식함!
		System.out.printf("(\".\")"); 

	}
	
}

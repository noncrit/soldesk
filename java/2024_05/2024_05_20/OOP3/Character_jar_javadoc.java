//중요!! - .jar, JavaDoc
//클라이언트가 캐릭터 생성 기능을 만들어달라고 요구함
//일단 성공은 했음
//이 데이터(자료)를 어떻게 건네줘야 할 것인가 ->저작권 문제 등등
//결론 : .java 파일 말고 .jar 파일로 건네주면 된다. -> 기능은 사용할 수 있다/코드는 모름
//java 파일 -> 코드까지 공개하겠다
//jar 파일 -> 코드는 공개 X, 그 기능만 이용할 수 있음
//jar(java archive) ->기계어 형태로 바꿔서 압축해놓은 상태

//컴퓨터가 저장할 때 .java 파일은 컴파일 된 후 .class파일(기계어/바이트코드)을 자동으로 생성함
// .class 파일을 실행하면 jvm 위에서 해당 프로그램이 가동됨
// .java 파일은 사람이 보기 위한 확장자
// .class 파일은 자바 머신상에서 실제로 구동되는 내용

//기계어로 변환을 해서 가동하는 이유?
//	1. 바이트 코드(기계어)를 사용하면 실행이 빠름
//	2. 원래 코드가 노출되면 보안 문제 발생->바이트 코드 형태로 유출 방지

// .jar 파일과 함께 JavaDoc을 함께 넘겨주기도 함
// JavaDoc : 제품 설명서
// 우리가 만든 프로그램을 아주 보기 쉽게 HTML 형식으로 문서화 시킨 것

//JavaDoc의 특징
// -주석은 /** (내용) */ 이런 형태로 사용함
//주석 안쪽의 내용은 크게 2가지로 나뉨
//	1. 설명문 : 주석의 시작부터 첫 번째 태그 섹션 부분까지
//	JavaDoc은 HTML로 작성하기에, 우리가 작성할때 엔터를 쳐도 <p>를 쓰지 않는한 줄바꿈 없이 쭉 이어짐
//	2. 태그 섹션 : @로 시작하는 부분들
//	예)	@author : 프로그램 작성자, 기본값으로는 Window 계정 ID가 들어감
//		@version: 말 그대로 프로그램 버전
//		@param	: 파라미터 설명 할 때 사용
//		@throws	: 예외처리에 대한 설명
//		@return	: 메소드의 리턴타입에 대한 부가설명(void인 경우 거의 안씀)

/**
 * 게임 캐릭터의 정보를 가지고 있는 Class
 * <p>
 *	@author sdedu
 *	@version 1.0.0
 *	
 */

public class Character {

	String nickname;
	int level;
	String job;
	String weapon;
	
	/**
	 * 게임 캐릭터를 생성합니다.
	 * <p> 기본 무기는 목검, 기본 직업은 초보자입니다.
	 * <P>
	 * @param	nickname 캐릭터의 이름; 길이는 3자이상 10자 이하
	 * @throws	IllegalArgumentException : 캐릭터 닉네임이 범위를 벗어날 경우, 
	 * 즉 ({@code (nickname.length() < 3) || nickname.length() > 10 })인 경우 exception 발생
	 */
	
	//constructor - 객체 생성시점에서 같이 실행됨
	public Character(String nickname) {
		this.level=1;
		this.job="초보자";
		this.weapon="목검";
		if( (nickname.length() < 3) || nickname.length() > 10 ){
			throw new IllegalArgumentException("캐릭터의 이름은 3자 이상 10자 이하입니다.");
		}
		this.nickname = nickname;
	}
	
	/**
	 * 캐릭터의 레벨을 올려주는 메소드입니다.
	 */
	public void levelup() {
		this.level++;
	}
	
	
	/**
	 * 캐릭터의 직업을 변경하는 메소드
	 * @param job 변경할 직업
	 * @throws IllegalArgumentException 캐릭터의 레벨이 10을 넘지 않을 때 발생
	 */
	public void setJob(String job) {
		if( this.level < 10 ) {
			throw new IllegalArgumentException("캐릭터의 레벨이 10 미만입니다.");
		}
		this.job=job;
	}
	
	/**
	 * 생성된 캐릭터의 status 값을 보여주는 메소드입니다.
	 *
	 */
	
	public void print_stat() {
		
		System.out.printf("Nickname : %s\n",this.nickname);
		System.out.printf("level : %d\n",this.level);
		System.out.printf("job : %s\n",this.job);
		System.out.printf("weapon : %s\n",this.weapon);
		
	}
	
}

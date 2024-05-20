//게임 캐릭터 생성
// 속성 : 닉네임, 레벨, 직업, 무기
// 이 속성들을 출력하는 기능까지 만들기
// 메인에서 객체를 만들고 닉네임 값만 넣어서 출력
public class OMain2 {
	
	public static void main(String[] args) {
	/*	
		Character lol=new Character();
		
		lol.nickname="lol";
		lol.level=10;
		lol.weapon="나뭇가지";
		lol.job="초보자";
		
		lol.print_stat("lol");
	*/
		
		Character g=new Character("철수아님");
		g.print_stat();
	}
	
}

//가위 바위 보
//등장인물 : 심판, 사람1, 사람2
//모두 한 자리에 있음
//심판한테는 가위바위보 룰북이 있음 ( 1: 가위, 2 : 바위, 3 : 보)
//사람 1은 입력으로, 사람 2는 랜덤
// 사람 1이 한 번 질 동안 몇번 이기고 몇 번 졌는지

//메소드 파라미터로 객체를 줄수도 있음 ex) rps(Person1 p1) 요런식으로->이거로 오버로딩 구현가능

public class OMain1 {
	
	public static void main(String[] args) {
		
		Judge j= new Judge();
		j.start();
		
	}
}

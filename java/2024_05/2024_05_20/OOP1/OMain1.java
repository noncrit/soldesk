//OOP 예제 몇개 더
//홀 짝 맞추기
//컴퓨터 - 유저
//main쪽에서 시작하면 컴퓨터가 20개의 동전을 가지고 시작
//유저가 동전 몇개 고를지 물어본뒤, 유저가 답한 갯수의 동전으로 홀짝 게임 시작
//유저에게 홀/짝 물어보고 판정까지
//멤버변수
//지역변수 : 해당 스코프 내에서만 존재할 수 있는 변수
//파라미터, 리턴값

public class OMain1 {
	
	public static void main(String[] args) {
		
		Dealer d=new Dealer();
		User u = new User();
		
		d.start();
		
	}
	

}

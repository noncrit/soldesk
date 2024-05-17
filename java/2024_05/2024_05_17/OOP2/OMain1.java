import java.util.Scanner;

//의사 (이름, 나이)
//손님 (이름, 나이)
//둘 다 출력까지
//상황 구현--------------
//진료실에서 의사가 ~~ 들어오세요
//환자 입장, 착석
//의사가 환자 키 몸무게 물어봄
//환자가 대답
//의사가 환자의 BMI 수치를 계산 -> 그 결과를 알려줌
//===================
//Coder : 개발자
//Programmer : Coder + 설계

//OOD (Object Oriented Design) - 객체 지향 디자인

//지역변수(Local Variable) => 메소드 내부에서 만들어낸 변수, 행동을 하는 동안에만 필요한 임시 변수
//메소드 파라미터(Method Parameter) => 실행에 필요한 재료
//리턴값(return value) => 작업(실행)을 마친 뒤 반환할 결과물
//멤버 변수(Member Variable) => 객체의 속성

public class OMain1 {
	
	public static void main(String[] args) {
	
		start();
	
	}
	
	public static void start() {
		
		Scanner sc=new Scanner(System.in);
		
		Doctor doc1=new Doctor();
		Guest g1=new Guest();
		Guest p1=new Guest();
		
		doc1.name="chris";
		doc1.age=40;
		
		g1.name="willson";
		g1.age=36;
		
		doc1.print_doc();
		System.out.println("==========");
		g1.print_guest();
		System.out.println("==========");
		
		//환자분 들어오세요
		doc1.doctor_guest_in(g1.name);
		
		//들어가려는 사람 이름 입력
		p1.name=sc.next();
		
		//맞는 환자 들어왔는지 의사가 확인
		if(doc1.is_guest_in(g1.guest_get_in(g1.name, p1.name))) {
			//맞는 환자 입장했으면 BMI 계산을 위해 키, 몸무게 물어보기
			double bmi=doc1.doctor_BMI_calc(g1.guest_provide_height(), g1.guest_provide_weight());
			
			g1.bmi=bmi;
			
			//BMI 결과 알려주기
			doc1.doctor_BMI_result(bmi);
		}
	}
}

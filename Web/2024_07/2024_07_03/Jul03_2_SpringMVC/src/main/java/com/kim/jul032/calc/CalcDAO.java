package com.kim.jul032.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

//멤버 변수가 없으면 static method로 구현하면 되긴 함
// M : DAO는 게시판 같은 기능을 구현한다고 치면 멤버 변수가 생길 수 밖에 없음 =>Static 기반 Method는 포기
// 요청 or 새로고침 시도시 new로 선언하면 cDAO 객체가 그 때마다 새로 생성됨
// 새로고침 할 때마다 메모리 점유가 늘어나는 구조의 코드가 되어버림, 거기다 allCalcCount도 제대로 작동하지 않음

//해결 방안 : CalcDAO를 싱글톤 처리해서 아예 객체를 리턴해주면 된다.
//Spring 식 싱글톤 선언 - servlet-context.xml에 calcDAO를 올려놓기 ( 코드로는 나타나지 않음 )

@Service
public class CalcDAO {
		
	private int allCalcCount; //총 계산 횟수
	
	public void calculate(CalcResult cr, HttpServletRequest req) {
		allCalcCount++;
		System.out.println("total calc : "+allCalcCount);
		
		int add = cr.getX()+cr.getY();
		req.setAttribute("add", add);
		
		System.out.println("x+y="+add);
	}
}

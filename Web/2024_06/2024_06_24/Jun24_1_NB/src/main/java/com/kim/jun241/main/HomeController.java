package com.kim.jun241.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {

     //숫자 야구
	//나 - 친구
	//제시할 숫자는 3자리수, 각 자리수는 중복이 되어서는 안됨, 백의 자리 0 가능
	//친구가 생각한 숫자를 내가 맞추는 게임
	//내가 부른값이 자릿수도 같고, 숫자도 같은 경우 1 스트라이크
	//자릿수는 다른데 숫자는 맞는 경우 1볼
	//3스트라이크 되는 순간 게임 종료
	//몇 번 만에 맞췄는지 알고싶음
	
	//내가 입력하는측, 친구가 컴퓨터 역할
	//숫자 아닌거 입력 못하게
	//중복 숫자 다시 입력하도록
	//무조건 3자리 숫자
	//조건 만족했는지 유효성 검사까지

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("V_num_baseball.jsp").forward(request, response);
		}
		else {
			M_computer.getMc().play(request);
			request.getRequestDispatcher("V_num_baseball.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//M_oddeven a =M_oddeven.getOe();
		//a.reset();
		request.getRequestDispatcher("V_num_baseball.jsp").forward(request, response);
	}

}

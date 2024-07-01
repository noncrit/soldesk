package com.kim.jun283.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/UserDetailController")
public class UserDetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = DAO.getDAO();
		
		if(dao.getUserDetail(request)) {
			request.setAttribute("contentPage_r", "userInfo.jsp");
			request.setAttribute("contentPage", "userDetail.jsp");
		
		}
		else {
			request.setAttribute("contentPage_r", "userInfo.jsp");
			request.setAttribute("contentPage", "home.jsp");
		}
		
		request.getRequestDispatcher("bone.jsp").forward(request, response);

	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String path=request.getServletContext().getRealPath("img");
		MultipartRequest mr = new MultipartRequest(
				request, path,
				//파일 업로드시 허용할 최대크기(byte단위)(10 MB)
				10 * 1024 * 1024,
				//request 파라미터의 인코딩 방식
				"UTF-8",
				//업로드한 파일 이름 중복시 파일이름 변경 루틴 지정
				//중복시에 파일명 뒤에 숫자를 붙이는 방식
				new DefaultFileRenamePolicy()
				);
		
		DAO dao=new DAO();
		UserUpdate uu = new UserUpdate();
		
		//userUpdate측 post 처리
		if(uu.UpdateUserDetail(request,mr)) {
			
			if(dao.getUserDetail(request,mr)) {
				request.setAttribute("contentPage_r", "userInfo.jsp");
				request.setAttribute("contentPage", "userDetail.jsp");
			}
			else {
				System.out.println("유저 정보 업데이트 후 유저 디테일 호출 실패 on UserDetailController");
				request.setAttribute("contentPage_r", "userInfo.jsp");
				request.setAttribute("contentPage", "userDetail.jsp");
			}
		}
		
		//userInfo 측 post 처리
		else if(dao.getUserDetail(request,mr)) {
			request.setAttribute("contentPage_r", "userInfo.jsp");
			request.setAttribute("contentPage", "userDetail.jsp");
		}
		

		else {
			System.out.println("dao.UpdateUserDetail(request)값 false");
			request.setAttribute("contentPage_r", "userInfo.jsp");
			request.setAttribute("contentPage", "userDetail.jsp");
		}
		
		request.getRequestDispatcher("bone.jsp").forward(request, response);
		
	}

}

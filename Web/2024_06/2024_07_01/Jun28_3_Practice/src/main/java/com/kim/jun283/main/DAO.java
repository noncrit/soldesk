package com.kim.jun283.main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kim.jun283.db.KimDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class DAO {
	
	private int allAccountNum=0;
	private int allPostNum=0;
	private int postNum=0;
	private static final DAO DAO = new DAO();
	
	public static DAO getDAO() {
		return DAO;
	}
	
	public boolean loginCheck(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("LoginedUser");
		//로그인이 유지중이거나 로그인에 성공했으면 위의 줄의 attribute가 있을것
		return (user!=null);
	}
	
	public void getAllAccountNum(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			
			con=KimDBManager.connect("ksjPool");
			String sql="SELECT * FROM JUN28_LOGIN";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				allAccountNum++;
			}
			request.setAttribute("allAccountNum", allAccountNum);
			allAccountNum=0;
					
		} catch (Exception e) {
			System.out.println("모든 계정 숫자 카운트 실패");
			e.printStackTrace();
		}
		
		
	}
	
	public void getAllPostNum(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			
			con=KimDBManager.connect("ksjPool");
			String sql="SELECT * FROM JUN28_LOGIN_BOARD";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				allPostNum++;
			}
			request.setAttribute("allPostNum", allPostNum);
			allPostNum=0;
					
		} catch (Exception e) {
			System.out.println("모든 게시글 숫자 카운트 실패");
			e.printStackTrace();
		}
		
		
	}
	
	public boolean register(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			String path=request.getServletContext().getRealPath("img");
			System.out.println(path); // 절대 경로의 위치
			
			//파일 업로드(원래의 request 객체를 덮어씀 + 저장 경로 지정)
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
			
//			String fileName = mr.getFilesystemName("j_IMG");
//			fileName = URLEncoder.encode(fileName,"UTF-8");
//			fileName = fileName.replace("+", " ");
			
			
			con=KimDBManager.connect("ksjPool");
			
			String j_ID=mr.getParameter("j_ID");
			String j_PW=mr.getParameter("j_PW");
			String j_PWC=mr.getParameter("j_PWC");
			String j_PN=mr.getParameter("j_PN");
			String j_NAME=mr.getParameter("j_NAME");
			String j_BIRTH=mr.getParameter("j_BIRTH");
			String j_IMG=mr.getFilesystemName("j_IMG");
//			request.setAttribute("fileName", j_IMG);
			
			System.out.println("DAO-register");
			System.out.println(j_ID);
			System.out.println(j_PW);
			System.out.println(j_PWC);
			System.out.println(j_NAME);
			System.out.println(j_PN);
			System.out.println(j_BIRTH);
			System.out.println(j_IMG);
			System.out.println("------------");
			
			if(pwdcheck(j_PW, j_PWC)) {
				
				String sql="INSERT INTO JUN28_LOGIN VALUES(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, j_ID);
				pstmt.setString(2, j_PW);
				pstmt.setString(3, j_PN);
				pstmt.setString(4, j_NAME);
				pstmt.setString(5, j_BIRTH);
				pstmt.setString(6, j_IMG);
				
				if(pstmt.executeUpdate()==1) {
					System.out.println("회원 가입 성공");
					return true;
				}
				else {
					System.out.println("회원 가입 실패");
					return false;
				}
				
			}
			else {
				System.out.println("pwdcheck fail");
				return false;
			}
			
		}
		 catch (Exception e) {
			System.out.println("회원가입 실패");
			e.printStackTrace();
		 }
		finally {
			KimDBManager.close(con, pstmt, null);
		}
		
		return false;	
		
	}
	
	public boolean pwdcheck(String pw, String pwc) {
		System.out.println("-----");
		System.out.println("pwdcheck");
		System.out.println(pw+" and " + pwc);
		
		if(pwc.equals(pw)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean login(HttpServletRequest request, HttpServletResponse response) {
		
		
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			request.setCharacterEncoding("UTF-8");
			con=KimDBManager.connect("ksjPool");
	
			
			
			String input_id=request.getParameter("j_ID");
			String input_pw=request.getParameter("j_PW");
			
			String sql_id=null;
			String sql_pw=null;
			String sql_img=null;
			
			String sql="SELECT J_ID,J_PW,J_IMG FROM JUN28_LOGIN WHERE J_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, input_id);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()){
				sql_id=rs.getString("J_ID");
				sql_pw=rs.getString("J_PW");
				sql_img=rs.getString("J_IMG");
			}
			System.out.println("input_id : "+input_id);
			System.out.println("sql_id : "+sql_id);
			System.out.println("input_pw : "+input_pw);
			System.out.println("input_id : "+sql_pw);
			System.out.println("J_IMG : "+sql_img);
			
			
			if(input_id.equals(sql_id)&&input_pw.equals(sql_pw)) {
				User LoginedUser = new User(sql_id,sql_pw,sql_img);
				request.getSession().setAttribute("LoginedUser",LoginedUser);
				request.getSession().setAttribute("LoginedUser_id", LoginedUser.getJ_ID());
				request.getSession().setAttribute("LoginedUser_pw", LoginedUser.getJ_PW());
				request.getSession().setAttribute("LoginedUser_img", LoginedUser.getJ_IMG());
				request.getSession().setMaxInactiveInterval(60);
				return true;
			}
			else {
				return false;
			}
			

		} catch (Exception e) {
			System.out.println("로그인 실패");
			e.printStackTrace();
		}
		System.out.println("로그인 실패");
		return false;
		
	}
	
	public boolean getUserDetail(HttpServletRequest request,MultipartRequest mr) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			
			request.setCharacterEncoding("UTF-8");
		
			con=KimDBManager.connect("ksjPool");
			
			String user_id=mr.getParameter("j_ID");
			
			String sql="SELECT * FROM JUN28_LOGIN WHERE j_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs=pstmt.executeQuery();
			
			User user =null;
			
			while(rs.next()) {
				user = new User();
				user.setJ_ID(rs.getString("j_ID"));
				user.setJ_PW(rs.getString("j_PW"));
				//user.setJ_PWC(rs.getString("j_PWC"));
				user.setJ_NAME(rs.getString("j_NAME"));
				user.setJ_PN(rs.getString("j_PN"));
				user.setJ_BIRTH(rs.getString("j_BIRTH"));
				user.setJ_IMG(rs.getString("j_IMG"));
				request.setAttribute("user", user);
				System.out.println("DAO : getUserDetail : 유저 객체 어트리뷰트화 성공");
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println("유저 세부정보 가져오기 실패");
			e.printStackTrace();
			return false;
			
		}
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
		return false;
		
	}
	
public boolean getUserDetail(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			
			request.setCharacterEncoding("UTF-8");
		
			con=KimDBManager.connect("ksjPool");
			
			String user_id=request.getParameter("j_ID");
			
			String sql="SELECT * FROM JUN28_LOGIN WHERE j_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs=pstmt.executeQuery();
			
			User user =null;
			
			while(rs.next()) {
				user = new User();
				user.setJ_ID(rs.getString("j_ID"));
				user.setJ_PW(rs.getString("j_PW"));
				//user.setJ_PWC(rs.getString("j_PWC"));
				user.setJ_NAME(rs.getString("j_NAME"));
				user.setJ_PN(rs.getString("j_PN"));
				user.setJ_BIRTH(rs.getString("j_BIRTH"));
				user.setJ_IMG(rs.getString("j_IMG"));
				request.setAttribute("user", user);
				System.out.println("DAO : getUserDetail : 유저 객체 어트리뷰트화 성공");
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println("유저 세부정보 가져오기 실패");
			e.printStackTrace();
			return false;
			
		}
		
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
		return false;
		
	}
	
	
	
	public void sessionClose(HttpServletRequest request) {
		request.getSession().invalidate();
	}
	
	public boolean deleteUser(HttpServletRequest request) {
		
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		try {
			request.setCharacterEncoding("UTF-8");
			con=KimDBManager.connect("ksjPool");
			
			String input_ID=request.getParameter("j_ID");
			String input_PW=request.getParameter("j_PW");
			
			String sql="SELECT J_ID,J_PW FROM JUN28_LOGIN WHERE J_ID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, input_ID);
			
			rs=pstmt.executeQuery();
			
			String j_PW_DB ="invalid";
			String j_ID_DB = "invalid";
			
			while(rs.next()) {
				j_PW_DB=rs.getString("J_PW");
				j_ID_DB=rs.getString("J_ID");
			}
			
			if(input_ID.equals(j_ID_DB) && input_PW.equals(j_PW_DB)) {
				String sql2 = "DELETE FROM JUN28_LOGIN WHERE J_ID=?";
				pstmt=con.prepareStatement(sql2);
				pstmt.setString(1, input_ID);
				
				if(pstmt.executeUpdate()==1) {
					System.out.println("삭제 성공");
					return true;
				}
				else {
					System.out.println("삭제 실패");
					return false;
				}
					
			}
			else {
				System.out.println("삭제 실패 - DB 데이터와 불일치");
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("삭제 실패 - Exception");
			e.printStackTrace();
			return false;
		}
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
		
	}
	
	public void writeBoard(HttpServletRequest request) {
		
		Connection con =null;
		PreparedStatement pstmt = null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");	
		Date date = new Date();
		
		try {
			
			request.setCharacterEncoding("UTF-8");
			con=KimDBManager.connect("ksjPool");
			
			String id=request.getParameter("BoardWriteUserID");
			String img=request.getParameter("BoardWriteUserIMG");
			String now=sdf.format(date);
			
			String text=request.getParameter("BoardWriteText");
			
			int currentAllPostNum=(int) request.getAttribute("allPostNum");
			
			System.out.println("currentAllPostNum: "+	 currentAllPostNum);
			
			
			String sql="INSERT INTO JUN28_LOGIN_BOARD VALUES(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, img);
			pstmt.setString(3, now);
			pstmt.setString(4, text);
			pstmt.setInt(5, currentAllPostNum+1);
			
			if(pstmt.executeUpdate()==1) {
				System.out.println("-------------");
				System.out.println("게시판 글쓰기 성공");
				postNum++;
				request.setAttribute("postNum", postNum);
			}
			else {
				System.out.println("-------------");
				System.out.println("게시판 글쓰기 실패 - pstmt.executeUpdate() 실패 ");
			}
			
			
			
		} catch (Exception e) {
			System.out.println("게시판 글쓰기 실패 : catch에 걸림");
			e.printStackTrace();
		}
		finally {
			KimDBManager.close(con, pstmt, null);
		}
		
	}
	
	public void showPostBy4(HttpServletRequest request, int i) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int PostPagingUserIN = i;


		try {
			con = KimDBManager.connect("ksjPool");

			String sql = "SELECT * FROM "
					+ "(SELECT ROWNUM AS RN, j_ID, j_IMG, doi, content, PostNum "
					+ "FROM JUN28_LOGIN_BOARD ORDER BY POSTNUM) "
					+ "WHERE RN BETWEEN ? AND ?";
					

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,(PostPagingUserIN * 4) - 3);
			pstmt.setInt(2,(PostPagingUserIN * 4));
			rs = pstmt.executeQuery();

			ArrayList<Board> posts = new ArrayList<Board>();

			Board board = null;

			while(rs.next()) {
				board = new Board();
				board.setJ_ID(rs.getString("j_ID"));
				board.setJ_IMG(rs.getString("j_IMG"));
				board.setDoi(rs.getString("doi"));
				board.setContent(rs.getString("content"));
				board.setPostNum(rs.getInt("PostNum"));
				posts.add(board);
				System.out.println("---------");
				System.out.println("show 파트 데이터 확인");
				System.out.println(board.getJ_ID());
				System.out.println(board.getJ_IMG());
			}

			request.setAttribute("posts", posts);


		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {
			KimDBManager.close(con, pstmt, rs);
		}

	}
	
	public void showPostBy4(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int PostPagingUserIN = Integer.parseInt((String) request.getParameter("BoardPagingUserIn"));
		System.out.println("----------------");
		System.out.println("PostPagingUserIN : "+ PostPagingUserIN);

		try {
			con = KimDBManager.connect("ksjPool");

			String sql ="SELECT * FROM "
					+ "(SELECT ROWNUM AS RN, j_ID, j_IMG, doi, content, PostNum "
					+ "FROM JUN28_LOGIN_BOARD ORDER BY POSTNUM) "
					+ "WHERE RN BETWEEN ? AND ?";


			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,(PostPagingUserIN * 4) - 3);
			pstmt.setInt(2,(PostPagingUserIN * 4));
			rs = pstmt.executeQuery();

			ArrayList<Board> posts = new ArrayList<Board>();

			Board board = null;

			while(rs.next()) {
				board = new Board();
				board.setJ_ID(rs.getString("j_ID"));
				board.setJ_IMG(rs.getString("j_IMG"));
				board.setDoi(rs.getString("doi"));
				board.setContent(rs.getString("content"));
				board.setPostNum(rs.getInt("postNum"));
				posts.add(board);
				allPostNum++;
			}

			request.setAttribute("posts", posts);

		} catch (Exception e) {
			System.out.println("DAO : showPostBy4 fail");
			e.printStackTrace();
		}

		finally {
			KimDBManager.close(con, pstmt, rs);
		}

	}
	
	public void updatePost_getPost(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int postNumIn=Integer.parseInt(request.getParameter("PostNum"));
		
		try {
			
			con=KimDBManager.connect("ksjPool");
			String sql = "SELECT * FROM JUN28_LOGIN_BOARD WHERE POSTNUM=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, postNumIn);
			rs=pstmt.executeQuery();
			Board post = null;
			
			while(rs.next()) {
				post = new Board();
				post.setJ_ID(rs.getString("j_ID"));
				post.setJ_IMG(rs.getString("j_IMG"));
				post.setDoi(rs.getString("doi"));
				post.setContent(rs.getString("content"));
				post.setPostNum(rs.getInt("postNum"));
				request.setAttribute("UpdatePost", post);
			}
			
		} catch (Exception e) {
			System.out.println("DAO : updatePost 실패 / Exception 발생");
			e.printStackTrace();
		}
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
	}
	
	public void updatePost(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			request.setCharacterEncoding("UTF-8");
			int UpdateTargetPostNum=Integer.parseInt(request.getParameter("UpdateTargetPostNum"));
			String contentUpdate=request.getParameter("BoardTextArea_Login_update");
			
			con=KimDBManager.connect("ksjPool");
			String sql = "UPDATE JUN28_LOGIN_BOARD SET CONTENT=? WHERE POSTNUM=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, contentUpdate);
			pstmt.setInt(2, UpdateTargetPostNum);
			
			System.out.println("---------------------");
			if(pstmt.executeUpdate()==1) {
				System.out.println("Update Post 성공");
			}
			else {
				System.out.println("At if - Update Post 실패");
			}
			
			
		} catch (Exception e) {
			System.out.println("DAO : updatePost 실패 / Exception 발생");
			e.printStackTrace();
		}
		finally {
			KimDBManager.close(con, pstmt, rs);
		}
		
	}
	
	
	
}

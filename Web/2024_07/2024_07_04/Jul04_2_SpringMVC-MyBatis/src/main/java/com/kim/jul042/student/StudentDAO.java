package com.kim.jul042.student;
/*
SqlSessionTemplate (servlet-context.xml 참조)
SqlSession의 하위 클래스
public class SqlSessioinTemplate implements SqlSession

SqlSessionTemplate
SqlSession의 기능은 다 들어있고 거기에 기능이 더 추가됨
자동 연결/자동 해제
자동 commit
*/

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDAO {
	
	//bean id:SqlSession에 엮인 친구들 다 불러와짐
	@Autowired
	private SqlSession ss;
	
	public void regStudent(Student s, HttpServletRequest req){
//		System.out.println(s.getS_name());
//		System.out.println(s.getS_nickname());
		
		try {
			//DB 연결(pool 생성 등등)을 자동으로 해줌 - xml에 선언해놨음
			
			//값을 받아오기&객체로 만들기 - Spring이 자동으로 해결해줬음
			
			//SQL문 - MyBatis 활용
			//interface 추상메소드 들고오기
			StudentMapper sm = ss.getMapper(StudentMapper.class);
			
			//interface에 있는 abstract method를 호출
			//Mapper.xml과 연결되어 있는 해당 부분이 실행됨(인터페이스의 추상 메소드 이름 = Mapper.xml의 ID)
			if(sm.regStudent(s)==1) {
				req.setAttribute("r", "학생 등록 성공");
			}
			//ss.commit(); 원래 해줘야 하지만, SqlSession이 자동으로 해줌
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "학생 등록 실패");
		}
	}
	
	public void getAllStudent(HttpServletRequest req) {
		try {
			List<Student> students = ss.getMapper(StudentMapper.class).getAllStudent();
			req.setAttribute("students", students);
			
			//한 줄로 줄인 버전
			req.setAttribute("students", ss.getMapper(StudentMapper.class).getAllStudent());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}

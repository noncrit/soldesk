package com.kim.jul031.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SimpleThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

//servelt-context.xml에 등록한 것과 같은 효과를 줌
@Service
public class MemberDAO {
	
	// 회원 가입 날짜를 연/월/일의 형태로 저장하고 있었음
	
	//운영자가 시/분/초 까지 저장이 되게끔 바꾸고 싶다고 요청함
	
	//요구사항
	//연/월/일 => 연-월-일 시:분:초
	//모든 사이트의 날짜 형식을 위와 같이 맞춘다면 싱글톤으로 봐도 무방
	@Autowired
	private SimpleDateFormat sdf;
	
	
	public void test() {
		//현재 시간을 받아오기 위한 util.date
		Date now = new Date();
		
		System.out.println(sdf.format(now));
		
	}
}

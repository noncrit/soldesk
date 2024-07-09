package com.kim.jul82.fruit;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void getAllFruit(HttpServletRequest req) {
		
		try {
			//req.setAttribute("fruits", ss.getMapper(FruitMapper.class).getAllFruit());
			List<Fruit> fruits = ss.getMapper(FruitMapper.class).getAllFruit();
			req.setAttribute("fruits", fruits);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Spring에서 XML 끌어오는 시스템 : XML AJAX Server
	//AJAX : Asynchronous JavaScript And Xml
	//원래 : 웹페이지 전체를 새로 고쳤음
	//페이지의 일부만을 서버에서 가지고 와서 화면을 변경하는 방식
	//대표적으로 자동완성이 있음
	//현재 : DB에 있는 과일데이터 하나를 표현 할 JavaBean(Fruit.java) 하나를 가지고 있는 상황
	//AJAX 이용을 위해 우리가 필요한 것
	//1. DB에 있는 과일 테이블을 표현 할 또 하나의 JavaBean이 필요함
	//2. Spring이 과일 데이터를 XML 형식으로 바꿀 수 있도록 각각의 JavaBean에(Class 명 위에) @XmlRootElement Annotation 필요
	//3. 2번에 선언한 XmlRootElement Bean들 Setter 측에 @XmlElement Annotation 선언
	//특정 데이터 => XML 형태로 바꾸는 것을 마샬링이라고 불렀음
	
	public Fruits getXML(HttpServletRequest req) {
		List<Fruit> fruits = ss.getMapper(FruitMapper.class).getAllFruit();
		//JavaBean에 리스트 넣어주기
		Fruits fruitss = new Fruits(fruits);
		return fruitss;
 	}
	
	public Fruits searchXML(Fruit f,HttpServletRequest req) {
		return new Fruits(ss.getMapper(FruitMapper.class).searchFruit(f) );
	}
}

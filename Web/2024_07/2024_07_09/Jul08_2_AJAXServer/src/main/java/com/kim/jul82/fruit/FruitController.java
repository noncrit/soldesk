package com.kim.jul82.fruit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FruitController {
	
	@Autowired
	private FruitDAO fDAO;
	
	@RequestMapping(value = "/fruit.get", method = RequestMethod.GET)
	public String getAllFruit(HttpServletRequest req) {
		
		fDAO.getAllFruit(req);
		return "index";
	}
	
	//보통의 컨트롤러는 페이지를 리턴하지만, 우리가 작성한 메소드는 데이터 자체를 리턴하는게 목적임
	//Spring 4 버전에서는 RestController를 이용해서 데이터를 보냄
	//근데 우리는 3버전 사용중 - @Controller + @ResponseBody 으로 구현
	//@ResponseBody - 데이터만 전달한다는 선언
	//produces 선언 부분 잘 보기
	@RequestMapping(value="/fruit.getXML", method = RequestMethod.GET,
			 produces="application/xml; charset=UTF-8")
	public @ResponseBody Fruits getFruitXML(HttpServletRequest req) {
		return fDAO.getXML(req);
	}
	
	@RequestMapping(value="/fruit.searchXML", method = RequestMethod.GET,
			 produces="application/xml; charset=UTF-8")
	public @ResponseBody Fruits searchFruitXML(Fruit f,HttpServletRequest req) {
		return fDAO.searchXML(f, req);
	}
	
}

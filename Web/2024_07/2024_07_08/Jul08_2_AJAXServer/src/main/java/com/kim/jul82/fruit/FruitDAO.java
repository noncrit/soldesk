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
	
	public void getAllFruit(Fruit f,HttpServletRequest req) {
		
		try {
			List<Fruit> fruits = ss.getMapper(FruitMapper.class).getAllFruit();
			req.setAttribute("fruits", fruits);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

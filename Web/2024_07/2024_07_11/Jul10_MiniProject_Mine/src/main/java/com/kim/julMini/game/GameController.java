package com.kim.julMini.game;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kim.julMini.user.User;

@Controller
public class GameController {
	
	@Autowired
	private GameDAO GDAO;
	
	@RequestMapping(value="/game.getData", method=RequestMethod.GET,
			produces="application/xml; charset=UTF-8")
	public @ResponseBody String getKoreaWeather(HttpServletRequest req) {
		return GDAO.getData(req);
	}
	
	@RequestMapping(value="/game.gameResult", method=RequestMethod.GET)
	public void winGame(HttpServletRequest req) {
		GDAO.gameResult(req);
	}
	
	@RequestMapping(value="/game.userResult", method=RequestMethod.POST,
			produces = "application/json; charset=UTF-8")
	public @ResponseBody List<User> userResult(User u, HttpServletRequest req) {
		return GDAO.userResult(u, req);
	}
	
	@RequestMapping(value="/game.regUser", method=RequestMethod.POST)
	public void regUser(User u, HttpServletRequest req) {
		GDAO.regUser(req);
	}
	
	@RequestMapping(value="/game.isUser",  method=RequestMethod.POST,
			produces = "application/json; charset=UTF-8")
	public @ResponseBody List<User> isUser(User u, HttpServletRequest req) {
		//return GDAO.isUser(req);
		return GDAO.userResult(u, req);
	}
	
}

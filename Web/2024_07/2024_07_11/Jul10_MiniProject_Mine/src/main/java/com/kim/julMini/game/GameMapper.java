package com.kim.julMini.game;

import java.util.List;

import com.kim.julMini.user.User;

public interface GameMapper {
	
	public abstract List<User> getUserResult(User u);
	
	public abstract int updateUserRecord(User u);
	
	public abstract int regUser(User u);
	
}

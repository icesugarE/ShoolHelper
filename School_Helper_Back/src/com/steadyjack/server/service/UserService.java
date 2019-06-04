package com.steadyjack.server.service;

import java.util.List;

import com.steadyjack.server.model.User;

public interface UserService {
	
	public void setUser(User user);
	
	public int reviseUser(User user);
	
	public List<User> getAllUser();
	
	public User checkUser(int i);
	public User checkUser(User user);
}

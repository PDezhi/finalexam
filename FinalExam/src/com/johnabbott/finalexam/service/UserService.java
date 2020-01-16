package com.johnabbott.finalexam.service;


import com.johnabbott.finalexam.model.User;

public interface UserService {

	public boolean checkUser(User user) ;

	public boolean registerUser(User user);
	
}

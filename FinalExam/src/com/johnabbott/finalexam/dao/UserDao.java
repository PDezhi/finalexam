package com.johnabbott.finalexam.dao;

import com.johnabbott.finalexam.model.User;

public interface UserDao {

	public int insertUser(User user); 
	public User getUserByEmail(String email);

}

package com.johnabbott.finalexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.johnabbott.finalexam.dao.UserDao;
import com.johnabbott.finalexam.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public boolean checkUser(User user) {
		String password1 = userDao.getUserByEmail(user.getEmail()).getPassword();
		String password2 = user.getPassword();
		if(password1 == null) {
			return false;
			
		}
		else if(password1.equals(password2)){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean registerUser(User user) {
		return userDao.insertUser(user) > 0 ;
	}

}

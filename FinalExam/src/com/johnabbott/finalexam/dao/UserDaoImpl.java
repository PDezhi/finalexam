package com.johnabbott.finalexam.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.johnabbott.finalexam.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUserByEmail(String email) {
		String hql = "from User where email= :email";
		Query query = getSession().createQuery(hql);
		query.setParameter("email",email);
		if (query.list().size() > 0) {
			return (User)query.list().get(0);
		}
		else {
			return new User();
		}
			
	}

	@Override
	public int insertUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return 1;
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

}

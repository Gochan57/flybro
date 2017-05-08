package com.volgadev.springtemplate.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.volgadev.springtemplate.model.User;



@Repository
public class UserCustomRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Set<User> getAllUsers() {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT u FROM User u ORDER BY u.user_id");
		List<User> list = (List<User>) query.list();
		Set<User> result = new HashSet<User>(list);
		return result;
	}

	public User findUserById(Integer userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u WHERE u.user_id = :ID");
		query.setParameter("ID", userId);
		User user = (User) query.list().get(0);
		return user;
	}
}

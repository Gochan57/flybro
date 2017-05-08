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

	public List<User> getAllUsers() {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT u FROM User u");
		List<User> result = (List<User>) query.list();
		return result;
	}

	public User findUserById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u WHERE u.id = :ID");
		query.setParameter("ID", id);
		User user = (User) query.list().get(0);
		return user;
	}

//	public Role findRoleById(Integer id) {
//		Query query = sessionFactory.getCurrentSession().createQuery("SELECT r FROM Role r WHERE r.id = :ID");
//		query.setParameter("ID", id);
//		Role role = (Role) query.list().get(0);
//		return role;
//	}

}

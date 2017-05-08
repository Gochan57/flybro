package com.volgadev.springtemplate.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.volgadev.springtemplate.model.Flight;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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

	public User findUserById(Integer userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u WHERE u.userId = :USER_ID");
		query.setParameter("USER_ID", userId);
		if(query.list() == null || query.list().size() == 0) {
			return null;
		}
		User user = (User) query.list().get(0);
		return user;
	}

	public Set<Flight> getFlights(User user) {
		String sql = "SELECT f.* FROM \"user\" u " +
				"INNER JOIN user_to_flight u2f ON (u.user_id = u2f.user_id AND u.user_id = :USER_ID)\n" +
				"INNER JOIN flight f on (f.flight_id = u2f.flight_id)";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Flight.class);
		query.setParameter("USER_ID", user.getUserId());
		return new HashSet<Flight>(query.list());
	}
}

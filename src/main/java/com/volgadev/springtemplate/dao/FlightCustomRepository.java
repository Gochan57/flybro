package com.volgadev.springtemplate.dao;

import com.volgadev.springtemplate.model.Flight;
import com.volgadev.springtemplate.model.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
public class FlightCustomRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Flight> getAllFlights() {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT f FROM Flight f");
		List<Flight> result = (List<Flight>) query.list();
		return result;
	}

	public Flight findFlightById(Integer flightId) {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT f FROM Flight f WHERE f.flight_id = :FLIGHT_ID");
		query.setParameter("FLIGHT_ID", flightId);
		if(query.list() == null || query.list().size() == 0) {
			return null;
		}
		Flight flight = (Flight) query.list().get(0);
		return flight;
	}

	public Set<User> getUsers(Flight flight) {
		String sql = "SELECT u.* FROM flight f " +
				"INNER JOIN user_to_flight u2f ON (f.flight_id = u2f.flight_id AND f.flight_id = :FLIGHT_ID) " +
				"INNER JOIN \"user\" u ON (u.user_id = u2f.user_id)";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(User.class);
		query.setParameter("FLIGHT_ID", flight.getFlightId());
		return new HashSet<User>(query.list());
	}
}

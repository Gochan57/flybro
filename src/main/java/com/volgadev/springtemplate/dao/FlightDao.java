package com.volgadev.springtemplate.dao;

import com.volgadev.springtemplate.model.User;
import org.springframework.data.repository.CrudRepository;


public interface FlightDao extends CrudRepository<User, Integer> {
	
}

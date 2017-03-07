package com.volgadev.springtemplate.dao;

import org.springframework.data.repository.CrudRepository;
import com.volgadev.springtemplate.model.User;



public interface UserDao extends CrudRepository<User, Integer> {
	
}

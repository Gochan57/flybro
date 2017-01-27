package com.hms.pro.dao;

import org.springframework.data.repository.CrudRepository;

import com.hms.pro.model.User;

public interface UserDao extends CrudRepository<User, Integer> {
	
}

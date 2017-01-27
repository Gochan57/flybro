package com.hms.pro.service;

import java.util.List;

import com.hms.pro.dto.UserDTO;
import com.hms.pro.model.User;

public interface UserService {
	
	List<User> findAll();

	void saveUser(UserDTO userDTO);
	
	void deleteUser(Integer id);

	User getUser(Integer id);
	
}

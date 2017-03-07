package com.volgadev.springtemplate.service;

import java.util.Set;

import com.volgadev.springtemplate.dto.UserDTO;
import com.volgadev.springtemplate.model.User;

public interface UserService {

	Set<User> findAll();

	void saveUser(UserDTO userDTO);

	void deleteUser(Integer id);

	User getUser(Integer id);

}

package com.volgadev.springtemplate.service;

import java.util.List;
import java.util.Set;

import com.volgadev.springtemplate.dto.UserDTO;
import com.volgadev.springtemplate.model.Flight;
import com.volgadev.springtemplate.model.User;

public interface UserService {

	List<User> findAll();

	void saveUser(UserDTO userDTO);

	void deleteUser(Integer id);

	User getUser(Integer id);

	Set<Flight> getFlights(User user);

}

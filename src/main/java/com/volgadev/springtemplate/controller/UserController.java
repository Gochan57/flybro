package com.volgadev.springtemplate.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.volgadev.springtemplate.dto.UserDTO;
import com.volgadev.springtemplate.model.User;
import com.volgadev.springtemplate.service.UserService;



@Controller
@RequestMapping(value = "/users")
public class UserController {
	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	 
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
    public List<User> findAll(@RequestParam(value="name", required=false) String name) {
        return userService.findAll();
    }
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
    public User findOne(@RequestParam Integer id) {
        return userService. getUser(id);
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void addUser(@RequestBody UserDTO userDTO) {
		userService.saveUser(userDTO);
	}

	@RequestMapping(value = "/delete",  method = RequestMethod.DELETE)
	public void deleteUser(@RequestParam Integer id) {
		this.userService.deleteUser(id);
	}

	@RequestMapping(value = "/edit",  method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void editUser(@RequestBody UserDTO userDTO) {
		userService.saveUser(userDTO);
	}

}

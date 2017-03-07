package com.volgadev.springtemplate.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

	private Integer id;

	private String name;

	private String login;

	private String password;

	List<Integer> rolesId = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Integer> getRolesId() {
		return rolesId;
	}

	public void setRolesId(List<Integer> rolesId) {
		this.rolesId = rolesId;
	}

}

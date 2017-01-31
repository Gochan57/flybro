package com.hms.pro.serviceImpl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.pro.dao.UserCustomRepository;
import com.hms.pro.dao.UserDao;
import com.hms.pro.dto.UserDTO;
import com.hms.pro.model.Role;
import com.hms.pro.model.User;
import com.hms.pro.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired(required = true)
	private UserDao userDao;
	@Autowired
	UserCustomRepository userCustomRepository;

	public Set<User> findAll() {
		return (Set<User>) userCustomRepository.getAllUsers();
	}

	public void saveUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setLogin(userDTO.getLogin());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		for (int i = 0; i < userDTO.getRolesId().size(); i++) {
			Role roleToAdd = userCustomRepository.findRoleById(userDTO.getRolesId().get(i));
			user.addRole(roleToAdd);
		}

		userDao.save(user);
	}

	public void deleteUser(Integer id) {
		userDao.delete(id);
	}

	public User getUser(Integer id) {
		return userCustomRepository.findUserById(id);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}

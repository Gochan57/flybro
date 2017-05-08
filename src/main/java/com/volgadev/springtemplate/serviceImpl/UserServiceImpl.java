package com.volgadev.springtemplate.serviceImpl;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.volgadev.springtemplate.dao.UserCustomRepository;
import com.volgadev.springtemplate.dao.UserDao;
import com.volgadev.springtemplate.dto.UserDTO;
import com.volgadev.springtemplate.model.User;
import com.volgadev.springtemplate.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired(required = true)
	private UserDao userDao;
	@Autowired
	UserCustomRepository userCustomRepository;

	public List<User> findAll() {
		return /*(List<User>) userCustomRepository.getAllUsers();*/ (List<User>)userDao.findAll();
	}

	public void saveUser(UserDTO userDTO) {
		User user = new User();
		user.setUserId(userDTO.getUserId());

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

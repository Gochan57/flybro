package com.hms.pro.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.pro.model.Role;
import com.hms.pro.model.User;

@Repository
public class UserCustomRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getAllUsers() {
		Query query=sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u , IN(u.roles) r ORDER BY u.id");
		 List<User> list = query.list();
		 List<User> finishList = new ArrayList<>();
		 
		 finishList.add(list.get(0));
		 for (int i = 0; i < list.size()-1; i++) {
			 if(list.get(i).getId()!=list.get(i+1).getId())
				 finishList.add(list.get(i+1));
		    }
		return finishList;
	}
	
	public User findUserById(Integer id){
		Query query=sessionFactory.getCurrentSession().createQuery("SELECT u FROM User u WHERE u.id = :ID");
		query.setParameter("ID", id);
		User user = (User) query.list().get(0);
		return user;
		}

	public Role findRoleById(Integer id){
		Query query=sessionFactory.getCurrentSession().createQuery("SELECT r FROM Role r WHERE r.id = :ID");
		query.setParameter("ID", id);
		Role role = (Role) query.list().get(0);
		return role;
		}

}

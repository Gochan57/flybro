package com.hms.pro.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.pro.model.Dream;

@Repository
public class DreamCustomRepository {

	@Autowired
	private SessionFactory sessionFactory;


	public Dream findDreamById(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT d FROM Dream d WHERE d.id = :ID");
		query.setParameter("ID", id);
		Dream user = (Dream) query.list().get(0);
		return user;
	}


}

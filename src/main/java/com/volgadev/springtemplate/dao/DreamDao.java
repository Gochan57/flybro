package com.volgadev.springtemplate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.volgadev.springtemplate.model.Dream;


@Repository
public class DreamDao {

	private SessionFactory sessionFactory;

	public void addDream(Dream dream) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(dream);
	}
	public void updateDream(Dream dream) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(dream);
	}

	public void removeDream(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Dream dream = (Dream) session.load(Dream.class, new Integer(id));
		if (dream != null)
			session.delete(dream);
	}

	public Dream getDreamBuId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Dream dream = (Dream) session.load(Dream.class, new Integer(id));
		return dream;
	}

	@SuppressWarnings("unchecked")
	public List<Dream> listDreams() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Dream> dreamsList = session.createQuery("from Dream").list();
		return dreamsList;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}

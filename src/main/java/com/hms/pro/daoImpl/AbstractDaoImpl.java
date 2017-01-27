package com.hms.pro.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import com.hms.pro.dao.AbstractDao;

public abstract class AbstractDaoImpl<E, I extends Serializable> implements AbstractDao<E, I > {

	private Class<E> entityClass;
	
	public AbstractDaoImpl(Class<E> entityClass){
			this.entityClass=entityClass;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public I save(E e) {
		I id=(I) getCurrentSession().save(e);
		return id;
	}

	public void saveOrUpdate(E e) {
		getCurrentSession().saveOrUpdate(e);
	}

	public void delete(E e) {
		getCurrentSession().delete(e);
	}

	@SuppressWarnings("unchecked")
	public E get(I i) {

		return (E) getCurrentSession().get(entityClass, i);
	}

	@SuppressWarnings("unchecked")
	public List<E> find(Query qry) {
		
		return (List<E>)qry.list();
	}
	

	public List<?> excuteQuery(Query qry, Class<?> bindResult){
		return  qry.setResultTransformer(new AliasToBeanResultTransformer(bindResult)).list();
	}
	
	public void saveAll(List<E> e)
	{
		for (E e2 : e) {
			getCurrentSession().save(e2);
		}
	}
	
	public Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
}

package com.hms.pro.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

public interface AbstractDao<E, I extends Serializable> {

    I save(E e);
	
	void saveOrUpdate(E e);
	
	void delete(E e);
	
	E get(I i);
	
	List<E> find(Query qry);
	
   void saveAll(List<E> e);
  
}

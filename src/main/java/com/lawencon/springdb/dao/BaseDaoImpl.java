package com.lawencon.springdb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDaoImpl {

	@PersistenceContext
	public EntityManager em;

}

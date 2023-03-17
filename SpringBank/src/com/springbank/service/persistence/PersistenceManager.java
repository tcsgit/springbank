package com.springbank.service.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.springbank.entity.Entity;


public interface PersistenceManager {
	
	public Entity findById(Class entityClass, Serializable id) throws PersistenceException;
	
	public Entity findByIdWithRelation(Class entityClass, Serializable id) throws PersistenceException;
	
	public List findAll(Class entityClass) throws PersistenceException;

	public List findByExample(Entity entity) throws PersistenceException;
	
	public Entity findUniqueResultByQuery(String query) throws PersistenceException;
	
	public Entity findUniqueResultByQueryWithRelation(String query) throws PersistenceException;	
	
	public List findByQuery(String query) throws PersistenceException;

	public void save(Entity entity) throws PersistenceException;

	public void update(Entity entity) throws PersistenceException;
	
	public void saveOrUpdate(Entity entity) throws PersistenceException;
	
	public void delete(Entity entity) throws PersistenceException;
	
	public Session getSession() throws PersistenceException;
	
}

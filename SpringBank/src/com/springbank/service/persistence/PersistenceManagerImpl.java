package com.springbank.service.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.springbank.entity.Entity;


public class PersistenceManagerImpl implements PersistenceManager{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public Entity findById(Class entityClass, Serializable id) throws PersistenceException {
		Entity entity = null;
		try {
			entity = (Entity)sessionFactory.getCurrentSession().get(entityClass, id);	
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return entity;
	}

	public Entity findByIdWithRelation(Class entityClass, Serializable id) throws PersistenceException {
		Entity entity = null;
		try {
			entity = (Entity)sessionFactory.getCurrentSession().get(entityClass, id);
			entity.bindRelation();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return entity;
	}

	public List findAll(Class entityClass) throws PersistenceException {
		List list;
		try {
			list = sessionFactory.getCurrentSession().createCriteria(entityClass).list();			
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

	public List findByExample(Entity entity) throws PersistenceException {
		List list;
		try {
			list = sessionFactory.getCurrentSession().createCriteria(entity.getClass()).add(Example.create(entity)).list();			
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}
	
	public Entity findUniqueResultByQuery(String query) throws PersistenceException {
		Entity entity = null;
		try {
			entity = (Entity)sessionFactory.getCurrentSession().createQuery(query).uniqueResult();			
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return entity;
	}
	
	public Entity findUniqueResultByQueryWithRelation(String query) throws PersistenceException {
		Entity entity = null;
		try {
			entity = (Entity)sessionFactory.getCurrentSession().createQuery(query).uniqueResult();
			entity.bindRelation();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return entity;
	}

	public List findByQuery(String query) throws PersistenceException {
		List list;
		try {
			list = sessionFactory.getCurrentSession().createQuery(query).list();			
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		return list;
	}

	public void save(Entity entity) throws PersistenceException {
		try {
			sessionFactory.getCurrentSession().save(entity);
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}

	public void update(Entity entity) throws PersistenceException {
		try {
			sessionFactory.getCurrentSession().update(entity);
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}

	public void saveOrUpdate(Entity entity) throws PersistenceException {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(entity);
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}

	public void delete(Entity entity) throws PersistenceException {
		try {
			sessionFactory.getCurrentSession().delete(entity);
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
	}
	
	public Session getSession() throws PersistenceException {
		try {
			return sessionFactory.openSession();
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}	 
	}
	
}

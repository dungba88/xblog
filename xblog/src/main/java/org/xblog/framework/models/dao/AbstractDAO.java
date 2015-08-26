package org.xblog.framework.models.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractDAO<T> implements DAOInterface<T> {

	@Autowired
	private SessionFactory sessionFactory;

	protected abstract Class<?> getModelClass();

	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(getModelClass(), id);
	}

	@SuppressWarnings("unchecked")
	protected T getByField(String fieldName, Object fieldValue) {
		Criteria criteria = createCriteria();
		return (T) criteria.add(Restrictions.eq(fieldName, fieldValue))
				.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> getListByField(String fieldName, Object fieldValue) {
		Criteria criteria = createCriteria();
		return (List<T>) criteria.add(Restrictions.eq(fieldName, fieldValue))
				.list();
	}

	protected Criteria createCriteria() {
		Session session = getCurrentSession();
		return session.createCriteria(getModelClass());
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Session openSession() {
		return sessionFactory.getCurrentSession();
	}
}

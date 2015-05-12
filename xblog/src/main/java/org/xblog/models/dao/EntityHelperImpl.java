package org.xblog.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class EntityHelperImpl implements EntityHelper {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public <T> T getEntityFromId(Class<T> clazz, int id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(clazz, id);
	}
}

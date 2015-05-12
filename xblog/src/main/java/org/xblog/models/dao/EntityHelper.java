package org.xblog.models.dao;

public interface EntityHelper {
	
	public <T> T getEntityFromId(Class<T> clazz, int id);
}

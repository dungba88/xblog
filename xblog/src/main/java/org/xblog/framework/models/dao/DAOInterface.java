package org.xblog.framework.models.dao;

import java.io.Serializable;

public interface DAOInterface<T> {

	public T get(Serializable id);
}

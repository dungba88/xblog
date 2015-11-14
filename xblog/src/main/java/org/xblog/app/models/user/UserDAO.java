package org.xblog.app.models.user;

import org.xblog.framework.models.dao.DAOInterface;

public interface UserDAO extends DAOInterface<User> {

	public User getByUserName(String userName);
	
	public User getByAlias(String alias);
}

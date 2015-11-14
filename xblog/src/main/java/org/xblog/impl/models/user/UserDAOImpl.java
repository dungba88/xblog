package org.xblog.impl.models.user;

import org.springframework.stereotype.Component;
import org.xblog.app.models.user.User;
import org.xblog.app.models.user.UserDAO;
import org.xblog.framework.models.dao.AbstractDAO;

@Component
public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

	protected Class<?> getModelClass() {
		return User.class;
	}

	@Override
	public User getByUserName(String userName) {
		return getByField("userName", userName);
	}
	
	@Override
	public User getByAlias(String alias) {
		return getByField("alias", alias);
	}
}

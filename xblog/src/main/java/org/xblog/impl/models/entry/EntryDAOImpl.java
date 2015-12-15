package org.xblog.impl.models.entry;

import java.util.List;

import org.springframework.stereotype.Component;
import org.xblog.app.models.entry.Entry;
import org.xblog.app.models.entry.EntryDAO;
import org.xblog.framework.models.dao.AbstractDAO;

@Component
public class EntryDAOImpl extends AbstractDAO<Entry> implements EntryDAO {

	@Override
	protected Class<?> getModelClass() {
		return Entry.class;
	}

	@Override
	public List<Entry> getEntriesByUser(int userId) {
		return getListByField("userId", userId);
	}

	@Override
	public List<Entry> getEntriesByUser(String userAlias) {
		return getListByField("userAlias", userAlias);
	}
	
	@Override
	public Entry getByAlias(String alias) {
		return getByField("alias", alias);
	}

	@Override
	public List<Entry> getEntries() {
		return getList();
	}
}

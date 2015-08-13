package org.xblog.app.models.entry;

import java.util.List;

import org.xblog.framework.models.dao.DAOInterface;

public interface EntryDAO extends DAOInterface<Entry> {

	public List<Entry> getEntriesByUser(int userId);

	public Entry getByAlias(String alias);
}

package org.xblog.framework.models;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class XblogNamingStrategy extends ImprovedNamingStrategy {

	private static final long serialVersionUID = -1877127369279461170L;
	
	private String prefix;
	
	@Override
	public String classToTableName(String className) {
		String name = super.classToTableName(className) + "s";
		if (prefix != null)
			return prefix + name;
		return name;
	}
	
	@Override
	public String tableName(String tableName) {
		String name = super.tableName(tableName);
		if (prefix != null)
			return prefix + name;
		return name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}

package org.xblog.framework.configs;

import java.util.HashMap;
import java.util.Map;

public class XblogConfig {

	private static volatile XblogConfig instance;
	
	private Map<String, XblogConfigItem> configurations;
	
	private XblogConfig() {
	}
	
	public static XblogConfig getInstance() {
		if (instance == null) {
			synchronized (XblogConfig.class) {
				if (instance == null) {
					instance = new XblogConfig();
				}
			}
		}
		return instance;
	}
	
	public XblogConfigItem getConfiguration(String key) {
		return getConfigurations().get(key);
	}

	public Map<String, XblogConfigItem> getConfigurations() {
		if (configurations == null)
			return new HashMap<String, XblogConfigItem>();
		return configurations;
	}

	public void setConfigurations(Map<String, XblogConfigItem> configurations) {
		this.configurations = configurations;
	}
}

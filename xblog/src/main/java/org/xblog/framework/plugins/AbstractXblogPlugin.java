package org.xblog.framework.plugins;

import java.util.HashMap;
import java.util.Map;

import org.xblog.framework.configs.XblogConfig;
import org.xblog.framework.configs.XblogConfigItem;
import org.xblog.framework.constants.ConfigConstants;

public abstract class AbstractXblogPlugin implements Plugin {
	
	private boolean active;
	
	protected Object getPluginConfig(String key) {
		return XblogConfig.getInstance().getConfiguration(getId()).get(key);
	}
	
	@SuppressWarnings("unchecked")
	protected Map<String, Object> getModel() {
		Object value = getPluginConfig(ConfigConstants.PLUGIN_MODEL);
		if (value == null || !(value instanceof Map)) {
			return new HashMap<String, Object>();
		}
		return (Map<String, Object>) value;
	}
	
	protected Object getConfig(String key) {
		return XblogConfig.getInstance().getConfiguration(ConfigConstants.PLUGIN_CONFIG).get(key);
	}
	
	protected Object getConfig(String key, Object defaultValue) {
		Object value = getConfig(key);
		if (value == null)
			return defaultValue;
		return value;
	}
	
	protected String getConfigAsString(String key) {
		Object value = getConfig(key);
		if (value == null)
			return null;
		return value.toString();
	}
	
	protected String getConfigAsString(String key, String defaultValue) {
		Object value = getConfig(key);
		if (value == null)
			return defaultValue;
		return value.toString();
	}
	
	@Override
	public void setConfigItem(XblogConfigItem configItem) {
		XblogConfig.getInstance().getConfigurations().put(getId(), configItem);
	}
	
	@Override
	public String getId() {
		return this.getClass().getName();
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}
}

package org.xblog.framework.plugins;

import org.xblog.framework.configs.XblogConfigItem;
import org.xblog.framework.interceptors.Observer;

public interface Plugin extends Observer {

	public void setConfigItem(XblogConfigItem configItem);
	
	public String getId();
	
	public boolean isActive();
	
	public void setActive(boolean active);
}

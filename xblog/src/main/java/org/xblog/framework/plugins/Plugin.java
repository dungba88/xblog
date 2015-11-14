package org.xblog.framework.plugins;

import org.xblog.framework.configs.XblogConfigItem;

public interface Plugin extends Observer {

	public void setConfigItem(XblogConfigItem configItem);
	
	public String getId();
	
	public boolean isActive();
	
	public void setActive(boolean active);
}

package org.xblog.framework.plugins.messages;

public interface XblogPayload {

	public Object getExtraData(String key);
	
	public void putExtraData(String key, Object object);
}

package org.xblog.framework.interceptors;

import org.xblog.framework.plugins.messages.XblogMessage;

public interface Observer {

	public void onMessage(XblogMessage message);
}

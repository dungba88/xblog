package org.xblog.framework.plugins;

import org.xblog.framework.plugins.messages.XblogMessage;

public interface Observer {

	public void onMessage(XblogMessage message);
}

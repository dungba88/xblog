package org.xblog.framework.plugins;

import java.util.List;

import org.xblog.framework.plugins.messages.XblogMessage;

public interface Subject {
	
	public List<Observer> getObservers();
	
	public void setObservers(List<Observer> observers);

	public void notifyMessage(XblogMessage message);
}

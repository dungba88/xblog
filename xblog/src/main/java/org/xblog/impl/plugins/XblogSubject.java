package org.xblog.impl.plugins;

import java.util.List;

import org.xblog.framework.interceptors.Observer;
import org.xblog.framework.interceptors.Subject;
import org.xblog.framework.plugins.messages.XblogMessage;

public class XblogSubject implements Subject {
	
	private List<Observer> observers;

	@Override
	public List<Observer> getObservers() {
		return observers;
	}

	@Override
	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	@Override
	public void notifyMessage(XblogMessage message) {
		if (observers != null && message != null && message.getEvent() != null) {
			for (Observer observer : observers) {
				observer.onMessage(message);
			}
		}
	}

}

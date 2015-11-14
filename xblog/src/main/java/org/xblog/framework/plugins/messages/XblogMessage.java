package org.xblog.framework.plugins.messages;

public class XblogMessage {

	private String event;
	
	private XblogPayload payload;
	
	public XblogMessage() {
		
	}
	
	public XblogMessage(String event, XblogPayload payload) {
		this.event = event;
		this.payload = payload;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public XblogPayload getPayload() {
		return payload;
	}

	public void setPayload(XblogPayload payload) {
		this.payload = payload;
	}
}

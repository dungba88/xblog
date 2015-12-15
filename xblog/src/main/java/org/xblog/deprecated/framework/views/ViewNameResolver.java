package org.xblog.framework.views;

import org.springframework.web.method.HandlerMethod;

public interface ViewNameResolver {

	public String resolveViewName();
	
	public void setHandlerMethod(HandlerMethod handlerMethod);
}

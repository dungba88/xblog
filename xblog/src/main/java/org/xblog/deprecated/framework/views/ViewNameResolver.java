package org.xblog.deprecated.framework.views;

import org.springframework.web.method.HandlerMethod;

@Deprecated
public interface ViewNameResolver {

	public String resolveViewName();
	
	public void setHandlerMethod(HandlerMethod handlerMethod);
}

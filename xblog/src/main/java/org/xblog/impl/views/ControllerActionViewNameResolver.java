package org.xblog.impl.views;

import org.springframework.web.method.HandlerMethod;
import org.xblog.framework.views.ViewNameResolver;

public class ControllerActionViewNameResolver implements ViewNameResolver {
	
	private String suffix;
	
	private String prefix;
	
	private HandlerMethod handlerMethod;

	@Override
	public String resolveViewName() {
		String controllerName = handlerMethod.getBean()
				.getClass().getSimpleName();
		String actionName = handlerMethod.getMethod()
				.getName();
		
		String viewName = resolveViewName(controllerName, actionName);

		return prefix + viewName + suffix;
	}

	private String resolveViewName(String controllerName, String actionName) {
		int idx = controllerName.indexOf("Controller");
		controllerName = controllerName.substring(0, 1).toLowerCase() + controllerName.substring(1, idx);
		return controllerName + "/" + actionName;
	}

	@Override
	public void setHandlerMethod(HandlerMethod handlerMethod) {
		this.handlerMethod = handlerMethod;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}

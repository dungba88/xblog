package org.xblog.deprecated.framework.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.xblog.deprecated.framework.views.ViewNameResolver;

/**
 * Intercepter for automatically resolving view name
 * @author griever
 *
 */
@Deprecated
public class PageViewResolverInterceptor extends HandlerInterceptorAdapter {
	
	private ViewNameResolver viewNameResolver;
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if (!(handler instanceof HandlerMethod))
			return;
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		
		String controllerName = handlerMethod.getBean()
				.getClass().getName();
		String actionName = handlerMethod.getMethod()
				.getName();
		
		// add controller and action name
		if (modelAndView == null)
			return;
		modelAndView.addObject("controllerName", controllerName);
		modelAndView.addObject("actionName", actionName);
		
		// resolve view
		if (viewNameResolver != null) {
			viewNameResolver.setHandlerMethod(handlerMethod);
			modelAndView.setViewName(viewNameResolver.resolveViewName());
		}
	}

	public ViewNameResolver getViewNameResolver() {
		return viewNameResolver;
	}

	public void setViewNameResolver(ViewNameResolver viewNameResolver) {
		this.viewNameResolver = viewNameResolver;
	}
}

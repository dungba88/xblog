package org.xblog.framework.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.xblog.framework.constants.MessageConstants;
import org.xblog.framework.plugins.messages.HandlerInterceptorPayload;
import org.xblog.framework.plugins.messages.XblogMessage;

public class SubjectInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private Subject subject;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		
		if (!(handler instanceof HandlerMethod))
			return true;

		XblogMessage message = new XblogMessage(MessageConstants.PRE_HANDLE, 
				new HandlerInterceptorPayload(request, response, handler, null));
		
		if (subject != null)
			subject.notifyMessage(message);
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if (!(handler instanceof HandlerMethod))
			return;
		
		XblogMessage message = new XblogMessage(MessageConstants.POST_HANDLE, 
				new HandlerInterceptorPayload(request, response, handler, modelAndView));
		
		if (subject != null)
			subject.notifyMessage(message);
	}
}

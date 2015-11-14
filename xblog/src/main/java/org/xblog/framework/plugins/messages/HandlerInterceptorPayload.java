package org.xblog.framework.plugins.messages;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptorPayload implements XblogPayload {
	
	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private Object handler;
	
	private ModelAndView modelAndView;
	
	private Map<String, Object> extraData = new HashMap<String, Object>();

	public HandlerInterceptorPayload(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		this.setRequest(request);
		this.setResponse(response);
		this.setHandler(handler);
		this.setModelAndView(modelAndView);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Object getHandler() {
		return handler;
	}

	public void setHandler(Object handler) {
		this.handler = handler;
	}

	public ModelAndView getModelAndView() {
		return modelAndView;
	}

	public void setModelAndView(ModelAndView modelAndView) {
		this.modelAndView = modelAndView;
	}

	@Override
	public Object getExtraData(String key) {
		return extraData.get(key);
	}

	@Override
	public void putExtraData(String key, Object object) {
		extraData.put(key, object);
	}
}

package org.xblog.framework.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class XblogController {
	
	@Autowired
	private BinderInitializer binderInitializer;

	@InitBinder
	protected void initDataBinder(HttpServletRequest request, WebDataBinder binder) throws Exception {
		binderInitializer.initDataBinder(request, binder);
	}
}

package org.xblog.framework.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;

public interface BinderInitializer {

	public void initDataBinder(HttpServletRequest request, WebDataBinder binder) throws Exception;
}
